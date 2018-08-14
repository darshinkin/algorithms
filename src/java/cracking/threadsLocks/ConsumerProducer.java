package cracking.threadsLocks;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsumerProducer {
    private BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();

    AtomicInteger atomicIntegerConsumer = new AtomicInteger();
    AtomicInteger atomicIntegerProducer = new AtomicInteger();

    void produce() throws InterruptedException {
        while (true) {
            queue.put(ThreadLocalRandom.current().nextInt());
            System.out.println("P:   " + atomicIntegerProducer.addAndGet(1));
        }
    }

    void consum() {
        while (true) {
            queue.poll();
            System.out.println("C:   " + atomicIntegerConsumer.addAndGet(1));
        }
    }

    private Queue<Integer> list = new LinkedList<>();

    void consum1() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() == 0) {
                    wait();
                }
                list.poll();
                notifyAll();
                Thread.sleep(1000);
                System.out.println("C    " + atomicIntegerConsumer.addAndGet(1));
            }
        }
    }

    void produce1() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() == 10) {
                    wait();
                }
                list.add(ThreadLocalRandom.current().nextInt());
                notifyAll();
                Thread.sleep(1000);
                System.out.println("P    " + atomicIntegerProducer.addAndGet(1));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ConsumerProducer consumerProducer = new ConsumerProducer();
        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            executorService.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    consumerProducer.consum1();
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return true;
                }
            });

            executorService.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    try {
                        consumerProducer.produce1();
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return true;
                }
            });
        }

        latch.countDown();
    }
}
