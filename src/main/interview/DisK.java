package interview;

import org.omg.PortableInterceptor.INACTIVE;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;

/**
 * Created by steven on 18-3-24 下午7:08
 * shijia0620@126.com
 */
public class DisK {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[len];
        for(int i=0;i<len;i++){
            array[i] = sc.nextInt();
        }
        List list = Arrays.asList(array);
        HashSet<Integer> set = new HashSet<Integer>(list);
        ArrayList<Integer> list1 = new ArrayList<>(set);
        Collections.sort(list1);
        System.out.println(Arrays.toString(list1.toArray()));
    }

    public static void main2(String[] args) {
//        int k = 3;
//        int[] array = new int[]{3,3,1,5,2};
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<len;i++){
            set.add(sc.nextInt());
        }
        // 处理k=0的情况
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for(int i=0;i<list.size()-2;i++){
            int j = i+1;
            while (j<list.size()){
                if(list.get(j)-list.get(i) == k){
                    count ++ ;
                }
                if(list.get(j)-list.get(i) > k) break;
                else
                    j++;
            }
            if(j == list.size()) break;
        }
        System.out.println(count);
    }
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String foo = "40+2+(3-4/2)";
        System.out.println(engine.eval(foo));
    }
}
