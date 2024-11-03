import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        
        long[] tree = new long[n];
        
        for(int i = 0; i < n; i++) {
            tree[i] = sc.nextLong();
        }
        
        long left = 0;
        long right = 1000000000;
        long answer = 0;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long guessM = 0;
            
            for(long height : tree) {
                long remain = height - mid;
                if( remain > 0) {
                    guessM += remain;
                }
            }
            
            if(guessM >= m) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
}