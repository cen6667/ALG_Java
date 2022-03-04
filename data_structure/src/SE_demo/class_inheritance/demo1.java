package SE_demo.class_inheritance;

public class demo1 {
    public static void main(String[] args) {
        Wolf w = new Wolf("wolf");
        w.showName();
    }
}
class Wolf extends Animal{
    private String name = "子类狼";
    public Wolf(String name){
        name3 = name;
        System.out.println("子类构造方法" + name3);
    }

    public void showName(){
        String name = "局部名称";
        System.out.println(name); // 局部name
        System.out.println(this.name); // 子类对象的name
        System.out.println(super.name); // 父类的
        System.out.println(name1); // 父类的
        //System.out.println(pname); // 报错。子类不可以继承父类的私有成员
        //System.out.println(name2); // 报错。子类父类都没有
    }
}

class Animal{
    private String pname = "私有成员";
    public static String name = "父类动物名称";
    public String name1 = "父类";
    public String name3 = "";
    public Animal(){
        System.out.println("父类构造方法");
    }
    public Animal(String name3){
        System.out.println("父类构造方法"+ name3);
    }
}