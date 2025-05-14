import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            
            st = new StringTokenizer(br.readLine());
            int firstNum = Integer.parseInt(st.nextToken());
            int secondNum = Integer.parseInt(st.nextToken());
            
            System.out.println("Case #" + (i+1) + ": " + (firstNum + secondNum));
        }
        
    }
}