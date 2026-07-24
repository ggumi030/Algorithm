import java.util.*;

class Solution {
    List<Integer> selectedIndex;
    int count;

    public void dfs(int start, int depth, int maxDepth,
                    int[] numbers, int target) {
        if (depth == maxDepth) {
            int sum = 0;

            for (int i = 0; i < numbers.length; i++) {
                if (selectedIndex.contains(i)) {
                    sum -= numbers[i];
                } else {
                    sum += numbers[i];
                }
            }

            if (sum == target) {
                count++;
            }
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            selectedIndex.add(i);

            dfs(i + 1, depth + 1, maxDepth, numbers, target);

            selectedIndex.remove(selectedIndex.size() - 1);
        }
    }

    public int solution(int[] numbers, int target) {
        count = 0;

        for (int minusCount = 0; minusCount <= numbers.length; minusCount++) {
            selectedIndex = new ArrayList<>();
            dfs(0, 0, minusCount, numbers, target);
        }

        return count;
    }
}