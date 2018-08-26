### Executor
创建一个有10个线程的线程池，然后去执行20个任务。
```java
ExecutorService exec = Executors.newFixedThreadPool(10);
for (int i = 0; i < 20; i++) {
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread() + "\t\t" + Thread.activeCount());
        }
    };
    exec.execute(runnable);
}
```
运行结果  

最大活跃线程数为12，小于任务数20，说明线程池中的线程得到了重复的利用，打印的当前线程信息也说明了这一点。
```java
Thread[pool-1-thread-2,5,main]		8
Thread[pool-1-thread-1,5,main]		11
Thread[pool-1-thread-3,5,main]		8
Thread[pool-1-thread-1,5,main]		12
Thread[pool-1-thread-2,5,main]		11
Thread[pool-1-thread-3,5,main]		11
Thread[pool-1-thread-7,5,main]		11
Thread[pool-1-thread-1,5,main]		11
Thread[pool-1-thread-2,5,main]		11
Thread[pool-1-thread-1,5,main]		12
Thread[pool-1-thread-4,5,main]		12
Thread[pool-1-thread-7,5,main]		12
Thread[pool-1-thread-3,5,main]		12
Thread[pool-1-thread-5,5,main]		12
Thread[pool-1-thread-8,5,main]		12
Thread[pool-1-thread-1,5,main]		12
Thread[pool-1-thread-2,5,main]		12
Thread[pool-1-thread-9,5,main]		12
Thread[pool-1-thread-10,5,main]		12
Thread[pool-1-thread-6,5,main]		12
```