package com.coderelated.lld.bookmysow;

import java.util.Date;
import java.util.List;

public class Show {
    enum ShowType{
        THREE_DIMENSION(1,"3D"),
        TWO_DIMENSION(2,"2D"),
        FOUR_DIMENSION(3,"4D");

        private int typeId;
        private String typename;

        ShowType(int typeId,String typename) {
            this.typeId=typeId;
            this.typename = typename;
        }

        public int getTypeId() {
            return typeId;
        }

        public String getTypename() {
            return typename;
        }
    }
    private Movie movie;
    private MovieMall movieMall;
    private Date showTime;
    private MallMovieScreen screen;
    private List<Seat> seats;
    private ShowType showType;
    private Language language;
//    public static void main(String args[]){
//        A a = new A();
//
//        B b = new B(a);
//
//        System.out.println(a.i);
//
//        System.out.println(b.i);
//
//        System.out.println(b.a.i);
//
//        b.a.i = 2121;
//
//        System.out.println("--------");
//
//        System.out.println(a.i);
//
//        System.out.println(b.i);
//    }
}

//class X
//{
//    int i = 101010;
//
//    public X()
//    {
//        i = i++ + i-- - i;
//        System.out.println("hello x construct"+i);
//    }
//
//    static int staticMethod(int i)
//    {
//        System.out.println("hello static::"+i);
//        return --i;
//    }
//}
//
//class Y extends X
//{
//    public Y()
//    {
//        System.out.println(staticMethod(i)+";;"+super.i);
//    }
//}
//
//class A
//{
//    int i = 1212;
//
//    {
//        System.out.println("instance block of A");
//    }
//}
//
//class B extends A
//{
//    A a;
//
//    public B(A a)
//    {
//        this.a = a;
//    }
//}
//
//class ClassOne
//{
//    static int i, j = 191919;
//
//    {
//        System.out.println("class1:instanceblock1:"+i);
//        --i;
//    }
//
//    {
//        System.out.println("class1:instanceblock2:"+j);
//        j++;
//    }
//}
//
//class ClassTwo extends ClassOne
//{
//    static
//    {
//        System.out.println("class2:staticblock1:"+i);
//        i++;
//    }
//
//    static
//    {
//        System.out.println("class2:staticblock:"+j);
//        --j;
//    }
//
//    public static void main(String[] args)
//    {
//        System.out.println(i);
//
//        System.out.println(j);
//    }
//}
//
//class AB
//{
//    int[] a = new int[5];
//
//    {
//        a[0] = 10;
//        System.out.println("AB:a[0]:"+a[0]);
//    }
//}
//
//class MainClass extends AB
//{
//    {
//
//        System.out.println("MainClass:a[0]:"+a[0]);
//        a = new int[5];
//    }
//
//    {
//        System.out.println(a[0]);
//    }
//
//    public static void main(String[] args)
//    {
//        MainClass main = new MainClass();
//    }
//}
//
//class ABC
//{
//    static int i;
//
//    static
//    {
//        System.out.println("ABC");
//        i++;
//    }
//
//    {
//        ++i;
//    }
//}
//
//class BC extends ABC
//{
//    static
//    {
//        System.out.println("BC");
//        --i;
//    }
//
//    {
//        i--;
//    }
//}
//
//class MainClassABC
//{
//    public static void main(String[] args)
//    {
//        System.out.println(new BC().i);
//    }
//}
//
//class MainClass1
//{
//    public MainClass1(int i, int j)
//    {
//        System.out.println(method(i, j));
//    }
//
//    int method(int i, int j)
//    {
//        return i++ + ++j;
//    }
//
//    public static void main(String[] args)
//    {
//        MainClass1 main = new MainClass1(10, 20);
//    }
//}
//
//class Xs
//{
//    static
//    {
//        System.out.println("XS static block");
//        Ys.methodOfY();
//    }
//}
//
//class Ys extends Xs
//{
//    static void methodOfY()
//    {
//        System.out.println("Hi....");
//    }
//}
//
//class MainClassxy
//{
//    public static void main(String[] args)
//    {
//        Ys.methodOfY();
//    }
//}
//
//class ClassOne1
//{
//    static int i = 111;
//
//    int j = 222;
//
//    {
//       // System.out.println("i++ - ++j:"+(i++ - ++j));
//        i = i++ - ++j;
//        System.out.println("i:"+i);
//    }
//}
//
//class ClassTwo2 extends ClassOne1
//{
//    {
//        System.out.println("j:"+j+":i:"+i);
//        j = i-- + --j;
//        System.out.println("j:"+j+":i:"+i);
//    }
//
//    public static void main(String args[]){
//        ClassTwo2 c2 = new ClassTwo2();
//    }
//}
