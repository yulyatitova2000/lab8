package org.example;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ReflectionDemo {
    public static int getCountHuman(List<?> listObjects ){
        int result = 0;
        for (Object listObject : listObjects) {
            if (listObject instanceof Human) {
                result++;
            }
        }
        return result;
    }
    public static List<String> getMethodName(Object object){
        Class<?> classObject = object.getClass();
        List<String> result = new ArrayList<>();
        Method[] methods = classObject.getMethods();
        for(Method method : methods){
            if(Modifier.isPublic(method.getModifiers())){
                result.add(method.getName());
            }
        }
        return result;
    }

    public static List<String> getListSuperClass(Object object) {
        Class<?> classObject = object.getClass();
        List<String> result = new ArrayList<>();
        while (classObject.getSuperclass() != null) {
            classObject = classObject.getSuperclass();
            result.add(classObject.getName());
        }
        return result;
    }
}

