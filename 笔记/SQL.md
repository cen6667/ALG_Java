

## 匹配月份date_format

```
date_format(submit_time, '%Y%m')
```

## year()

```
year(submit_time) = 2021
```

## 每个月有几天

```
day(last_day(submit_time)
```



## distinct

## count()

COUNT(*) 函数返回表中的记录数：

`SELECT COUNT(*) FROM table_name`



COUNT(column_name) 函数返回指定列的值的数目（NULL 不计入）：

`SELECT COUNT(column_name) FROM table_name`



COUNT(DISTINCT column_name) 函数返回指定列的不同值的数目：

`SELECT COUNT(DISTINCT column_name) FROM table_name`

计算月活次数的时候，一定要考虑去除同一个用户在一天内多次做答的情况

```
count(distinct uid,day(submit_time))
```

## union

union all 可以重复，全部展示

union 不可以重复

intersect 交集，不可以重复

Minus 差集，不可以重复

## any_value()

牛客已经采用最新的Mysql版本，如果您运行结果出现错误：ONLY_FULL_GROUP_BY，意思是：对于GROUP BY聚合操作，如果在SELECT中的列，没有在GROUP BY中出现，那么这个SQL是不合法的，因为列不在GROUP BY从句中，也就是说**查出来的列必须在group by后面出现**否则就会报错，**或者这个字段出现在聚合函数里面。**

1.MySQL5.7之后，sql_mode中ONLY_FULL_GROUP_BY模式默认设置为打开状态。

2.ONLY_FULL_GROUP_BY的语义就是确定select target list中的所有列的值都是明确语义，简单的说来，在此模式下，target list中的值要么是来自于聚合函数（sum、avg、max等）的结果，要么是来自于group by list中的表达式的值

3.MySQL提供了any_value()函数来抑制ONLY_FULL_GROUP_BY值被拒绝

4.any_value()会选择被分到同一组的数据里第一条数据的指定列值作为返回数据

## 拼接字符串

2021-09-01:算法;2021-07-02:SQL;2021-09-02:SQL;2021-09-05:SQL;2021-07-05:SQL

```
group_concat(distinct concat_ws(':',date(start_time),tag) order by start_time separator ';') as detail
```

