package sj.array;

public class BinSearchPerfectSquareL367 {

    public boolean isPerfectSquare(int num) {

        int left = 1;
        int right = num;

        while (left <= right) {

            // TODO 防止直接相加数据溢出
            int mid = left + (right - left) / 2;
            // TODO long类型同样也是方式int类型溢出
            if ((long) mid * mid == num) {
                return true;
            }
            if ((long) mid * mid < num) {
                left= mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;

    }

}
