package com.company;

import joor.Reflect;

import java.util.ArrayList;

public class Main {
    //Do not Obfuscate code related with reflection.
    public static void main(String[] args) {
	// write your code here
        testCreateInstance();
        testAccessPrivateField();
        testAccessPrivateMethod();
    }

    private static void testCreateInstance() {
        String string = Reflect.on(String.class).create("Hello World").get();
        System.out.println("createInstance=" + string);
    }

    private static void testAccessPrivateField() {
        //Reflection.on("helloworld") will cause no such class
        System.out.println("testAccessPrivateField value=" + Reflect.on(String.class).create("HelloWorld").field("value").get());
    }

    private static void testAccessPrivateMethod() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Hello");
        arrayList.add("World");
        int value = Reflect.on(arrayList).call("hugeCapacity", 12).get();
        System.out.println("testAccessPrivateMethod value=" + value);
    }


}
