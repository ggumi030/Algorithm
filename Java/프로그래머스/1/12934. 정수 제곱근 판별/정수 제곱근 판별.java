import java.lang.Math;

class Solution {
    public long solution(long n) {
        String array[] = String.valueOf(Math.sqrt(n)).split("\\.");
        return array[1].equals("0") ? (long) Math.pow(Math.sqrt(n)+1,2) : -1 ;
    }
}