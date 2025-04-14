import java.io.*;
import java.util.*;

public class Main{
    
    static List<Integer>[] graph;
    static boolean visited[];
    static Queue<Integer> queue;
    static StringBuilder sb;
    
    static void dfs(int V) {
        visited[V] = true;
        sb.append(String.valueOf(V) + " ");
        
        for(Integer node : graph[V]) {
            if(!visited[node]) {
                dfs(node);
            }
        }
    }
    
    static void bfs() {
        while(!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(String.valueOf(now) + " ");
        
            for(Integer node : graph[now]) {
                if(!visited[node]) {
                    visited[node] = true;
                    queue.offer(node);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        //N
        int N = Integer.parseInt(st.nextToken());
        //M
        int M = Integer.parseInt(st.nextToken());
        //V
        int V = Integer.parseInt(st.nextToken());
        
        //그래프 초기화
        graph = new ArrayList[N + 1];
        
        for(int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        //그래프 값 입력
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            graph[start].add(end);
            graph[end].add(start);
        }
        
        // 방문 순서 보장 위해 정렬
        for(int i = 1; i < N + 1; i++) {
            Collections.sort(graph[i]);
        }
        
        //Stringbuilder (결과 출력용)
        sb = new StringBuilder();
        visited = new boolean[N + 1];
        //dfs
        dfs(V);
        //write
        bw.write(sb.toString() + "\n");
       
        
        //Stringbuilder (결과 출력용)
        sb = new StringBuilder();
        visited = new boolean[N + 1];
        //bfs
        queue = new LinkedList<>();
        visited[V] = true;
        queue.offer(V);
        bfs();
        //write
        bw.write(sb.toString());
        
        //flush
        bw.flush();
        bw.close();
        br.close();
    }
}