package ACM.thread;

/**
 * @author zyc
 * @description: 多线程测试
 */
public class demo {
    public static void main(String[] args) throws InterruptedException {
        FooBar fb = new FooBar(2);
        new Thread(() -> {
            try {
                fb.foo(()->{
                    System.out.println("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(()-> {
            try {
                fb.bar(()->{
                    System.out.println("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
