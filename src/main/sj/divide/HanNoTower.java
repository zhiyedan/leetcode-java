package sj.divide;
/*
* 汉诺塔，分为三步：
* 1、把上面的n-1个盘移动到temp上
* 2、把n盘移动到target上面
* 3、再把n-1个盘从temp塔移动到target上面
* */
public class HanNoTower {
    public static void hanNo(int n, String source, String temp, String target) {
        if (n == 1) {
            move(n, source, target);
        } else {
            hanNo(n-1, source, target, temp);
            move(n, source, target);
            hanNo(n-1, temp, source, target);
        }
    }

    public static void move(int n, String source, String target) {
        System.out.println("第" + n + "号盘子 move:" + source + "--->" + target);
    }
}
