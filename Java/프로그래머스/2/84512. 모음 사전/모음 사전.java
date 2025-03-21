import java.util.ArrayList;
import java.util.List;

class Solution {
    
    static List<String> list;
    static String [] alphabet = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        
        int answer = 0;
        list = new ArrayList<>();
        
        dfs("", 0);
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    static void dfs(String str, int len) {
        
        list.add(str);
        
        if (len == 5) return;
        
        for (int i = 0; i < 5; i++) {
            dfs(str + alphabet[i], len + 1);
        }
    }
}