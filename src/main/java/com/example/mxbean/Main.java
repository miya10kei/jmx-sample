package com.example.mxbean;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName mxbeanName = new ObjectName("com.example.mxbean:type=QueueSampler");

        Queue<String> queue = new ArrayBlockingQueue<>(10);
        queue.add("Request-1");
        queue.add("Request-2");
        queue.add("Request-3");
        QueueSampler mxBean = new QueueSampler(queue);

        server.registerMBean(mxBean, mxbeanName);

        System.out.println("Waiting...");
        Thread.sleep(Long.MAX_VALUE );
    }
}
