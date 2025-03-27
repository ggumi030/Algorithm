class Solution {
    public String solution(int a, int b) {
        String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        a--;
        
        while(a > 0){
         b = switch(a) {
                case 1,3,5,7,8,10,12 -> b + 31;
                case 4,6,9,11 -> b + 30;
                case 2 -> b + 29;
                default -> b;
            };
            a--;
        }
        
        return (b % 7) == 0 ? "THU" : day[(b % 7) - 1];
    }
}