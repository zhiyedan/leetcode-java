package sj.divide;

/**
 * Created by steven on 18-3-19 下午9:18
 * shijia0620@126.com
 * 自己实现pow指数函数
 */
public class Pow {
    public double pow(int base, int n ){
        //todo 这一步很关键！！！
        if(n<0) return 1/pow(base,-n);
        if(n == 0) return 1;
        double halfNum = pow(base,n>>1);
        int res = (n % 2 == 0)?1:base;
        return halfNum*halfNum*res;
    }
    public static double Power(double base, int exponent) {
        if(exponent == 0) return 1;
        double half = Power(base,exponent>>1);
        double res = (exponent%2 == 1)? base: 1;
        return half*half*res;
    }


    public static void main(String[] args) {
        /*Pow pow = new Pow();
        for(int i=-3;i<5;i++){
            System.out.println(pow.pow(2,i));
        }*/
        System.out.println(Power(3,4));
    }
}
