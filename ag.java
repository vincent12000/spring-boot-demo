import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// record 是 Java16+ 原生，Java21 完美支持，简洁
record House(int h, int p) {}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        // val 固定=2，直接丢掉不用

        House[] arr = new House[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[i] = new House(h, p);
        }

        // 按位置P升序排序
        Arrays.sort(arr, (a, b) -> a.p() - b.p());

        long maxGap = -1;
        int h1 = 0, h2 = 0;
        for (int i = 1; i < n; i++) {
            long gap = arr[i].p() - arr[i-1].p();
            // 更大gap直接更新；相等时因为我们顺序从左往右扫，自动保留更早（靠左）的，不用额外判断
            if (gap > maxGap) {
                maxGap = gap;
                int a = arr[i-1].h();
                int b = arr[i].h();
                h1 = Math.min(a, b);
                h2 = Math.max(a, b);
            }
        }
        System.out.println(h1 + " " + h2);
    }
}
