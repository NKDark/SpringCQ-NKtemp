package com.nkdark.utils;

import net.lz1998.cq.robot.CQPlugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Create by Intellij IDEA
 *
 * @Author: NKDark
 * @Date: create in 2020/9/20 3:41
 * @Description:
 */

public class ModScanUtil {

    private static Set<String> mods = new HashSet<>();

    public static String getMods() {
        String path = "mods";
        File f = new File(path);
        if (f.isFile()) {
            System.out.println("别搞事奥");
            return null;
        }
        if (f.canRead() && f.canWrite()) {
            scanDirectory(path);
        }
        return null;
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

    public static void main(String[] args) throws Exception {
        Set<Class<? extends CQPlugin>> plugins = new HashSet<>();
        getMods();
        System.out.println(mods.size());
        for (String mod : mods) {
//            System.out.println(mod);
            File f = new File(mod);
            JarFile jarFile = null;
                jarFile = new JarFile(mod);
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {

                JarEntry jarEntry = entries.nextElement();
                if (jarEntry.getName().contains(".class")) { //读取res文件夹和res文件夹下的所有文件，\
//                    System.out.println(jarEntry);
                    //在读取aa.txt文件时，投机取巧了一下，直接写死为aa.txt，但是循环读取多个文件，不知道文件名，需要截取目标文件的名字
//                    String[] split = jarEntry.getName().split("/");
//                    System.out.println(split[split.length - 1]);
                    System.out.println(jarEntry.getName());
                    Class c = Class.forName(jarEntry.getName().replace("/",".").replace(".class",""));
                    if (CQPlugin.class == c.getSuperclass()){
                        System.out.println("yes");
                    }
                }
            }
        }
    }
}