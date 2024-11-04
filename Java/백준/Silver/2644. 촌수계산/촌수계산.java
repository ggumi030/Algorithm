import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    
    public static int end;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] visited;
    public static int answer = -1;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = sc.nextInt();
        end = sc.nextInt();
        int m = sc.nextInt();
        
        visited = new int[n+1];
        
        for(int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        dfs(start, 0);
        
        System.out.println(answer);
    }
    
    public static void dfs(int idx, int cnt) {
        visited[idx] = 1;
        
        if(idx == end) {
            answer = cnt;
            return;
        }
        
        for(int i = 0; i < graph.get(idx).size(); i++) {
            int n = graph.get(idx).get(i);

            if(visited[n] == 0){
                dfs(n, cnt+1);
                if (answer != -1) return;
            }
        }
        
        visited[idx] = 0;
    }
}