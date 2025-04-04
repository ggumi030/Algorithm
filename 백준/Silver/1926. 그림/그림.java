import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    
    static int N,M;
    static int[][] picture;
    static boolean[][] visited;
    static int area;
    
    static void dfs(int X, int Y) {
        visited[X][Y] = true;
        area += 1;
        
        int[] dn = {-1, 1, 0, 0};
        int[] dm = {0, 0, -1, 1};
        
        for(int i = 0; i < 4; i++) {
            int dN = X + dn[i];
            int dM = Y + dm[i];
            
            if(dN >= 0 && dM >= 0 && dN < N && dM < M) {
                if(picture[dN][dM] == 1 && !visited[dN][dM]) {
                    dfs(dN, dM);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        picture = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int numberOfPicture = 0;
        int maxArea = 0;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(picture[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    
                    numberOfPicture += 1;
                    if(area > maxArea) {
                        maxArea = area;
                    }
                    area = 0;
                }
            }
        }
        
        bw.write(String.valueOf(numberOfPicture));
        bw.newLine();
        bw.write(String.valueOf(maxArea));
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}