package com.kaidi.demo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @创建者 ykd
 * @描述
 */
class Demo {
    public static void main() {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        for (int i : list) {
            if (i != start){
                return start;
            }
            start++;
        }
        return 0;
    }

    public static Long clearTimestampH_M_S(Long timestamp){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.HOUR,0);
        return calendar.getTimeInMillis();
    }

    public static int yu() {
        return 1 & 1;
    }
}
