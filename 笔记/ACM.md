# ACM模式需要的方法

# 首先

```java
import java.io.*;
import java.util.*;
import java.lang.*;
```



```java
使用语言：JAVA
参考正解代码如下：

import java.util.*;
class Main{
    public static void main(String args[]){
        int m;
        double sum,n;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            n=sc.nextInt();
            m=sc.nextInt();
            sum=0;
            for(int i=0;i<m;i++){
                sum=sum+n;
                n=Math.sqrt(n);
            }
            System.out.printf("%.2f",sum);
            System.out.println();
        }
    }
}

```



# 输入

## 创建类

```java
Scanner s = new Scanner(System.in);
```

## 数字读取

```
int count = s.nextInt();
```

## 字符串读取

```java
String[] arr = new String[n];
for(int i = 0;i<n;i++){
	arr[i]=sc.next();
}
```





# 输出



字符串输出

```java
System.out.println(String.join(" ",arr));
```



# 文章

## 输入输出

### 引用



```java
import java.util.Scanner;

//多行输入时
static Scanner in = new Scanner(System.in);
while(in.hasNextInt())
//或者
while(in.hasNext())
```



### 输入格式

```java
//输入
Scanner sc = new Scanner(new BufferedInputStream(System.in)); //法1
Scanner sc = new Scanner(System.in);

//读入整数
int n = sc.nextInt();
//读入字符串
String s = sc.next();
//读入一个浮点数
double t = sc.nextDouble();
//读一整行
String s = sc.nextLine();
//判断是否有下个输入可以用
sc.hasNext() sc.hasNextInt() sc.hasNextDouble() sc.hasNextLine()
```



+ nextInt()： 读取数值，剩下"\n"还没有读取，并将Scanner类读取依靠的cursor放在数值后面，"\n"前面，因此如果用nextInt()读取后，再用nextLine()读取，读取到的是换行符。nextInt()是忽略回车和空格直到遇到第一个数字开始录入，只会把数字录入cache，遇到空格或者回车结束nextInt()的输入。
+ next() : 读取字符串。next() 方法遇见第一个有效字符（非空格，非换行符）时，开始扫描，当遇见第一个分隔符或结束符(空格或换行符)时，结束扫描，获取扫描到的内容
+ nextLine()：如果要读取带空格的一串字符串还是需要使用nextLine()，而非next()方法。可以扫描到一行内容并作为一个字符串而被获取到



### 输出格式



```java
System.out.println();//换行打印，输出之后会自动换行
System.out.print();//不换行打印
System.out.printf();//按格式输出
```


对于printf

```java
/*** 输出字符串 ***/
// %s表示输出字符串，也就是将后面的字符串替换模式中的%s
System.out.printf("%s", new Integer(1212));
// %n表示换行
System.out.printf("%s%n", "end line");
// 还可以支持多个参数
System.out.printf("%s = %s%n", "Name", "Zhangsan");
// %S将字符串以大写形式输出
System.out.printf("%S = %s%n", "Name", "Zhangsan");


/*** 输出整数类型***/
Integer iObj = 342;
// %d表示将整数格式化为10进制整数
System.out.printf("%d; %d; %d%n", -500, 2343L, iObj);
// %o表示将整数格式化为8进制整数
System.out.printf("%o; %o; %o%n", -500, 2343L, iObj);
// %x表示将整数格式化为16进制整数
System.out.printf("%x; %x; %x%n", -500, 2343L, iObj);
// %X表示将整数格式化为16进制整数，并且字母变成大写形式
System.out.printf("%X; %X; %X%n", -500, 2343L, iObj);

/*** 输出浮点类型***/
Double dObj = 45.6d;
// %f表示以十进制格式化输出浮点数
System.out.printf("%f; %f; %f%n", -756.403f, 7464.232641d, dObj);
// 还可以限制小数点后的位数
System.out.printf("%.1f; %.3f; %f%n", -756.403f, 7464.232641d, dObj);
```





## 常见输入输出处理

### 输入数据有多组，每组占2行，第一行为一个整数N，指示第二行包含N个实数。

```java
public static void main(String[] args) {
 Scanner in = new Scanner(System.in);
 while(in.hasNextInt()) {
     int n = in.nextInt();
     for(int i = 0; i < n; i++) {
         double a = in.nextDouble();
     }
 }
}
```



### 输入数据有多组，每组占一行，数据格式为YYYY/MM/DD组成

```java
public static void main(String[] args) {
 Scanner in = new Scanner(System.in);
 String str = in.nextLine();
 String[] date = str.split("/");
 int y = Integer.parseInt(date[0]);
 int m = Integer.parseInt(date[1]);
 int d = Integer.parseInt(date[2]);
 }
}
```



### 输入一行数字，用空格隔开，输出int[]

来源

```java
//String转String数组转int数组转List「Integer」
String ids = "1,2,3,4,5,6";
String[] iidsStrings = ids.split(",");//转成String数组
int[] array = Arrays.stream(iidsStrings).mapToInt(Integer::parseInt).toArray();//转int数组
List<Integer> list2 = Arrays.stream(array).boxed().collect(Collectors.toList());//转List<Integer>

```



### 解析逗号分隔符的字符串

输入用逗号分隔的字符串： 1,5,9,6,5,7,2
想要接收后变成int类型数组

```java
String str = sc.next();
String[] arr = str.split(","); //通过分隔符将其转为字符串数组
int[] nums = new int[arr.length];
for (int i = 0; i < nums.length; i++) {
    nums[i] = Integer.parseInt(arr[i]); //将字符串转为int
}
```



这里提一下parseInt()与valueOf()的区别：
Integer.parseInt(str)返回值是int型的；
Integer.valueOf(str)返回值是Integer型的。

### nextInt转nextLine接收

假设输入为:
3
a 10 1 2
b 10 2
c 10 3
第一行是是数字n，表示下面有n行输入，下面的n行有字母，也有数字，字母只是标识符，不参与运算，数字的个数不固定，每一行的数字需要用List存储下来，最后将每一行的List放入一个大的List中。



```java
//错误代码
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); //需要在后面添加sc.nextLine();换到下一行
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
    List<Integer> list = new ArrayList<>();
    String[] inputs = sc.nextLine().split(" ");

    for (int j = 1; j < inputs.length; j++) {
        list.add(Integer.valueOf(inputs[j]));
    }
    adj.add(list);
}
```



后果：adj的第一个元素是一个空ArrayList，输入的最后一组数据没有接收到。
原因：当执行int n = sc.nextInt();后，光标还停留在第一行，下面就直接执行sc.nextLine()来接收输入了，这样接收的只是第一行n后面的空字符串！
解决方法：在int n = sc.nextInt();后添加sc.nextLine();直接换行

### 其它注意点

多组测试数据：
如果出现多组测试数据放在一起的情况，直接在最外层套while(sc.hasNext())，每组测试数据进入一次while循环，运行一次主函数。一直等待输入，除非终止程序。
高精度：
函数：add, subtract, divide, mod, compareTo等，其中加减乘除模都要求是BigInteger(BigDecimal)和BigInteger(BigDecimal)之间的运算，所以需要把int(double)类型转换为BigInteger(BigDecimal)，用函数BigInteger.valueOf()。
