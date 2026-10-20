import java.util.*;

public class GroupIDCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] pfr = new int[num];
        for (int i = 0; i < num; i++) {
            pfr[i] = scanner.nextInt();
        }

        if (num == 0) {
            System.out.println(0);
            return;
        }

        int[] suffixMax = new int[num];
        suffixMax[num - 1] = pfr[num - 1];
        for (int i = num - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(pfr[i], suffixMax[i + 1]);
        }

        int[] nge = new int[num];
        Arrays.fill(nge, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = num - 1; i >= 0; i--) {
            while (!stack.isEmpty() && pfr[stack.peek()] <= pfr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nge[i] = stack.peek();
            }
            stack.push(i);
        }

        long totalID = 0;
        for (int i = 0; i < num; i++) {
            if (pfr[i] == suffixMax[i]) {
                totalID += 15;
            } else {
                int ngeIdx = nge[i];
                if (pfr[ngeIdx] == suffixMax[i]) {
                    totalID += 10;
                } else {
                    totalID += 5;
                }
            }
        }

        System.out.println(totalID);
    }
}
