package ACM.thread;

/**
 * @author zyc
 * @description: 交替打印
 */
public class Main {
    private static int flag = 1;
    private static Object obj = new Object();

    static class TheadDemo implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (obj){
                    while (flag != 1){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    flag = 2;
                    System.out.println(1);
                    obj.notifyAll();
                }
            }

        }
    }

    static class TheadDemo2 implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (obj){
                    while (flag != 2){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    flag = 1;
                    System.out.println(2);
                    obj.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        TheadDemo th1 = new TheadDemo();
        TheadDemo2 th2 = new TheadDemo2();

        new Thread(th1).start();
        new Thread(th2).start();
    }


}
