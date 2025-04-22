import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] numArr = new int[N];
        
        for(int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = 0;
        int blackJack;
        
        for(int i = 0; i < N - 2; i++) {
            for(int j = i + 1; j < N - 1; j++) {
                for(int k = j + 1; k < N; k++) {
                    
                    blackJack = numArr[i] + numArr[j] + numArr[k];
                    
                    if(blackJack < M) {
                        max = Math.max(blackJack, max);
                    } else if(blackJack == M) {
                        bw.write(String.valueOf(blackJack));
                        bw.flush();
                        bw.close();
                        br.close();
                        return;
                    }
                }
            }
        }
        
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}