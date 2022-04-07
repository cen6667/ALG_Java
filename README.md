# ALG_Java

# 目标

+ 数据结构与算法ACM模式
+ 每个解法要标注时间复杂度和空间复杂度
+ 学会使用库函数
+ 学会不使用库函数

# 易错点

+ 需要多次输出非基本数据类型时，一定要new啊，否则后面的操作会改变它的（特别重要，例如输出为List<List<String>>，里面是引用，必须new）
+ 回溯每个点都要回溯，不要跳过回溯否则平添麻烦
+ 以后另外写的递归函数一定好好起名字，要不然会乱
+ 



# 节省空间

+ 成员变量，放方法里初始化比较省空间
+ 使用接口实现类，比类实现对象使用的空间小，加载的方法少
+ LinkedList比ArrayList增删更快，除了访问比较多的时候
+ 用StringBuffer代替字符串相加。



# 小妙招

+ 如果递归不想新增参数，就把参数变成成员变量，就不用输入了



# 理解

## 数组

**数组是存放在连续内存空间上的相同类型数据的集合。**

+ **数组下标都是从0开始的。**
+ **数组内存空间的地址是连续的**



### 二分法

+ 二分法时间复杂度：O(logn)

在这道题目中我们讲到了**循环不变量原则**，只有在循环中坚持对区间的定义，才能清楚的把握循环中的各种细节。

**二分法是算法面试中的常考题，建议通过这道题目，锻炼自己手撕二分的能力**。

#### 二分法第一种写法

第一种写法，我们定义 target 是在一个在左闭右闭的区间里，**也就是[left, right] （这个很重要非常重要）**。

区间的定义这就决定了二分法的代码应该如何写，**因为定义target在[left, right]区间，所以有如下两点：**

+ while (left <= right) 要使用 <= ，因为left == right是有意义的，所以使用 <=
+ if (nums[middle] > target) right 要赋值为 middle - 1，因为当前这个nums[middle]一定不是target，那么接下来要查找的左区间结束下标位置就是 middle - 1

例如在数组：1,2,3,4,7,9,10中查找元素2，如图所示：

![704.二分查找](img/20210311153055723.jpg)



#### 二分法第二种写法

如果说定义 target 是在一个在左闭右开的区间里，也就是[left, right) ，那么二分法的边界处理方式则截然不同。

有如下两点：

+ while (left < right)，这里使用 < ,因为left == right在区间[left, right)是没有意义的
+ if (nums[middle] > target) right 更新为 middle，因为当前nums[middle]不等于target，去左区间继续寻找，而寻找区间是左闭右开区间，所以right更新为middle，即：下一个查询区间不会去比较nums[middle]

在数组：1,2,3,4,7,9,10中查找元素2，如图所示：（**注意和方法一的区别**）

![704.二分查找1](img/20210311153123632.jpg)





### 双指针法

+ 双指针时间复杂度：O(n)O(n)

这道题目迷惑了不少同学，纠结于数组中的元素为什么不能删除，主要是因为以下两点：

+ 数组在内存中是连续的地址空间，不能释放单一元素，如果要释放，就是全释放（程序运行结束，回收内存栈空间）。

双指针法（快慢指针法）在数组和链表的操作中是非常常见的，很多考察数组和链表操作的面试题，都使用双指针法。

### 滑动窗口

+ 滑动窗口时间复杂度：O(n)

本题中，主要要理解滑动窗口如何移动 窗口起始位置，达到动态更新窗口大小的，从而得出长度最小的符合条件的长度。

**滑动窗口的精妙之处在于根据当前子序列和大小的情况，不断调节子序列的起始位置。从而将O(n2)O(n2)的暴力解法降为O(n)。**

如果没有接触过这一类的方法，很难想到类似的解题思路，滑动窗口方法还是很巧妙的。



### 模拟行为

模拟类的题目在数组中很常见，不涉及到什么算法，就是单纯的模拟，十分考察大家对代码的掌控能力。

在这道题目中，我们再一次介绍到了**循环不变量原则**，其实这也是写程序中的重要原则。

相信大家又遇到过这种情况： 感觉题目的边界调节超多，一波接着一波的判断，找边界，踩了东墙补西墙，好不容易运行通过了，代码写的十分冗余，毫无章法，其实**真正解决题目的代码都是简洁的，或者有原则性的**，大家可以在这道题目中体会到这一点。

