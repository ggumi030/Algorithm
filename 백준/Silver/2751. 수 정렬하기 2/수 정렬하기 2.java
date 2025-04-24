import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        
        for(int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(numArr);
        
        for(int num : numArr) {
            bw.write(num + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}