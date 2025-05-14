import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            
            int firstNum = Integer.parseInt(st.nextToken());
            int secondNum = Integer.parseInt(st.nextToken());
            
            sb.append("Case #");
            sb.append(i + 1);
            sb.append(": ");
            sb.append(firstNum + secondNum);
            
            System.out.println(sb.toString());
        }
        
    }
}