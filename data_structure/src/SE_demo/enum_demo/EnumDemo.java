package SE_demo.enum_demo;

public class EnumDemo {
    public static void main(String[] args){
        // 获取索引
        Season s = Season.SPRING;
        System.out.println(s);	//SPRING
        System.out.println(s.ordinal()); // 0，该值代表索引，summer 就是 1
        s.doSomething();
        // 获取全部枚举
        Season[] ss = Season.values();
        for(int i = 0; i < ss.length; i++){
            System.out.println(ss[i]);
        }

        int result = Season.SPRING.compareTo(Season.WINTER);
        System.out.println(result);//-3
    }
}
enum Season {
    SPRING , SUMMER , AUTUMN , WINTER;

    public void doSomething() {
        System.out.println("hello ");
    }
}
