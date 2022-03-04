package SE_demo.Father_Override;


class A{
    public void test(){
        fun();
    }

    private void fun(){
        System.out.println("父类的private fun()");
    }
}

class B extends A{
//    @Override  // 方法加了这个注解，那就必须是成功重写父类的方法，否则报错
    public void fun(){
        System.out.println("子类的public fun()");
    }
}

public class demo{
    public static void main(String[] args) throws Exception{
        B b = new B();
        b.test();
        b.fun();
    }
}
// 此时运行结果是调用的父类的private fun()方法。

