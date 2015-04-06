package sy.annt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import sy.enums.ExtAreaType;
import sy.enums.ExtType;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Ext {

	int[] group();
	ExtType type();
	String label();
	String json() default "";
	boolean required() default false;
	String regx() default "";
	String qianzhui() default "";
	int minValue() default 0;
	int maxValue() default 10;
	int stepValue() default 1;
	String note() default "";
	String place() default "";
	int index();
	ExtAreaType area() default ExtAreaType.none;
	
}
