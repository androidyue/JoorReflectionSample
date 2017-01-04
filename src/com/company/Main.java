package com.company;

import joor.Reflect;

import java.io.File;
import java.util.ArrayList;

public class Main {
    //Do not Obfuscate code related with reflection.
    public static void main(String[] args) {
	// write your code here
        testCreateInstance();
        testAccessPrivateField();
        testAccessPrivateMethod();
        testAccessPublicField();
    }

    private static void testCreateInstance() {
        String string = Reflect.on(String.class).create("Hello World").get();
        System.out.println("createInstance=" + string);
    }

    private static void testAccessPrivateField() {
        //Reflection.on("helloworld") will cause no such class
        System.out.println("testAccessPrivateField value=" + Reflect.on(String.class).create("HelloWorld").field("value").get());
        //If the class is not accessible, use the string intern form to avoid compilation error.
        System.out.println("testAccessPrivatedField value=" + Reflect.on("java.lang.String").create("WorldHello"));
    }

    private static void testAccessPublicField() {
        char pathSeparatorChar = Reflect.on(File.class).create("/sdcard/droidyue.com").field("pathSeparatorChar").get();
        System.out.println("testAccessPublicField pathSeparatorChar=" + pathSeparatorChar);
    }

    private static void testAccessPrivateMethod() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Hello");
        arrayList.add("World");
        int value = Reflect.on(arrayList).call("hugeCapacity", 12).get();
        System.out.println("testAccessPrivateMethod value=" + value);
    }


}
