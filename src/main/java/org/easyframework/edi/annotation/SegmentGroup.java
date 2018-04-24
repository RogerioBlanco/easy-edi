package org.easyframework.edi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SegmentGroup
{
	public Segment[] segments();

	public int startPosition();

	public int maxUsage();

}
