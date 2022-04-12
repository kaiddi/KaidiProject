package com.kaidi.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;

/**
 * @创建者 ykd
 * @描述
 */
class ReflectionDemo {

    /**
     * 访问私有方法
     */
    public static void accessPrivate() {
        try {
            Class<?> clazz = Class.forName("com.kaidi.demo.People");
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(int.class);
            declaredConstructor.setAccessible(true);
            People people = (People) declaredConstructor.newInstance(12);
            people.show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void getClassRelatedInfo(){
        Class<?> clazz = HashMap.class;
        // 类名
        System.out.println("class name:"+clazz.getCanonicalName());
        // 类访问限定符
        System.out.println(Modifier.toString(clazz.getModifiers()));
        // 类泛型
        TypeVariable[] typeParameters = clazz.getTypeParameters();
        if (typeParameters.length != 0){
            StringBuilder stringBuilder = new StringBuilder("Parameters : ");
            for (TypeVariable typeParameter : typeParameters) {
                stringBuilder.append(typeParameter.getName()).append(" ");
            }
            System.out.println(stringBuilder.toString());
        }

        // 类实现接口
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        if (genericInterfaces.length != 0) {
            StringBuilder interfaces = new StringBuilder("Implemented Interfaces : ");
            for (Type intf : genericInterfaces) {
                interfaces.append(intf.toString());
                interfaces.append(" ");
            }
            System.out.println(interfaces.toString());
        }

        // 父类
        System.out.println("super class name:"+clazz.getSuperclass().getCanonicalName());


        //获取类的注解 很明显,只能获取RUNTIME类型的注解
        Annotation[] annotations = clazz.getAnnotations();
        if (annotations.length != 0) {
            StringBuilder annotation = new StringBuilder("Annotations : ");
            for (Annotation a : annotations) {
                annotation.append(a.toString());
                annotation.append(" ");
            }
            System.out.println(annotation.toString());
        }

    }

}
