package com.example.mxbean;

import java.util.Date;
import java.util.Queue;

public class QueueSampler implements QueueSamplerMXBean {

    private final Queue<String> queue;

    public QueueSampler(Queue<String> queue) {
        this.queue = queue;
    }

    public QueueSample getQueueSampler() {
        synchronized (queue) {
            return new QueueSample(new Date(), queue.size(), queue.peek());
        }
    }

    public void clearQueue() {
        synchronized (queue) {
            queue.clear();
        }

    }
}
