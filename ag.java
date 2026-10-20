import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.util.ArrayDeque;
 import java.util.Deque;
 import java.util.StringTokenizer;
 public class Main {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());
         long[] a = new long[n];
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int i = 0; i < n; i++) {
             a[i] = Long.parseLong(st.nextToken());
         }
         // 1. 后缀最大值 suffixMax[i] = max(a[i], a[i+1], ... a[n-1])
         long[] suffixMax = new long[n + 1];
         suffixMax[n] = Long.MIN_VALUE;
         for (int i = n - 1; i >= 0; i--) {
             suffixMax[i] = Math.max(a[i], suffixMax[i + 1]);
         }
         // 2. hasSmallerAfter[i]：i右边有没有数字 < a[i]
         boolean[] hasSmallerAfter = new boolean[n];
         for (int i = 0; i < n; i++) {
             // 如果a[i]不是i之后的后缀最大值，说明后面一定有比它小的
             hasSmallerAfter[i] = a[i] != suffixMax[i];
         }
         // 3. nextGreater[i]：i右边第一个比a[i]大的下标；不存在则为 -1
         int[] nextGreater = new int[n];
         Deque<Integer> stack = new ArrayDeque<>();
         for (int i = n - 1; i >= 0; i--) {
             while (!stack.isEmpty() && a[stack.peek()] <= a[i]) {
                 stack.pop();
             }
             nextGreater[i] = stack.isEmpty() ? -1 : stack.peek();
             stack.push(i);
         }
         // 4. 计算总分
         long total = 0;
         for (int i = 0; i < n; i++) {
             if (nextGreater[i] == -1) {
                 // 后面没有更大的 →15
                 total += 15;
             } else {
                 int rPos = nextGreater[i];
                 if (hasSmallerAfter[rPos]) {
                     total += 5;
                 } else {
                     total += 10;
                 }
             }
         }
         System.out.println(total);
     }
 }