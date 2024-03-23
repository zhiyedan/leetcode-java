package sj.stack;

import java.util.*;

public class DailyTemperaturesL739 {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        // TODO 也可以写到里面，不用单独搞一套
        stack.push(0);

        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return result;

    }
}
