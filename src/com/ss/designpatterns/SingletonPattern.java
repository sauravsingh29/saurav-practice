package com.ss.designpatterns;

/**
 * Created by Saurav on 11-04-2017.
 */
public class SingletonPattern {
    private static SingletonPattern _singletonPattern;
    private static Object _lock = new Object();

    private SingletonPattern() {
    }

    public static SingletonPattern getSingletonPattern(){
        if (null == _singletonPattern){
            synchronized (_lock){
                _singletonPattern = new SingletonPattern();
            }
        }
        return _singletonPattern;
    }
}

class SingletonDemo {
    public static void main(String[] args) {
        SingletonPattern singletonPattern = SingletonPattern.getSingletonPattern();
        System.out.println(singletonPattern);
        singletonPattern = SingletonPattern.getSingletonPattern();
        System.out.println(singletonPattern);
    }
}
