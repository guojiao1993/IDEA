### GC
常用配置
```java
-Xms20M
-Xmx20M
-Xmn10M
-XX:SurvivorRatio=8
-XX:+PrintGC
-XX:+PrintGCDetails
-XX:+PrintGCDateStamps
-Xloggc:C:\Users\Alan\Desktop\gc.log
```
日志内容
```java
Java HotSpot(TM) 64-Bit Server VM (25.131-b11) for windows-amd64 JRE (1.8.0_131-b11), built on Mar 15 2017 01:23:53 by "java_re" with MS VC++ 10.0 (VS2010)
Memory: 4k page, physical 8268520k(2124688k free), swap 12075796k(2126496k free)
CommandLine flags: -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:MaxNewSize=10485760 -XX:NewSize=10485760 -XX:+PrintGC -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:SurvivorRatio=8 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC 
2018-09-03T16:30:26.848+0800: 0.191: [GC (Allocation Failure) [PSYoungGen: 6586K->968K(9216K)] 6586K->5072K(19456K), 0.0055319 secs] [Times: user=0.06 sys=0.02, real=0.01 secs] 
Heap
 PSYoungGen      total 9216K, used 7349K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
  eden space 8192K, 77% used [0x00000000ff600000,0x00000000ffc3b780,0x00000000ffe00000)
  from space 1024K, 94% used [0x00000000ffe00000,0x00000000ffef2020,0x00000000fff00000)
  to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
 ParOldGen       total 10240K, used 4104K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  object space 10240K, 40% used [0x00000000fec00000,0x00000000ff002020,0x00000000ff600000)
 Metaspace       used 3502K, capacity 4498K, committed 4864K, reserved 1056768K
  class space    used 387K, capacity 390K, committed 512K, reserved 1048576K
```
