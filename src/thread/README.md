### ThreadLocal  
- 在线程池中，当线程退出之前一定要记得调用ThreadLocal的remove()方法，因为在线程池中的线程对象是循环使用的，也为了解决内存泄露的问题，这在线程池操作中是必须的。
- 一个Entry对象中存储了ThreadLocal对象的弱引用和这个ThreadLocal对应的value对象的强引用。
- 调用get()、set()或remove()方法时，会尝试删除key为null的Entry，以释放value对象所占用的内存。但并不能完全解决内存泄露问题，因为我们在这个方法结束的时候逻辑上不一定必须调用get方法，而get方法也不一定执行getEntryAfterMiss方法。所以类本身是没有这个能力的。  

在下面的例子中，新建了有2个线程的线程池，使用Semaphore来同步，使之顺序执行。
1. 自定义Runnable在结束run()方法时手动调用了remove()方法，所以线程复用时不会访问到以前的值；
1. 若没有对ThreadLocal调用remove()方法，会导致第3个任务复用了第1个线程，也就访问到了其中ThreadLocal中的变量。
```java
// 类变量
Semaphore semaphore = new Semaphore(1);

// main()中
ExecutorService es = Executors.newFixedThreadPool(2);
es.execute(tld.new Worker());
es.execute(tld.new Worker());
es.execute(tld.new Worker());

// run()中
try {
    Thread.sleep(rnd.nextInt(1000)); /*随机延时1s以内的时间*/
    semaphore.acquire();/*获取许可*/
} catch (InterruptedException e) {
    e.printStackTrace();
}

int valA = tlA.get();
System.out.println(Thread.currentThread().getName() + " tlA initial val : " + valA);
valA = rnd.nextInt();
tlA.set(valA);
System.out.println(Thread.currentThread().getName() + " tlA  new     val: " + valA);

semaphore.release();

tlA.remove();
pool-1-thread-2 tlA initial val : 3
pool-1-thread-2 tlA  new     val: 934446743
pool-1-thread-2 tlA initial val : 3
pool-1-thread-2 tlA  new     val: -1980335439
pool-1-thread-1 tlA initial val : 3
pool-1-thread-1 tlA  new     val: 407747559

//tlA.remove();
pool-1-thread-1 tlA initial val : 3
pool-1-thread-1 tlA  new     val: 1978392419
pool-1-thread-2 tlA initial val : 3
pool-1-thread-2 tlA  new     val: 1570051260
pool-1-thread-1 tlA initial val : 1978392419
pool-1-thread-1 tlA  new     val: 766111886
```

![](../../pic/834468-20170919190936118-1560718919.png)

![](../../pic/834468-20180401172539887-1014734028.png)

[谁问你ThreadLocal，就把这篇文章丢给他](https://mp.weixin.qq.com/s?__biz=MzI2OTQ4OTQ1NQ==&mid=2247484981&idx=1&sn=6740c45ea988ccd1171ffba2e854eaed&chksm=eadec275dda94b63cf97fc5233a9fce319ac5e79b34728134a36dbc7265b9a2a81b41c9e826a&mpshare=1&scene=1&srcid=0830TtuehBnlxQeATXcu0DAT#rd)  
[ThreadLocal原理及使用示例](https://www.cnblogs.com/nullzx/p/7553538.html)  
