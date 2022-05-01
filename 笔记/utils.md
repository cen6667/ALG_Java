## 数组排序

```java
Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
//Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));
```

对数组进行排序

```java
// 身高从大到小排（身高相同k小的站前面）
Arrays.sort(people, (a, b) -> {
    if (a[0] == b[0]) return a[1] - b[1];
    return b[0] - a[0];
});
//Lambda表达式为Comparator接口进行实例化，自定义排序规则
//        public static <T> void sort(T[] a, Comparator<? super T> c) {
//            if (c == null) {
//                sort(a);
//            } else {
//                if (Arrays.LegacyMergeSort.userRequested)
//                    legacyMergeSort(a, c);
//                else
//                    TimSort.sort(a, 0, a.length, c, null, 0, 0);
//            }
//        }

//        降序排列：obj1-obj2>0的话返回-1，说明按照从大到小排序b-a
//        升序排列：obj1-obj2>0的话返回1，说明按照从小到大排序a-b
```

为了防止int溢出，比如这个数据{{-2147483646,-2147483645},{2147483646,2147483647}}

```java
// 身高从大到小排（身高相同k小的站前面）
// 写的排序语句，不要超过了int的范围
Arrays.sort(points, (a, b) -> {
    if (a[0] == b[0]) {
        if(a[1] >= b[1]) return 1;
        else return -1;
    }
    else if(a[0] > b[0]) return 1;
    else return -1;
});
```



## 字符串截取

 substring(int beginIndex, int endIndex) 返回一个字符串，该字符串是此字符串的子字符串。  

```java
String str = s.substring(startindex, i + 1);
```



## hashmap计数

```java
for (int i = 0; i < tasks.length; i++) {
    if (maps.containsKey(tasks[i])) {
        maps.put(tasks[i], maps.get(tasks[i]) + 1);
    } else {
        maps.put(tasks[i], 1);
    }
}
```

## 26个字母hash

```java
int[] edge = new int[26];//字母hash
```

## 字符串变字典

```java
char[] chars = S.toCharArray();
```

## 打印数组

```java
Arrays.toString(nums)
```

## 把数组保存到链表（new）

```java
res.add(new int[]{start, end});
```

## 数组变List

### 最佳

```java
int[] ints = {2, 34, 55, 22, 11};
List<Integer> weightList = Arrays.stream(ints).boxed().collect(Collectors.toList());
System.out.println(weightList);
```



### new ArrayList<>(Arrays.asList())

注意Arrays.asList()输出的是不可变的List，必须重新new一个

```java
String[] str = {"fgx", "lzy"};
ArrayList<String> strings = new ArrayList<>(Arrays.asList(str));
strings.add("aop");
System.out.println(strings);

Integer[] i = {1,2};
ArrayList<Integer> li = new ArrayList<>(Arrays.asList(i));
li.add(3);
System.out.println(li);

/*
输出：
[fgx, lzy, aop]
[1, 2, 3]
*/
```

int[]数组不能使用

为什么int[]不能直接转为List,而Integer[]可以转为List,而Integer[]就可以转为List了,因为List中的泛型必须是引用类型。



### Collections.addAll

 通过`Collections.addAll(arrayList, strArray)`方式转换，根据数组的长度创建一个长度相同的List，然后通过`Collections.addAll()`方法，将数组中的元素转为二进制，然后添加到List中，这是最高效的方法。

```java
 public static void Demo3() {
        String[] str = {"fgx", "lzy"};
        ArrayList<String> stringList = new ArrayList<>(str.length);
        Collections.addAll(stringList,str);
    }

```



### 流Stream

```java
int[] ints = {2, 34, 55, 22, 11};
long[] longs = {1, 2, 3};
double[] doubles = {1, 2, 3};
Arrays.stream(ints).boxed().collect(Collectors.toList());
Arrays.stream(longs).boxed().collect(Collectors.toList());
Arrays.stream(doubles).boxed().collect(Collectors.toList());

```





## int[]转Integer[]

```java
//初始化int数组
int[] nums = {1,2,3,4,5,6};
//将int数组转换为数值流
IntStream stream = Arrays.stream(nums);
//流中的元素全部装箱，转换为Integer流 
Stream<Integer> integerStream = stream.boxed();
//将流转换为数组
Integer[] integers = integerStream.toArray(Integer[]::new);
```

上面是分解步骤，实际应用中一行代码即可解决

```java
Integer newNums[] = Arrays.stream(nums).boxed().toArray(Integer[]::new);
```

## 字符串截取

```java
StringBuilder sb = ``new` `StringBuilder(``"name=Marydon&sex=男&age=18&"``);
System.out.println(``"StringBuilder去除最后一个字符》方式一："` `+ sb.substring(0,sb.length() - 1));
```
