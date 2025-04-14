import java.io.*;
import java.util.*;

public class Main{
    
    static int N,M;
    static int[] result;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static void dfs(int depth) throws IOException {
        // M == depth
        if(depth == M) {
            // result 배열을 write
            for(int i = 0; i < M; i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            // return
            return;
        }
        // for 방문확인 1 ~ N
        for(int i = 1; i <= N; i ++) {
            if(!visited[i]) {
                if(depth > 0) {
                    if(i < result[depth - 1]) continue;
                }
                visited[i] = true;
                result[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
        // 방문 기록
        // dfs
        // 방문 기록 백트래킹
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //N
        N = Integer.parseInt(st.nextToken());
        //M
        M = Integer.parseInt(st.nextToken());
        
        //visited 배열 초기화
        visited = new boolean[N + 1];
        //result 배열 초기화
        result = new int[M];
        
        //dfs
        dfs(0);
        //출력
        //flush
        bw.flush();
        bw.close();
        br.close();
    }
}