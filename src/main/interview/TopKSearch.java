package interview;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by steven on 18-3-18 下午11:52
 * shijia0620@126.com
 * top k 问题
 */
public class TopKSearch {
    public void topK(int[] array){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            //TODO 生成最大堆使用o2-o1,生成最小堆使用o1-o2
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0;i<array.length;i++){
            priorityQueue.offer(array[i]);
        }
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{4,1,2,6,10,1};
        TopKSearch a = new TopKSearch();
        a.topK(array);
    }
}