比如：坚持左闭右开的原则

# 



## 链表



## 哈希表



## 字符串

### KMP

next数组前后缀意思是顺序相同，不是镜像，isisp最大公共前后缀为2，issip最大公共前后缀为1





# 算法小妙招

## 综合

+ 递归有从前向后法和从后向前法，注意参数传递；

## 递归

如果递归函数有返回值，如何区分要搜索一条边，还是搜索整个树呢？

搜索一条边的写法：

```
if (递归函数(root->left)) return ;

if (递归函数(root->right)) return ;
```

搜索整个树写法：

```
left = 递归函数(root->left);
right = 递归函数(root->right);
left与right的逻辑处理;
```

看出区别了没？

**在递归函数有返回值的情况下：如果要搜索一条边，递归函数返回值不为空的时候，立刻返回，如果搜索整个树，直接用一个变量left、right接住返回值，这个left、right后序还有逻辑处理的需要，也就是后序遍历中处理中间节点的逻辑（也是回溯）**。

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

## 栈和队列

Deque

|            | 队列  |             | 栈   |                            |
| ---------- | ----- | ----------- | ---- | -------------------------- |
| 增         | offer | addLast     | push | addFirst                   |
| 弹出头元素 | poll  | pollFirst() | pop  | removeFirst()，pollFirst() |
| 显示头元素 | peek  | peekFirst() | peek | peekFirst()                |

队和栈只在元素加入时不一样，其他都是对头进行操作，不影响，以后习惯加First和Last

## 二叉树

+ 深度和高度

高度后序遍历

深度

前序遍历



### 前中后遍历

#### 递归

```java
void inorder(TreeNode root, List<Integer> list) {
    if (root == null) return;//停止条件
    inorder(root.left, list);//左 root.left
    list.add(root.val);//中 用root进行各种操作
    inorder(root.right, list);//右 root.right
}
```

#### 迭代

中序遍历

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if(root==null) return res;

    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()){
        if(cur!= null){
            stack.push(cur);
            cur = cur.left; // 左
        }else {
            cur = stack.pop();// 向上找父节点，中
            res.add(cur.val); // 输出中间结点
            cur = cur.right; //指向右节点
        }
    }
    return res;
}
```

前序遍历

中--右--左进栈，左--右--中出栈

```java
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if(root==null) return res;

    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()){
        TreeNode node = stack.pop();
        res.add(node.val);
        if(node.right != null) stack.push(node.right);
        if(node.left != null) stack.push(node.left);
    }
    return res;
}
```

后序遍历

中--左--右进栈，右--左--中出栈，再翻转为

```java
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if(root==null) return res;

    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()){
        TreeNode node = stack.pop();
        res.add(node.val);
        if (node.left != null) stack.push(node.left); //左
        if (node.right != null) stack.push(node.right);//右
    }
    Collections.reverse(res);
    return res;
}
```



### 层序遍历

```java

```



```java

```







回溯

对称二叉树、平衡二叉树

## 回溯

### 注意

+ 需要有序
+ 



```java
public void pathRes(TreeNode root, int targetSum) {
    if (root == null) return;
    //1.添加节点
    deque.addLast(root.val);
    
    //2.算法实现过程
    。。。
    
    //3.进入下一层
    pathRes(root.left, targetSum - root.val);
    pathRes(root.right, targetSum - root.val);
    
    //4.回溯本层节点
    //回溯每个点都要回溯，不要跳过回溯否则平添麻烦
    deque.pollLast();
}
```

### 回溯三部曲

+ **递归函数参数**
+ **递归终止条件**
  + 添加结果

+ **单层搜索的逻辑**
  + 递归
  + 回溯
+ 剪枝

```java
List<List<Integer>> result = new ArrayList<>();
LinkedList<Integer> path = new LinkedList<>();
public List<List<Integer>> combine(int n, int k) {
    combineHelper(n, k, 1);
    return result;
}

/**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */
private void combineHelper(int n, int k, int startIndex){
    //终止条件
    if (path.size() == k){
        result.add(new ArrayList<>(path));
        return;
    }
    for (int i = startIndex; i <= n; i++){
        path.add(i);
        combineHelper(n, k, i + 1);
        path.removeLast();
    }
}
```

```java
//剪枝
for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
```



·
