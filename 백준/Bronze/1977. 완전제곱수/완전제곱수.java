import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int startNum = N;
        int sum = 0;
        
        for(int i = 1; i <= N; i++) {
            if(i * i >= M) {
                startNum = i;
                break;
            }
        }
        
        for(int i = startNum; i * i <= N; i++) {
            sum += i * i;
        }
        
        StringBuilder sb = new StringBuilder();
        
        if(sum == 0) {
            bw.write("-1");
        } else{
            sb.append(sum).append("\n").append(startNum * startNum);
            bw.write(sb.toString());
        }
     
        bw.flush();
        bw.close();
        br.close();
    }
}