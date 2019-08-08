# 1 前言

实现一个排版榜，我们通常想到的就是mysql的order by 简单粗暴就撸出来了。但是这样真的优雅吗？

数据库是系统的瓶颈，这是众所周知的。如果给你一张百万的表，让你排序做排行榜，花费的时间是十分可怕的。

不如缓存吧，order by的时候强制使用索引。但是这样真的优雅吗？

# 2 Redis的排行榜

我们分析一下排行榜，一个用户一个排名，意味着要去重，这时我们会想到Java的一种数据结构Set。不过Set又是无序的。有没有一种结构是可以保住元素唯一以及有序的呢。

幸运的是，还真的有。Redis的ZSet的就是这样的一种数据结构。Zset里面的元素是唯一的，有序的，按分数从小到大排序。作为一名优秀的crud程序员，我们从这几个方方面入手了解zset结构。

## 2.1 ZADD 增加与修改

其时间复杂度为 O(M*log(N))， N 是有序集的基数， M 为成功添加的新成员的数量。如果key不存在就插入，存在就更新。

使用如下:

```cmd
redis> ZADD page_rank 10 google.com
(integer) 1
```
说明：

page_rankde 是key，10是分数，google.com是value

## 2.2 ZRANK 查询
时间复杂度: O(log(N))

使用如下:

```cmd
redis> ZRANGE salary 0 -1        # 显示所有成员
1) "peter"
2) "tom"
3) "jack"


redis> ZRANK salary tom        # 显示 tom 的薪水排名，第二
(integer) 1
```
说明：

salary的key，tom是value，只要输入特定的key与value就能查询到对应的排名。

## 2. del 删除
直接使用redis的del命令

# 3 分数设计

回到排行榜的实现，要利用zset结构来实现的话，重要的是如何设计分数。分析一下排行榜单的设计。如果排行榜的设计按一个维度比如金币数量，那只需把其数量取反作为分数score即可。取反是因为zset默认从小到大排序。

实现如下：
```java
public Double getScore( Long oneDayGoldBean) {
    String score = String.valueOf(oneDayGoldBean);
    return -Double.valueOf(score);
}
```
如果排行榜的设计按两个维度比如金币数量和用时。由于score是一个可以double类型的参数，设计的时候可以把用时作为小数，用一天的总毫秒数减去花费毫秒数作为小数部分，然后当做字符串拼接起来，然后取反作为score.

实现如下：
```java
public Double getScore( Long oneDayGoldBean, Long useTime) {
    String value1 = String.valueOf(oneDayGoldBean/1.0);
    long todayEndSS = getTodayEndSS(useTime);
    String value2 = String.valueOf(todayEndSS);
    String score =value1+value2;
    return -Double.valueOf(score);
}

private long getTodayEndSS(long current){
    //今天零点零分零秒的毫秒数
    long zero = 0L;
    //今天23点59分59秒的毫秒数
    long twelve = zero + 24 * 60 * 60 * 1000;
    return (twelve - current) / 1000;
}
```
# 4 代码实现
```java
@Override
public boolean insertLeaderboard() {
    Double score = getScore(100l, 1000l);
    return redisTemplate.opsForZSet().add("leaderboard", "1", score);
}

@Override
public Set checkLeaderboard() {
    // 0 -1 表示返回所有的value的set值
    return redisTemplate.opsForZSet().range("leaderboard", 0, -1);
}
```
# 源码


https://github.com/blackdogss/HelloWorld/tree/master/helloRS





