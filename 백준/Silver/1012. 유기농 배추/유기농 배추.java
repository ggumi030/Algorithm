import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    
    static int M,N,K;
    static int[][] ground;
    static boolean[][] visited;
    
    static void dfs(int X, int Y) {
        visited[X][Y] = true;
        
        int[] dm = {-1,1,0,0};
        int[] dn = {0,0,-1,1};
        
        for(int i = 0; i < 4; i++) {
            int dX = X + dm[i];
            int dY = Y + dn[i];
            
            if(dX >= 0 && dY >=0 && dX < M && dY < N) {
                if(!visited[dX][dY] && ground[dX][dY] == 1) {
                    dfs(dX,dY);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCase = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
        
            ground = new int[M][N];
            visited = new boolean[M][N];
        
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                ground[X][Y] = 1;
            }
        
            int worm = 0;
        
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    //배추 위치 찾기
                    if(!visited[i][j] && ground[i][j] == 1) {
                        //배추 주변에 있는지 확인
                        worm += 1;
                        dfs(i,j);
                    }
                }
            }
        
            bw.write(String.valueOf(worm));
            bw.newLine();
        }
  
        bw.flush();
        bw.close();
        br.close();
        
    }
}
    