package interview;

import java.util.LinkedList;

/**
 * Created by steven on 18-3-15 下午7:33
 * shijia0620@126.com
 * <p>
 * 产生一个线程安全的生成者消费者
 */
public class ThredProduceAndConsume {
    private final int MAX_SIZE = 100;
    // 用来盛放载体，相当于仓库
    private LinkedList<Integer> list = new LinkedList<>();

    // 生产者
    public void produce(int num) {
        synchronized (list) {
            //TODO 用while而非if
            if (list.size() + num > MAX_SIZE) {
                try {
//                    TODO 调用list的wait()方法
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int j=0; j<num; j++){
                list.add(j);
            }
//            TODO 用完之后交出控制权，并通知其他线程
            list.notifyAll();
        }
    }

    // 消费者
    public void consume(int num){
        synchronized(list){
            while(list.size()<num){
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int j=0; j<num; j++){
                System.out.println(list.get(list.size()-1));
                list.remove();
            }
            list.notifyAll();
        }
    }
}
