package homework7annotation;
//Малыгин Андрей, домашнее задание к 7 уроку Java3.
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //аннотация может использоваться во время выполнения,
//через Reflection.
@Target(ElementType.METHOD) //целью нашей аннотации является метод
public @interface BeforeSuite {
    String before();
}
