import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long N = Long.parseLong(br.readLine());
        long cat = 2L;
        long action = 2;
        
        if(N < 3) {
            bw.write(N + "\n");
        } else{
            while(N > cat) {
                cat *= 2;
                action++;
            }
            
            bw.write(action + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}