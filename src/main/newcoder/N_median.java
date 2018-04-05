package newcoder;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by steven on 18-3-30 下午9:04
 * shijia0620@126.com
 * 数据流中位数
 */
public class N_median {
    //小顶堆存放大数据，顶为最小数。
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
        public int compare(Integer o1, Integer o2){
            return o2.compareTo(o1);
        }
    });
    int count = 0;

    public void Insert(int num) {
        count++;
        // 奇数往前半部分插入,即大顶堆插入
        if ((count & 1) == 0) {
            //考虑是否会大于后半部分
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        } else {
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if(count <=0) return 0.0;
        if ((count & 1) == 0) return Double.valueOf(maxHeap.peek());
        return (maxHeap.peek() + minHeap.peek())/2.0;
    }
}
