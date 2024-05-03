class Solution {
    public int[] solution(long n) {
        String number = String.valueOf(n);
        int[] answer = new int[number.length()];
        
        for(int i= number.length()-1; i > -1; i--){
            answer[i] = Integer.parseInt(String.valueOf(number.charAt((number.length()-1)-i)));
        }
         
        return answer;
    }
}