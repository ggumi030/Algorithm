class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;   
        int max_width = 0;
        int max_height = 0;
        
        for(int i = 0; i < sizes.length; i++){
            int width = 0;
            if(sizes[i][0] < sizes[i][1]){
                width = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = width;
            }
        }
        
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] > max_width){
                max_width = sizes[i][0];
            }
            
            if(sizes[i][1] > max_height){
                max_height = sizes[i][1];
            }
        }
        
        return max_width * max_height;
    }
}