import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

public class Main{
    
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static Queue<Integer> queue = new LinkedList<>();
    public static int[] visited;
    public static int cnt;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
            
            int u = sc.nextInt();
            int v = sc.nextInt();
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        for(int i = 1; i < n + 1; i++) {
            Collections.sort(graph.get(i));
        }
        
        visited = new int[n + 1];
        cnt = 1;
        visited[start] = cnt;
        
        bfs(start);
        
        for(int i = 1; i < n + 1; i++){
            System.out.println(visited[i]);    
        }
        
    }
    
    public static void bfs(int idx) {
        
        queue.add(idx);
        
        while(!queue.isEmpty()) {           
            int u = queue.poll();
            
            for(int i = 0; i < graph.get(u).size(); i++) {               
                if(visited[graph.get(u).get(i)] == 0) {                   
                    visited[graph.get(u).get(i)] = ++cnt;
                    queue.add(graph.get(u).get(i));             
                }
            }
        }
    
    }
}