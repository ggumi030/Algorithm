import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken()); 
        int N = Integer.parseInt(st.nextToken()); 
        int H = Integer.parseInt(st.nextToken()); 
        
        Queue<int[]> queue = new LinkedList<>();
        int[][][] box = new int[H][N][M];
        boolean set = true;
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 0) set = false;
                    if(box[i][j][k] == 1) queue.add(new int[]{i, j, k});
                }
            }
        }

        if(set) {
            bw.write("0\n");
        } else{
            int day = bfs(box, queue, H, N, M);
            bw.write(day == -1 ? "-1\n" : day + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int bfs(int[][][] box, Queue<int[]> queue, int H, int N, int M) {
        int day = 0;
        int[] dh = {-1, 1, 0, 0, 0, 0};
        int[] dn = {0, 0, -1, 1, 0, 0};
        int[] dm = {0, 0, 0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int h = point[0];
                int n = point[1];
                int m = point[2];
                
                for (int d = 0; d < 6; d++) {
                    int nh = h + dh[d];
                    int nn = n + dn[d];
                    int nm = m + dm[d];
                    
                    if (nh >= 0 && nh < H && nn >= 0 && nn < N && nm >= 0 && nm < M && box[nh][nn][nm] == 0) {  
                        box[nh][nn][nm] = 1;
                        queue.add(new int[]{nh, nn, nm});
                    }
                }
            }
            
            if(!queue.isEmpty()) day++;     
        }
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }
        
        return day;
    }
}
