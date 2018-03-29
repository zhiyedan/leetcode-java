package sj.string;

/**
 * Created by steven on 18-3-27 下午4:26
 * shijia0620@126.com
 *
 * 翻转单词顺序
 */
public class N_ReverseSentence {
    public String ReverseSentence(String str) {
        if(str == null || str.length()==0) return "";
        String[] list = str.split(" ");
        //todo 异常处理 如果为“ ”则会出错。。。。
        if(list.length <= 1) return str;
        for(int i=0;i<list.length>>1;i++){
            String temp = list[i];
            list[i] = list[list.length-i-1];
            list[list.length-i-1] = temp;
        }
        StringBuffer sb = new StringBuffer();
        for(String string: list){
            sb.append(string);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
