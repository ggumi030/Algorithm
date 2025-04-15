import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int start = 1;
        int end = 1;
        int count = 0;
        int sum = 1;
        
        while(start <= N) {
            if(sum == N) {
                count++;
            }
            
            if(sum >= N) {
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }
        
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}