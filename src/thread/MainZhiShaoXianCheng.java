package thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 一个 HelloWorld 至少几个线程？2个，main、垃圾回收
 * 一个 HelloWorld 到底几个线程？6个，main、垃圾回收、Reference Handler、Signal Dispatcher、Attach Listener、Monitor Ctrl-Break
 */
public class MainZhiShaoXianCheng {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId() + "-" + threadInfo.getThreadName());
        }
    }
}
