import java.util.stream.Stream;

class Solution {
    public boolean solution(int x) {
        int num = String.valueOf(x).chars().map(n -> n - 48).sum();
        
        if(x % num == 0){
            return true;
        }else{
            return false;
        }
    }
}