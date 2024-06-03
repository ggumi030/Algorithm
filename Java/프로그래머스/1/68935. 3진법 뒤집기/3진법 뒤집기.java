class Solution {
    public int solution(int n) {
        int answer = 0;

        String str = "";

        while(n>0)
        {
            int r = n%3;
            n = n / 3;
            str = r + str;
        }
        System.out.println(str);

        for(int i=0; i<str.length(); i++)
        {
            answer += Math.pow(3,i) * (str.charAt(i) - '0');
        }

        return answer;
    }
}