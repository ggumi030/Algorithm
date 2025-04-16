import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        //1. 입력값 받기 K,N,랜선
        //2. 왼쪽,오른쪽,랜선 최대 길이
        //3. 왼쪽이 오른쪽보다 작거나 같을 때까지 반복
        //4. 랜선개수 변수 선언
        //5. 중앙 값 구하기
        //6. for문을 돌면서 (K) 중앙값으로 나눠서 생기는 값을 랜선 개수에 더하기
        //7. 랜선 개수가 N보다 작으면 오른쪽을 mid-1
        //8. 랜선 개수가 N보다 크거나 같으면 왼쪽을 mid+1, 중앙 값과 랜선 최대길이 중 최댓값 저장
        //9. while문이 끝나면 랜선 최대 길이 출력
        
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[] lan = new int[K];
        long max = 0;
        
        for(int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lan[i]);
        }
        
        long left = 1; 
        long right = max; 
        long maxLength = 0;
        
        while(left <= right) {
            long lanNum = 0;
            long mid = (left + right) / 2;
            
            for(int i = 0; i < K; i++) {
                lanNum += lan[i] / mid;
            }
            
            if(lanNum < N) {
                right = mid - 1;
            } else {
                left = mid + 1;
                maxLength = Math.max(maxLength, mid);
            }
        }
        
        bw.write(String.valueOf(maxLength));
        bw.flush();
        bw.close();
        br.close();
    }
}