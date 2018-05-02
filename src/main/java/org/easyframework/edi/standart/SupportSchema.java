package org.easyframework.edi.standart;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import org.easyframework.edi.annotation.Element;
import org.easyframework.edi.annotation.Root;
import org.easyframework.edi.annotation.Segment;
import org.easyframework.edi.annotation.SegmentGroup;
import org.easyframework.edi.schema.ElementSchema;
import org.easyframework.edi.schema.RootSchema;
import org.easyframework.edi.schema.Schema;
import org.easyframework.edi.schema.SegmentGroupSchema;
import org.easyframework.edi.schema.SegmentSchema;
import org.easyframework.edi.schema.exception.SchemaException;
import org.easyframework.edi.schema.factory.DefaultElementFactory;
import org.easyframework.edi.schema.factory.Factory.ElementFactory;

public class SupportSchema
{

	private final ConcurrentHashMap<Class<?>, Schema> cache;

	public SupportSchema()
	{
		this.cache = new ConcurrentHashMap<>();
	}

	public <T> Schema fetch(Class<T> type)
	{
		if (type == null)
			throw new NullPointerException();

		Schema schema = cache.get(type);

		if (schema == null)
			schema = cache.put(type, createRootSchema(type));

		return schema;
	}

	private Schema fetch(Field field)
	{
		Schema schema = cache.get(field.getType());

		if (schema != null)
			return schema;

		if (field.isAnnotationPresent(Segment.class))
			schema = createSegmentSchema(field.getType(), field, field.getAnnotation(Segment.class));

		if (field.isAnnotationPresent(SegmentGroup.class))
			schema = createSegmentGroupSchema(field.getType(), field, field.getAnnotation(SegmentGroup.class));

		if (field.isAnnotationPresent(Element.class))
			schema = createElementSchema(field.getType(), field, field.getAnnotation(Element.class));

		return cache.put(field.getType(), schema);
	}

	private <T> Schema createRootSchema(Class<T> type)
	{
		int mod = type.getModifiers();

		if (Modifier.isAbstract(mod) || Modifier.isInterface(mod))
			throw new SchemaException("Isn't possible to create a schema from an interface nor abstract class.");

		if (!type.isAnnotationPresent(Root.class))
			throw new SchemaException("Isn't possible to create a schema from a class without annotation Root.");

		List<Field> segments = listInherentFields(type, Segment.class, SegmentGroup.class);

		if (segments == null || segments.isEmpty())
			throw new SchemaException("Isn't possible to create a root schema that doesn't contains a Segment or Segment Group annotation.");

		RootSchema root = new RootSchema();

		for (Field segment : segments)
			root.addSegment(fetch(segment));

		return root;
	}

	private Schema createSegmentGroupSchema(Class<?> type, Field field, SegmentGroup segmentGroup)
	{
		SegmentGroupSchema schema = new SegmentGroupSchema();

		List<Field> segments = listInherentFields(field.getType(), Segment.class);

		for (Field segment : segments)
			schema.addSegment(fetch(segment));

		return schema;
	}

	private Schema createSegmentSchema(Class<?> type, Field field, Segment segment)
	{
		SegmentSchema schema = new SegmentSchema();

		List<Field> elements = listInherentFields(field.getType(), Element.class);

		for (Field element : elements)
			schema.addElement(fetch(element));

		return schema;
	}

	private Schema createElementSchema(Class<?> type, Field field, Element element)
	{
		Class<? extends ElementFactory<?>> factoryType = element.factory();

		int mod = type.getModifiers();

		boolean needCustomFactory = Modifier.isAbstract(mod) || Modifier.isInterface(mod);

		boolean isCustomFactory = !DefaultElementFactory.None.class.equals(factoryType);

		if (needCustomFactory && isCustomFactory)
			throw new SchemaException("Isn't possible instantiate the %s class because don't have a cutom factory.", type.getName());
		
		if(!isCustomFactory)
			factoryType = DefaultElementFactory.fetchFactory(type, field);
		
		ElementFactory<?> factory = DefaultElementFactory.newInstance(factoryType, type);
		
		ElementSchema schema = new ElementSchema(element, field, factory);
		
		return schema;
	}

	@SuppressWarnings("unchecked")
	private <T> List<Field> listInherentFields(final Class<T> type, final Class<? extends Annotation>... annotations)
	{
		return new Function<Class<?>, List<Field>>() {
			@Override
			public List<Field> apply(Class<?> clazz)
			{
				List<Field> fields = new ArrayList<>();

				if (Object.class != clazz.getSuperclass())
					fields.addAll(apply(clazz.getSuperclass()));

				for (Field field : clazz.getDeclaredFields())
				{
					int mod = field.getModifiers();

					if (!Modifier.isFinal(mod) && !Modifier.isStatic(mod) && !Modifier.isTransient(mod))
					{
						boolean add = Boolean.TRUE;

						if (annotations != null && annotations.length > 0)
						{
							add = Boolean.FALSE;
							for (Class<? extends Annotation> annotation : annotations)
								if ((add = field.isAnnotationPresent(annotation)))
									break;

						}

						if (add)
							fields.add(field);
					}
				}

				return fields;

			}
		}.apply(type);
	}

}
