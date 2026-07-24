import java.util.*;

class Solution {
    
    ArrayList<ArrayList<Integer>> networks = new ArrayList<>(); // 네트워크 별 연결된 애들
    boolean[] visited; // 방문한 컴퓨터
    
    // dps
        // for list size까지
            // 해당 list에서 다음 index를 꺼내서 computers[index] 배열 중 1인 컴퓨터의 index를 모두 저장한다.
            // 넣은 index는 visited 처리한다.
    
    public void dps(int[][] computers, ArrayList<Integer> network) {
        // network size만큼 dps를 돌린다.
        for(int i = 0; i < network.size(); i++) {
            
            // 탐색할 컴퓨터 Network 구조를 꺼낸다.
            int computerIndex = network.get(i);
            int[] computerNetwork = computers[computerIndex];
            // 해당 구조의 0 ~ length-1까지 탐색한다.
            for(int j = 0; j < computerNetwork.length; j++) {
                // computerNetwork가 연결되어 있고, network에 현재 들어있지 않다면 network에 연결한다.
                if(computerNetwork[j] == 1 && !network.contains(j)) {
                    network.add(j);
                    visited[j] = true;
                    dps(computers, network);
                }
            }   
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // 전부 조사 = dfs, 백트래킹은 아님
                
        // 1. 변수 정의
        visited = new boolean[computers.length];
        
        // 2. 탐색할 computer와 연결된 network 찾기 (for : computer 전체 수 만큼)
            // 2-1. 방문한 적 없는 컴퓨터에 한 해서
            // 2-2. 해당 컴퓨터와 연결된 컴퓨터들을 network list에 담는다.
            // 2-3. 해당 컴퓨터는 visited 처리 한다.
        for(int i = 0; i < computers.length; i ++) {
            if(visited[i] == false) {
                ArrayList<Integer> network = new ArrayList<>();
                
                for(int j = 0; j < computers[i].length; j++) {
                    if(computers[i][j] == 1) {
                        network.add(j);
                        visited[j] = true;
                    }
                }
                
                // 3. 해당 네트워크를 가지고 dps를 돌린다. (간접적으로 연결된 애들을 찾기 위해)
                dps(computers, network);
                // 4. 모든 네트워크 연결이 완료 되면, networks에 담는다.
                networks.add(network);
            }
        }
        
        // 생성된 배열의 개수를 return 한다.        
        return networks.size();
    }
}