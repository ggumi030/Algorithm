import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        char[] alpha = new char[strings.length];
        List<String> sortedStr = new ArrayList<>();
        int i = 0;
        
        for(String str : strings){ //인덱스 n번째 알파벳 배열에 담기
            alpha[i] = str.charAt(n);
            i++;
        }
        
        Arrays.sort(alpha); //알파벳 배열 정렬
        Arrays.sort(strings); //strings 배열 정렬 (같은 알파벳일 경우 사전순으로 정렬하기 위함)
        
        for(String str : strings){ //strings 배열 List에 담기
            sortedStr.add(str); 
        }
        
        i = 0;
        while(i < strings.length){
            for(int j = 0 ; j < sortedStr.size() ; j++){
                if(alpha[i] == (sortedStr.get(j).charAt(n))){
                    System.out.println(sortedStr.get(j)); //출력
                    answer[i] = sortedStr.get(j); //배열에 담기
                    sortedStr.remove(j); 
                    break;
                    // i++;
                }   
            }
            i++;
        }
        
        return answer;
    }
}