# ALG_Java

## 目标

+ 数据结构与算法ACM模式
+ 每个解法要标注时间复杂度和空间复杂度
+ 学会使用库函数
+ 学会不使用库函数



# 理解

## 数组

**数组是存放在连续内存空间上的相同类型数据的集合。**

+ **数组下标都是从0开始的。**
+ **数组内存空间的地址是连续的**



### 二分法

+ 二分法时间复杂度：O(logn)

在这道题目中我们讲到了**循环不变量原则**，只有在循环中坚持对区间的定义，才能清楚的把握循环中的各种细节。

**二分法是算法面试中的常考题，建议通过这道题目，锻炼自己手撕二分的能力**。



### 双指针法



### 滑动窗口



### 模拟行为





## 链表



## 哈希表



## 字符串





# 算法小妙招

## 综合

+ 递归有从前向后法和从后向前法，注意参数传递；



## 链表

+ 添加虚拟头节点dummyHead，输出一般都为dummyHead.next，也不用担心链表为空的情况；
+ 双指针并不仅仅是两个指针，反正指针是O(1)，怎么方便怎么来，多加几个没问题；
+ 题目中有“倒数第n个”的，可以考虑快慢指针先间隔n，再遍历；
+ 链表是否成环，理解 x = ( n - 1 ) ( y + z ) + z

## 哈希表

+ int[] nums = new int[26]; 就是最简单的哈希，真哈希表。
+ 剪枝是去重，或者提高性能的方法  if (i > k + 1 && nums[i] == nums[i - 1]) continue;
+ Set<Integer> sum = new HashSet<>(); 哈希Set集合，无重复
+ List<String> result = new ArrayList<>(); List集合，有重复
+ Map<Integer, Integer> map = new HashMap<>(); Map集合是一种双列集合，每个元素包含两个值。
+ List<List<Integer>> result = new ArrayList<>(); result.add(Arrays.asList(nums[i], nums[left], nums[right]));



## 字符串

+ String用toCharArray() 方法变数组，就可以用增强型for循环了，省很多事情
+ StringBuilder 的 append()方法很常用
+ 正则匹配连续的空白字符作为分隔符分割 List<String> wordList = Arrays.asList(s.split("\\s+"));
+ 把字符串分隔成数组 String[] strArray = s.split(" ");
+ StringBuffer setCharAt 是用来替换的，方法里面有两个参数 setCharAt(int index,Char ch),第一个参数是取代的位置 索引从0开始 第二个参数是你要替换为的字符串；
