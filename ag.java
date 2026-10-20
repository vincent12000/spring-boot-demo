import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VaporRateCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
        }

        long maxVapor = 0; // 初始化为0，若所有结果均为负则返回0

        // 枚举所有可能的 T = a + b
        for (int T = 1; T <= 2 * num - 2; T++) {
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();

            // 生成所有 a < b 且 a + b = T 的配对
            for (int a = 0; a < num; a++) {
                int b = T - a;
                if (b >= 0 && b < num && a < b) {
                    aList.add(a);
                    bList.add(b);
                }
            }

            int m = aList.size();
            if (m == 0) continue;

            // 计算每个配对的乘积
            long[] products = new long[m];
            for (int i = 0; i < m; i++) {
                products[i] = (long) arr[aList.get(i)] * arr[bList.get(i)];
            }

            // Kadane's algorithm 找最大子数组和
            long currentMax = 0;
            long currentSum = 0;
            for (int i = 0; i < m; i++) {
                currentSum += products[i];
                if (currentSum < 0) {
                    currentSum = 0; // 重置，因为负数子数组不会带来更大值
                }
                if (currentSum > currentMax) {
                    currentMax = currentSum;
                }
            }
            if (currentMax > maxVapor) {
                maxVapor = currentMax;
            }
        }

        System.out.println(maxVapor);
    }
}
