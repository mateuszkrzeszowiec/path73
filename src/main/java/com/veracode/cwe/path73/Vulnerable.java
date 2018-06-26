package com.veracode.cwe.path73;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Vulnerable {
    public static void main(String [] args) throws IOException  {


        final String ABSOLUTE_PATH = "/Users/intendeduser/../mkrzeszowiec/dummy";
        final String RELATIVE_PATH = "../../../../../mkrzeszowiec/dummy";

        System.out.println("#####################################");
        System.out.println("Testing with absolute path - " + ABSOLUTE_PATH);
        testPath(ABSOLUTE_PATH);
        System.out.println("#####################################");
        System.out.println("Testing with relative path - " + RELATIVE_PATH);
        testPath(RELATIVE_PATH);
    }

    private static void testPath(String path) throws IOException {
        File f = new File(path);

        System.out.println("getCanonicalPath");

        System.out.println(f.getCanonicalPath());
        System.out.println(Paths.get(f.getCanonicalPath()).toAbsolutePath());
        System.out.println(Paths.get(f.getCanonicalPath()).toAbsolutePath().normalize());
        System.out.println(Paths.get(f.getCanonicalPath()).toRealPath());
        System.out.println(Paths.get(f.getCanonicalPath()).toRealPath().normalize());

        System.out.println("getCanonicalFile");

        System.out.println(f.getCanonicalFile());
        System.out.println(Paths.get(f.getCanonicalFile().getPath()).toAbsolutePath());
        System.out.println(Paths.get(f.getCanonicalFile().getPath()).toAbsolutePath().normalize());
        System.out.println(Paths.get(f.getCanonicalFile().getPath()).toRealPath());
        System.out.println(Paths.get(f.getCanonicalFile().getPath()).toRealPath().normalize());


        System.out.println("getAbsolutePath");

        System.out.println(f.getAbsolutePath());
        System.out.println(Paths.get(f.getAbsolutePath()).toAbsolutePath());
        System.out.println(Paths.get(f.getAbsolutePath()).toAbsolutePath().normalize());
        try {
            System.out.println(Paths.get(f.getAbsolutePath()).toRealPath());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(Paths.get(f.getAbsolutePath()).toRealPath().normalize());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }



        System.out.println("getAbsoluteFile");

        System.out.println(f.getAbsoluteFile());
        System.out.println(Paths.get(f.getAbsoluteFile().getPath()).toAbsolutePath());
        System.out.println(Paths.get(f.getAbsoluteFile().getPath()).toAbsolutePath().normalize());

        try {
            System.out.println(Paths.get(f.getAbsoluteFile().getPath()).toRealPath());
        } catch(IOException e) {
            System.out.println(e);
        }

        try {
            System.out.println(Paths.get(f.getAbsoluteFile().getPath()).toRealPath().normalize());
        } catch(IOException e) {
            System.out.println(e);
        }

    }
}
