package com.nkdark.utils;

import net.lz1998.cq.robot.CQPlugin;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Create by Intellij IDEA
 *
 * @Author: NKDark
 * @Date: create in 2020/9/22 3:01
 * @Description:
 */

public class JarLoadUtil {

    private static Set<String> mods = new HashSet<>();

    public synchronized static Map<Boolean, List<Class<? extends CQPlugin>>> loadJar() {
        List<Class<? extends CQPlugin>> list = new ArrayList<>();
        try {
            String path = "mods";
            File libPath = new File(path);
            if (libPath.isFile()) {
                System.out.println("别搞事奥");
                return null;
            }
            if (!libPath.canRead()) {
                System.out.println("没有读取权限");
                return null;
            }

            File[] jarFiles = libPath.listFiles((dir, name) -> name.endsWith(".jar") || name.endsWith(".zip"));

            if (jarFiles != null) {
                // 从URLClassLoader类中获取类所在文件夹的方法
                // 对于jar文件，可以理解为一个存放class文件的文件夹
                Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                boolean accessible = method.isAccessible();     // 获取方法的访问权限
                try {
                    if (!accessible) {
                        method.setAccessible(true);     // 设置方法的访问权限
                    }
                    // 获取系统类加载器
                    URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
                    for (File file : jarFiles) {
                        URL url = file.toURI().toURL();
                        try {
                            method.invoke(classLoader, url);
                            System.out.printf("读取jar文件[name=%s]\n", file.getName());
                        } catch (Exception e) {
                            System.out.printf("读取jar文件[name=%s]失败\n", file.getName());
                        }
                    }
                } finally {
                    method.setAccessible(accessible);
                }
            }

            scanDirectory(path);

            for (String mod : mods) {
                File f = new File(mod);
                JarFile jarFile = new JarFile(mod);
                Enumeration<JarEntry> entries = jarFile.entries();
                while (entries.hasMoreElements()) {
                    JarEntry jarEntry = entries.nextElement();
                    if (jarEntry.getName().contains(".class")) {
                        //读取jar包里面所有的class
//                        System.out.println(jarEntry.getName());
                        Class c = Class.forName(jarEntry.getName().replace("/", ".").replace(".class", ""));
                        if (CQPlugin.class == c.getSuperclass()) {
                            if (list.size() > 0) {
                                for (Class<? extends CQPlugin> cc : list) {
                                    if (!(cc == c)) {
                                        list.add(c);
                                    }
                                }
                            } else {
                                list.add(c);
                            }
                        }
                    }
                }

            }
        } catch (Exception e) {
            return null;
        }
        Map<Boolean, List<Class<? extends CQPlugin>>> map = new HashMap<>();
        map.put(true, list);
        return map;
    }

    private static void scanDirectory(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的!");
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        scanDirectory(file2.getAbsolutePath());
                    } else {
                        String abPath = file2.getAbsolutePath();
                        if (abPath.endsWith(".jar")) {
                            mods.add(file2.getAbsolutePath());
                        }
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
}
