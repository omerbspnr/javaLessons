package org.csystem.app;
import org.csystem.samples.asciiimage.AsciiImageApp;
import org.csystem.util.NumberUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
public class App {
    public static void main(String[] args)
    {
        AsciiImageApp.run();
    }
}

class A {
    public void foo(int a){}
}

class B extends  A {
    public void foo(int b){}

}