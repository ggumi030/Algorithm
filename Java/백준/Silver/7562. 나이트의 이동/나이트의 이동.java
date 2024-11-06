import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Point{
    int x;
    int y;
    int cnt;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.cnt = 0;
    }
    
    Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}


public class Main{
    public static int[] rangeX = { -1, -2, -2, -1, 1, 2, 2, 1 };
	public static int[] rangeY = { -2, -1, 1, 2, 2, 1, -1, -2 };
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for(int i = 0; i < test; i++) {
            int I = sc.nextInt();
            Point[] points = new Point[2];
            
            for(int j = 0; j < 2; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                points[j] = new Point(x,y);
            }
            System.out.println(bfs(points,I));
        }
      
    }
    
    public static int bfs(Point[] points, int I) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[I][I];
        
        queue.add(points[0]);
        visited[points[0].x][points[0].y] = true;
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
			
			if (p.x == points[1].x && p.y == points[1].y) {
				return p.cnt;
			}

			for (int i = 0; i < 8; i++) {
				int dx = p.x + rangeX[i];
				int dy = p.y + rangeY[i];

				if (dx >= 0 && dy >= 0 && dx < I && dy < I) {

				    if (!visited[dx][dy]) {
					    visited[dx][dy] = true;
					    queue.add(new Point(dx, dy, p.cnt + 1));
				    }
                }
			}
        }
        
        return -1;
    }
}