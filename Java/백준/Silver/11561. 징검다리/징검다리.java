import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long test = sc.nextLong();
        
        for(int i = 0; i < test; i++) {
            long n = sc.nextLong();
            
            long result = 0;
            long left = 0;
            long right = (long) Math.sqrt(2*n);
            
            while(left <= right) {
                long mid = (left + right) / 2;
                long sum = mid * (mid + 1) / 2;
                
                if(sum <= n) {
                    result = Math.max(result,mid);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            System.out.println(result);
        }
    }
}