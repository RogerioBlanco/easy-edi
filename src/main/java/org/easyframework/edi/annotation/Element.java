package org.easyframework.edi.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.easyframework.edi.constant.Usage;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Element
{

	public int group();

	public int position();

	public int max();

	public Usage usage() default Usage.MANDATORY;

}
