package interview;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by steven on 18-3-18 下午8:35
 * shijia0620@126.com
 */
public class TempQueue {
    private List queue = new LinkedList();
    private int limit = 10;
    public TempQueue(int limit) {
        this.limit = limit;
    }
    public synchronized void enqueue(Object item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }this.queue.add(item);
    }
    public synchronized Object dequeue() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        return this.queue.remove(0);
    }
}
