import java.util.*;

class Solution {
    // 변수
    boolean[][] visited;
    Deque<int[]> dq = new ArrayDeque<>();
    // 움직일 수 있는 경우의 수 
            // 우 : (row, col + 1)
            // 좌 : (row, col - 1)
            // 상 : (row - 1, col)
            // 하 : (row + 1, col)
    int[] dr = {0, 0, -1, 1};
    int[] dc = {1, -1, 0, 0};

    // bfs
    // 처음에 current 값을 Queue에 넣어준다.
    // visited = true로 설정한다.
    // while : 종료 조건 Queue가 빌 때까지 반복한다.
    // 1. queue에서 하나 뺀다.
    // 2. 만약 n-1,m-1과 같다면 distance를 return 한다.
    // 2. current 위치에서 움직일 수 있는 경우를 더한다. (4가지)
    // 3. 만약 경계 조건에 부합하고, maps에서 해당 값이 1이고, 방문 한 적이 없다면, Queue에 넣는다.(넣을 때 distance + 1)
    // 4. visited = true로 설정한다.
    public int bfs(Deque<int[]> dq, int[][] maps) {
        // 변수
        // 시작 지점 : (0, 0)
        // 목적지 : (n-1, m-1)
        // 움직일 수 있는 경계
            // x >= 0 && x < n && y >= 0 && y < m
        dq.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        int endRow = maps.length - 1;
        int endCol = maps[0].length -1;
        
        
        while(!dq.isEmpty()) {
            int[] current = dq.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentDistance = current[2];
            
            if(currentRow == endRow && currentCol == endCol) {
                return currentDistance;
            }
            
            for(int i = 0; i < 4; i++) {
                int nextRow = currentRow + dr[i];
                int nextCol = currentCol + dc[i];
                
                if(nextRow >= 0 && nextRow <= endRow && nextCol >= 0 && nextCol <= endCol) {
                    if(maps[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                        dq.offer(new int[]{nextRow, nextCol, currentDistance + 1});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
        
        return -1;
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        // 알고리즘
        // 최단 거리 BFS
        
        // 구하고자 하는 것
        // 목적지에 도달 할 수 있는 경우 : 최단 거리
        // 목적지에 도달 할 수 없는 경우 : -1
        
        // 풀이
        //  queue에 담는 것 : [row, col, distance]
        // bfs(Deque<Integer[]> dq, int[][] maps)
        visited = new boolean[maps.length][maps[0].length];
        
        // -1을 return 한다.
        return bfs(dq, maps);
    }
}