package sj.array;

public class MySqrtL69 {

    /**
     * 二分法
     *
     * @param x
     * @return
     */
    public int mySqrtBinSearch(int x) {

        int l = 0, r = x, ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            //TODO 这里一定要注意，int相乘会超出int限制的！！！
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    /**
     * 牛顿迭代法：xk+1 = xk - f(xk)/f`(xk)
     */
    public static int mySqrtND(int x) {

        if (x == 0) return 0;

        int C = x;
        double x0 = x;

        while (true) {
            //TODO 一定要定义成double类型，结束的标志是两次迭代差值很小
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(xi - x0) < 1e-7) {
                break;
            }
            x0 = xi;
        }

        return (int) x0;

    }

    public static void main(String[] args) {
        System.out.println(mySqrtND(8));
    }
}
