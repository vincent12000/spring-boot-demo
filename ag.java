import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BusDistanceCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int num = scanner.nextInt(); // 公交车数量
        int constM = scanner.nextInt(); // 固定为 2，每行两个数

        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals.add(new int[]{start, end});
        }

        // 按起始点排序，起始点相同按结束点排序
        Collections.sort(intervals, Comparator.comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty()) {
                merged.add(interval);
            } else {
                int[] last = merged.get(merged.size() - 1);
                // 如果当前区间与上一个区间重叠或相邻（start <= last[1]）
                if (interval[0] <= last[1]) {
                    last[1] = Math.max(last[1], interval[1]); // 合并
                } else {
                    merged.add(interval); // 不重叠，添加新区间
                }
            }
        }

        long totalDistance = 0;
        for (int[] interval : merged) {
            totalDistance += (interval[1] - interval[0]);
        }

        System.out.println(totalDistance);
    }
}
