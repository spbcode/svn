package com.coderelated.innerclasses;

public class innerclasspractise {

}

class X
{
    int x = 111;

    static class Y extends X
    {
        int y = x + 222;
    }

    class Z extends X.Y
    {
        int z = y + 333;
    }
}

 class MainClass
{
    public static void main(String[] args)
    {
//        X.Z z = new X().new Z();
//
//        System.out.println(z.x);
//
//        System.out.println(z.y);
//
//        System.out.println(z.z);

        C c = new C();
    }
}

class A
{
    class B
    {
        public B() {
            System.out.println("B constructor");
        }
    }
}

class C extends A.B
{
    public C()
    {
        //Invoking super class constructor through outer class instance

        new A().super();
    }
}

class ABC
{
    class XYZ
    {
        String s = "Inner - XYZ";
    }
}

class XYZ extends ABC
{
    String s = "Outer - XYZ";

    class ABC extends XYZ
    {

    }
}

class MainClass1
{
    public static void main(String[] args)
    {
        System.out.println(new XYZ().new ABC().s);
    }
}