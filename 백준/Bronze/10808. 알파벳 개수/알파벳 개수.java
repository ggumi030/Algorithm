import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String line = br.readLine();
        char[] charArr = line.toCharArray();
        int[] alpha = new int[26];
        
        for(char ch : charArr) {
            alpha[(int) ch % 97] += 1;
        }
        
        for(int num : alpha) {
            bw.write(num + " ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}