import java.util.*;
import java.io.*;

public class Main{
    
    static int N, M;
    static int[] result;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static void dfs(int depth) throws IOException {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        //입력
        st = new StringTokenizer(br.readLine());
        // N 자연수
        N = Integer.parseInt(st.nextToken());
        // M 선택 개수
        M = Integer.parseInt(st.nextToken());
        
        result = new int[M];
        visited = new boolean[N + 1];
        
        //dfs
        dfs(0);
        
        //출력
        bw.flush();
        bw.close();
        br.close();
    }
}
