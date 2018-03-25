package sj.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by steven on 18-3-24 下午5:14
 * shijia0620@126.com
 * <p>
 * 把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class N_PrintMinNumber {
    public static String PrintMinNumber(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for (int num : numbers)
            list.add("" + num);
//        Collections.sort(list,new Comparator<String>(){
//            @Override
//            public int compare(String o1, String o2) {
//                int i=0,j=0;
//                while (i<o1.length() || j<o2.length()){
//                    if( j== o2.length())
//                        j--;
//                    if(i==o1.length())
//                        i--;
//                    if(o1.charAt(i) - o2.charAt(j) == 0){
//                        i++;
//                        j++;
//                    }else
//                        return o1.charAt(i) - o2.charAt(j);
//                }
//                return 0;
//            }
//        });
        //todo 精华之所在！！！
        Collections.sort(list, new Comparator<String>(){
            public int compare(String o1, String o2){
                String str1 = o1+o2;
                String str2 = o2 + o1;
                return str1.compareTo(str2);
            }
        });
        StringBuffer sb = new StringBuffer();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,30,3332,342};
        System.out.println(PrintMinNumber(nums));
    }

}
