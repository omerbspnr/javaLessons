package org.csystem.app;

import java.util.ArrayList;

class App {
    public static void main(String [] args)
    {
        IFunction<Integer, Integer> operation = Myclass::pow;
    }
}

class Myclass {
    public static Integer pow(Integer a) { return  a * a;}
}

interface IFunction<T, R> {
    R apply(T t);
}