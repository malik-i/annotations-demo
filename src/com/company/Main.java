package com.company;

// Marker Annonation (if you have no values)
// Single Value Annotation (If you have one value)
// Multi Value Annotation (If you have more than 1 value)

import java.lang.annotation.*;

// Creating an annotation
    // Need these two Annoations
@Target(ElementType.TYPE) // use TYPE to target classes and interfaces
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone{
    String os() default "Symbian";
    int version() default 1;
}

@SmartPhone(os="Android", version = 6)
class NokiaASeries {
    String model;
    int size;

    public NokiaASeries(String model, int size) {
        this.model = model;
        this.size = size;
    }
}
public class Main {

    public static void main(String[] args) {
        NokiaASeries obj = new NokiaASeries("Fire", 5);
        System.out.println(obj.model);
        // how to access the annotation values
        Class c = obj.getClass();
        Annotation an = c.getAnnotation(SmartPhone.class);
        SmartPhone s = (SmartPhone)an;
        System.out.println(s.os());
    }
}
