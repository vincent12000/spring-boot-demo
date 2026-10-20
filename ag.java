import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        // 示例输入，实际提交时可根据需要读取输入
        int num = 934; // 示例
        System.out.println(generateTrackNumber(num)); // 输出 349

        num = -201;
        System.out.println(generateTrackNumber(num)); // 输出 102

        num = 500;
        System.out.println(generateTrackNumber(num)); // 输出 500（数字 5,0,0，最小非零是 5，剩余 0,0 → 500）

        num = 10;
        System.out.println(generateTrackNumber(num)); // 输出 10（数字 1,0，最小非零是 1，剩余 0 → 10）
    }

    public static int generateTrackNumber(int num) {
        // 取绝对值，处理负数
        String s = String.valueOf(Math.abs(num));
        
        // 统计数字频率
        int[] count = new int[10];
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }

        // 特殊情况：如果 num 是 0，直接返回 0
        if (s.equals("0")) {
            return 0;
        }

        // 找到最小的非零数字作为首位
        int firstDigit = -1;
        for (int i = 1; i <= 9; i++) {
            if (count[i] > 0) {
                firstDigit = i;
                break;
            }
        }

        // 根据题目保证，一定有解，所以 firstDigit 不会为 -1（除非 num 是 0，已处理）
        count[firstDigit]--; // 首位数字用掉一个

        // 构造结果
        StringBuilder sb = new StringBuilder();
        sb.append(firstDigit); // 添加首位

        // 按顺序添加剩余数字（包括 0）
        for (int i = 0; i <= 9; i++) {
            while (count[i] > 0) {
                sb.append(i);
                count[i]--;
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
