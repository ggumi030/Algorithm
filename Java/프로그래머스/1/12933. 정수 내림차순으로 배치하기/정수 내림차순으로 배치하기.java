import java.util.ArrayList;
import java.util.Collections;
import java.lang.StringBuilder;

class Solution {
    public long solution(long n) {
        ArrayList<Long> nums = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        
        while(n!=0){
            long num = n%10;
            nums.add(num);
            n = n/10;
        }
        
        Collections.sort(nums,Collections.reverseOrder());
        
        for(Long num : nums){
           result = result.append(num);
        }
        
        return Long.parseLong(result.toString());
    }
}