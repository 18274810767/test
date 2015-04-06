package sy.annt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import sy.enums.ExtAreaType;
import sy.enums.ExtType;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtJson {

	Class<?>[] cls();
	
}
