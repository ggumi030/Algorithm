import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int percent = (int)((long)y * 100 / x);
        
        if(percent >= 99) {
            System.out.println(-1);
            return;
        }
        
        int left = 1;
        int right = x;
        int result = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int newPercent = (int)((long)(y + mid) * 100 / (x + mid));
            
            if(newPercent > percent) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
       
        System.out.println(result);
    }
}