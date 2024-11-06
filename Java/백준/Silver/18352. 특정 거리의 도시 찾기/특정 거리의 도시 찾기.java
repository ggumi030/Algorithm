import java.util.Queue;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
     
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
      
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
        }
        
        List<Integer> answer = bfs(graph, x, k);
     
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        
        if (answer.isEmpty()) {
            sb.append("-1\n");
        } else {
            for (int node : answer) {
                sb.append(node).append("\n");
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static List<Integer> bfs(List<Integer>[] graph, int start, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[graph.length];
        Arrays.fill(distance, -1);
        List<Integer> result = new ArrayList<>();
        
        queue.add(start);
        distance[start] = 0; 
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph[current]) {
                if (distance[next] == -1) { 
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                    
                    if (distance[next] == k) {
                        result.add(next);
                    }
                }
            }
        }
        
        return result;
    }
}