package com.nkdark.utils;

import net.lz1998.cq.robot.CQPlugin;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Create by Intellij IDEA
 *
 * @Author: NKDark
 * @Date: create in 2020/9/20 5:19
 * @Description:
 */

public class MyClassLoader {
    public static void main(String[] args) throws Exception {
        classLoader();
    }

    public static void classLoader() throws Exception {
        String path = "C:\\Users\\NKDark\\Desktop\\EntertainmentAlpha\\mods\\modTest-1.0-SNAPSHOT.jar";
        Set<Class<?>> classes = new LinkedHashSet<Class<?>>();//所有的Class对象
        Map<Class<?>, Annotation[]> classAnnotationMap = new HashMap<Class<?>, Annotation[]>();//每个Class对象上的注释对象
        Map<Class<?>, Map<Method, Annotation[]>> classMethodAnnoMap = new HashMap<Class<?>, Map<Method, Annotation[]>>();//每个Class对象中每个方法上的注释对象

        try {
            File file = new File(path);
            URL url = new URL("file:"+path);
            URLClassLoader myClassLoader1 = new URLClassLoader(new URL[] { url }, Thread.currentThread()
                    .getContextClassLoader());
            Class<?> myClass1 = myClassLoader1.loadClass("com.nkdark.Test");
            Object o = myClass1.newInstance();

            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
