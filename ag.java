import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PizzaOrders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] orders = new int[n];
        for (int i = 0; i < n; i++) {
            orders[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        
        if (k == 0 || n < k) {
            // 根据约束，k <= n，且k=0时无窗口，按题意可能不输出
            return;
        }
        
        Deque<Integer> deq = new ArrayDeque<>(); // 存储负数的索引
        StringBuilder result = new StringBuilder();
        
        // 初始化第一个窗口（0到k-1）
        for (int i = 0; i < k; i++) {
            if (orders[i] < 0) {
                deq.addLast(i);
            }
        }
        
        // 处理第一个窗口
        if (!deq.isEmpty()) {
            result.append(orders[deq.peekFirst()]);
        } else {
            result.append(0);
        }
        
        // 滑动窗口：从i = k 到 n-1，每次窗口是 [i-k+1, i]
        for (int i = k; i < n; i++) {
            // 移除出窗口的元素（索引为 i - k）
            if (!deq.isEmpty() && deq.peekFirst() == i - k) {
                deq.removeFirst();
            }
            
            // 添加新元素（索引为 i）
            if (orders[i] < 0) {
                deq.addLast(i);
            }
            
            // 取当前窗口的第一个负数
            if (!deq.isEmpty()) {
                result.append(" ").append(orders[deq.peekFirst()]);
            } else {
                result.append(" ").append(0);
            }
        }
        
        System.out.println(result.toString());
    }
}
