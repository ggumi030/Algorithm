import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    
    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void bfs(int X, int Y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(X, Y));
        visited[X][Y] = true;
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny] || maze[nx][ny] == 0) continue;
                
                queue.offer(new Node(nx,ny));
                visited[nx][ny] = true;
                maze[nx][ny] = maze[node.x][node.y] + 1;
            }
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        maze = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }
        
        bfs(0,0);
        
        bw.write(Integer.toString(maze[N-1][M-1]));
        bw.flush();
        bw.close();
        br.close();
        
    }
}