package ja.ru;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    //ClassLoader
    public static void main(String[] args) {
        TestReflectImpl testReflect = new TestReflectImpl();
        int number = testReflect.getNumber();
        String name = null;
        printData(testReflect);

        try {
            Field field = testReflect.getClass().getDeclaredField("name");
            field.setAccessible(true);
            name = (String)field.get(testReflect);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        printData(testReflect);

        System.out.println("****************************************");

        TestReflectImpl testReflect2 = null;
        Class clazz = null;
        try {
            try {
                clazz = Class.forName(TestReflectImpl.class.getName());
                //для конструктора без параметров
                //testReflect2 = (TestReflectImpl) clazz.newInstance();
                Class[] params = {int.class, String.class};
                //для конструктора с параметрами
                testReflect2 = (TestReflectImpl) clazz.getConstructor(params).newInstance(1, "!!!!");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(testReflect);

        System.out.println("****************************************");

        //получаем все конструкторы и все параметры к ним
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.println(paramType.getName() + " ");
            }
            System.out.println();
        }
    }

    public static void printData(Object myClass){
        try {
            Method method = myClass.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(myClass);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
