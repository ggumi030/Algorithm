import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    public static boolean yes = false;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<Integer>[] graph = new ArrayList[n + 1];
        
        for(int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }
        
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        
        int[] goms = new int[s];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < s; i++) {
            goms[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean[] visited = new boolean[n + 1];
        dfs(graph, goms, visited, 1);
        
        if(yes) {
            bw.write("yes");
        } else {
            bw.write("Yes");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void dfs(List<Integer>[] graph, int[] goms, boolean[] visited, int n) {
        visited[n] = true;
        
        for(int j = 0; j < goms.length; j++) {
            if(goms[j] == n) return;
        }
        
        if(graph[n].size() == 0) {
            yes = true;
        }
      
        for(int i = 0; i < graph[n].size(); i++) {
            int next = graph[n].get(i);
            if(!visited[next]) {
                dfs(graph, goms, visited, next);
            }
         } 
     }
}