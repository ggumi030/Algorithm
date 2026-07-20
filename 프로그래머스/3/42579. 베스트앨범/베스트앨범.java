import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        // 조건
        // 1. plays 가 가장 큰 장르 먼저 수록
        // 2. 장르에서 plays가 가장 큰 노래 index 먼저 수록
        // 3. 장르 내에서 재생 횟수가 같으면 index가 작은 것 먼저 수록
        
        // 풀이
        
        // 1. 장르별로 전체 재생 횟수를 모두 더하여 HashMap에 저장한다.
        HashMap<String,Integer> totalGenres = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            totalGenres.put(genres[i], totalGenres.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 1-2. answer list를 선언
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 2. values 기준 내림차순을 통해 먼저 저장해야 할 장르의 순서를 판단한다.
        ArrayList<Map.Entry<String,Integer>> totalGenresEntries 
            = new ArrayList<>(totalGenres.entrySet());
        
        totalGenresEntries.sort((a,b) -> Integer.compare(b.getValue(), a.getValue()));
        
        // 3. 2에서 판단한 순서를 차례로 돌면서 조건 2와 3에 맞는 걸 2개 찾아 genres의 Index와 plays를 Ha                 shMap에 넣는다.
        // 3-1 ~ 3-4를 반복한다.
        for(int i = 0; i < totalGenresEntries.size(); i++) {
            String genre = totalGenresEntries.get(i).getKey();
            HashMap<Integer, Integer> genresIndexes = new HashMap<>();
            
            // 3-1. 2에서 만든 list에서 get(i) 하고 해당 genre와 같은 모든 index를 genres 배열에서 찾는                     다.
            for(int j = 0; j < genres.length; j++) {
                
                // 3-2. 해당 index를 가지고 plays[index]로 찾고 HashMap<Integer,Integer> genreInd                        exes = new HashMap<>(); 에 저장한다.
                if(genres[j].equals(genre)) {
                    genresIndexes.put(j,plays[j]);
                }
            }
            
            // 3-3. genres list를 끝까지 돌면서 찾은 후, 
                    // 정렬 : values 기준으로 내림차순 한다.
                    // 만약 values가 같으면 key 기준으로 오름차순한다.
            ArrayList<Map.Entry<Integer,Integer>> genresIndexesEntries 
                = new ArrayList<>(genresIndexes.entrySet());
            
            genresIndexesEntries.sort((a,b) -> {
                if(a.getValue() == b.getValue()) {
                    return Integer.compare(a.getKey(), b.getKey());
                }
                
                return Integer.compare(b.getValue(), a.getValue());
            });
            
            // 3-4. 정렬 된 list에서 0번과 1번을 뽑아서 answer 배열에 넣는다.
            // 디버깅 추가 : 만약 list길이가 1이하면 0만 넣음
            answer.add(genresIndexesEntries.get(0).getKey());
        
            if(genresIndexesEntries.size() <= 1) continue;
            answer.add(genresIndexesEntries.get(1).getKey());
            
        }
                    
        // 4. answer list를 배열로 변환한 후 return 한다.
        int[] answerArray = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            answerArray[i] = answer.get(i);
        }
        
        return answerArray;
    }
}