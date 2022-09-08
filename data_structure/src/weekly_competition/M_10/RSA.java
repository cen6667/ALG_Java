package weekly_competition.M_10;

/**
 * @author zyc
 * @description:
 */

import java.util.Scanner;

public class RSA {
    //判断是否是素数
    public static boolean isPrime(long n) {
        boolean b = true;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                b = false;
                break;
            } else
                b = true;
        }
        return b;
    }

    //计算欧拉数
    public static long Euler(long p, long q) {
        return (p - 1) * (q - 1);
    }

    //欧几里得算法求两数的最大公因数---a>b
    static long gcd(long a, long b) {
        if (a < b) {
            long t = a;
            a = b;
            b = t;
        }
        if (a % b == 0) return b;
        else return gcd(b, a % b);
    }

    //求模反元素d（私钥）
    public static long Key(long e, long euler) {
        long key = 1;
        while ((key * e) % euler != 1) {
            key++;
        }
        return key;
    }

    //递归求n次方
    public static long power(long a, long n) {
        long r = 1;
        if (n == 0) r = 1;
        else {
            r = a * power(a, n - 1);
        }
        return r;
    }

    //加密
    public static long encryption(long msg, long e, long n) {
        System.out.println("加密中.......");
        return power(msg, e) % n;
    }

    //解密
    public static long decryption(long c, long key, long n) {
        System.out.println("解密中.......");
        return power(c, key) % n;
    }

    public static void main(String[] args) {
        System.out.println("--------RSA--------");
        //两个大素数
        long p;
        long q;
        System.out.print("输入两个大素数p、q：");
        Scanner sc = new Scanner(System.in);
        p = sc.nextLong();
        q = sc.nextLong();
        // System.out.println("p = " + p + ",q = " + q);
        //判断输入的是否是素数
        boolean b;   //flag
        //判断p
        b = isPrime(p);
        if (b == false) {
            System.out.println("p = " + p + "不是素数。重新输入p！");
            p = sc.nextLong();
            b = isPrime(p);
            while (b = false) {
                System.out.println("p = " + p + "不是素数。重新输入p！");
                p = sc.nextLong();
                b = isPrime(p);
            }
        }
        System.out.println(" p = " + p + "是素数。");

        //判断q
        b = isPrime(q);
        if (b == false) {
            System.out.println("q = " + q + "不是素数。重新输入q！");
            q = sc.nextLong();
            b = isPrime(q);
            while (b = false) {
                System.out.println("q = " + q + "不是素数。重新输入q！");
                q = sc.nextLong();
                b = isPrime(q);
            }
        }
        System.out.println(" q = " + q + "是素数。");
        //打印最终的p、q
        System.out.println("p = " + p + ",q = " + q);

        //计算p、q的欧拉数
        long euler = Euler(p, q);
        System.out.println("Euler(p,q) = " + euler);

        //选取最小的公钥e，1<e<euler，且与euler互质
        long e = 2;
        while (gcd(e, euler) != 1 || e > euler || e < 1) {
            e++;
        }
        System.out.println("e = " + e);

        //求出模反元素（私钥）
        long key = Key(e, euler);
        System.out.println("key = " + key);

        //System.out.println(power(2, 2));
        //加密过程
        System.out.println("输入明文：");
        long msg = sc.nextLong();
        System.out.println("明文：" + msg);
        long c = encryption(msg, e, p * q);//密文
        System.out.println("加密后的密文：" + c);
        //解密过程
        msg = decryption(c, key, p * q);
        System.out.println("解密后的明文：" + msg);

    }
}
