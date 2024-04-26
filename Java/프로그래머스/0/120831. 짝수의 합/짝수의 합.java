class Solution {
    public int solution(int n) {
        int sum = 0;
        
        for(int i = 2; i < n + 1 ; i+=2 ){
              sum += i;
        }
        
        return sum;
    }
}