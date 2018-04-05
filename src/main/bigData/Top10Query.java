package bigData;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by steven on 18-4-4 上午10:40
 * shijia0620@126.com
 * 100万个query中找最热门的top10，
 */
public class Top10Query {
    HashMap<String,Integer> map = new HashMap<>();

    public void readFile(String fileName){
        File file = new File(fileName);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null){
                String query = line.split("\t")[0];
                if(map.containsKey(query)){
                    map.put(query,map.get(query)+1);
                }else {
                    map.put(query,1);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<String> top10(int k){
        PriorityQueue<Map.Entry<String,Integer>> queue = new PriorityQueue<>();
        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(queue.size()<k) queue.offer(entry);
            else if(entry.getValue()>queue.peek().getValue()) {
                queue.offer(entry);
                queue.poll();
            }
        }
        while (!queue.isEmpty()){
            list.add(0,queue.poll().getKey());
        }
        return list;
    }
}
