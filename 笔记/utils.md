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
