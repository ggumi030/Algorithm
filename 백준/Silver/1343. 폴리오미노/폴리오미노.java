import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == 'X') {
                count++;
            } else {
                if(count % 2 == 1) {
                    System.out.print("-1");
                    return;
                }
                
                 int A = (count) / 4;
                 int B = ((count) % 4) / 2;
                
                 for(int j = 0; j < A; j++) {
                     sb.append("AAAA");
                 }
                
                 for(int j = 0; j < B; j++) {
                      sb.append("BB");
                  }
                
                  sb.append(".");
                  count = 0; 
            }
           
        }
            
        if(count % 2 == 1) { 
            System.out.print("-1");
            return;
        }
        
        
         int A = (count) / 4;
         int B = ((count) % 4) / 2;
                
         for(int j = 0; j < A; j++) {
             sb.append("AAAA");
         }
                
         for(int j = 0; j < B; j++) {
             sb.append("BB");
         }

        System.out.print(sb.toString());
    }
}
