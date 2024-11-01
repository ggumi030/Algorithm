import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] visited;
    public static int cnt;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        
        for(int i=0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        for(int i=0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }
        
        visited = new int[n+1];
        cnt = 1;
        dfs(start);
        
        for(int i =1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }
    }
    
    public static void dfs(int idx) {
        
        visited[idx] = cnt;
        
        for(int i = 0; i < graph.get(idx).size(); i++) {
            if(visited[graph.get(idx).get(i)] == 0) {
                cnt++;
                dfs(graph.get(idx).get(i));
            }
        }
    }
}