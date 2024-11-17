class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int height = 1;
        int width = yellow;
        
        while(true) {
            if(brown == (height + 2) * (width + 2) - yellow) {
                break;
            } else {
                height++;
                while(yellow % height != 0) {
                    height++;   
                }
                width = yellow / height;
            }
        }
    
        answer[0] = width + 2;
        answer[1] = height + 2;  
        return answer;
    }
}