package interview;

/**
 * Created by steven on 18-3-21 下午3:14
 * shijia0620@126.com
 */
public class TryCatchFinally {
    public static void main(String[] args) {
        System.out.println(test2());
    }

    // finally 中有返回则返回,没有返回也有输出，
    public static int test2() {
        int b = 20;
        try {
            System.out.println("try block");
//            System.exit(0);
            return b;
        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");
            b = 30;
//            return 200;
        }
        //TODO 如果finally有返回，则下面一句不可达！！！
        return 40;
    }

    public static int test4() {
        int b = 20;
        try {
            System.out.println("try block");
            b = b / 0;
            return b += 80;
        } catch (Exception e) {
            b += 15;
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");
            b += 50;
        }
        return b;
    }

    public static int test5() {
        int b = 20;
        try {
            System.out.println("try block");
            b = b /0;
            System.out.println("hahah");
            return b += 80;
        } catch (Exception e) {
            System.out.println("catch block");
            return b += 15;
        } finally {
            System.out.println("finally block");
            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
//            return b += 50;
        }

        //return b;
    }
}
