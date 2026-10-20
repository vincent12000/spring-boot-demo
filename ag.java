import java.io.*;
import java.util.*;

public class Main {
    static class DSU {
        int[] parent;
        long[] sum;
        int[] rank;
        DSU(int n, long[] val){
            parent = new int[n+1];
            sum = new long[n+1];
            rank = new int[n+1];
            for(int i=1;i<=n;i++){
                parent[i]=i;
                sum[i]=val[i];
                rank[i]=1;
            }
        }
        int find(int x){
            if(parent[x]!=x) parent[x]=find(parent[x]);
            return parent[x];
        }
        void union(int a,int b){
            int ra=find(a), rb=find(b);
            if(ra==rb) return;
            if(rank[ra]<rank[rb]){
                parent[ra]=rb;
                sum[rb]+=sum[ra];
            }else{
                parent[rb]=ra;
                sum[ra]+=sum[rb];
                if(rank[ra]==rank[rb]) rank[ra]++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        var br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long[] s=new long[n+1];
        var st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) s[i]=Long.parseLong(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int m=Integer.parseInt(st.nextToken());
        // 第二个数字pairCount固定=2，丢弃
        br.readLine();
        DSU dsu=new DSU(n,s);
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken()),v=Integer.parseInt(st.nextToken());
            dsu.union(u,v);
        }
        long max=0;
        for(int i=1;i<=n;i++){
            if(dsu.find(i)==i) max=Math.max(max,dsu.sum[i]);
        }
        System.out.println(max);
    }
}
