import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int[] numArr = new int[N];
        
				for(int i = 0; i < N; i++) {
				   numArr[i] = Integer.parseInt(st.nextToken());
				}
        
				Map<Integer,Integer> countMap = new HashMap<>();
        
				int right = 0;
				int left = 0;
				int maxLength = 0;

				while(right < N) {
					int current = numArr[right];

					countMap.put(current,countMap.getOrDefault(current,0) + 1);
	
					right++;
	
					//count가 K 넘는거 있는지확인
					//있으면 안 넘을 때까지 왼쪽 떙김
					while(countMap.get(current) > K) {
						countMap.put(numArr[left], countMap.get(numArr[left]) - 1);
						left++;
					}

					//최대길이 확인
					maxLength = Math.max(maxLength, right - left);
				}
				
				bw.write(String.valueOf(maxLength));
        bw.flush();
        bw.close();
        br.close();
        
   }
}