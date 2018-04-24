package org.easyframework.edi.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.easyframework.edi.constant.Usage;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Segment
{

	public String value();

	public int position();

	public int maxUsage() default 1;

	public Usage usage() default Usage.MANDATORY;

}
