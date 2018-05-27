package interview;

/**
 * Created by steven on 18-4-12 下午3:50
 * shijia0620@126.com
 */
public class Tencent {
    //张义 进制转换10-7
    public String trans2K(int num, int k){
        StringBuilder sb = new StringBuilder();
        while (num!=0){
            char temp = (char) ((num%k>=10)?(num%k+'a'):(num%k+'0'));
            sb.insert(0,temp);
            num = num / k;
        }
        return sb.toString();
    }

    // k进制转10进制
    //todo 考虑‘abF’这样的情况
    public int transTo10(String num, int k){
        int res = 0;
        int base = 1;
        char[] array = num.toCharArray();
        int len  = array.length;
        for(int i=len-1;i>=0;i--){
            int temp = (array[i]<'a')?(array[i]-'0'):(array[i]-'a'+10);
            res += temp*base;
            base *= k;
        }
        return res;
    }

    // 换瓶子

    public static void main(String[] args) {
        Tencent t = new Tencent();
        System.out.println(args.length);
//        System.out.println(t.trans2K(15,2));
//        System.out.println(t.transTo10("a1",13));
    }
}
