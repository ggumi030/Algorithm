import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int count= 0;
        int testcount = sc.nextInt();
        sc.nextLine();
        String[] answer = new String[testcount];

        while(testcount > 0){

            String input = sc.nextLine();
            String[] inputarrays = input.split(" ");

            String[] alpha = inputarrays[1].split("");

            StringBuilder stb = new StringBuilder();

            for(int i = 0; i < alpha.length; i++){
                for(int j = 0; j<Integer.parseInt(inputarrays[0]); j++){
                    stb.append(alpha[i]);
                }
            }

            answer[count] = stb.toString();

            count++;
            testcount--;
        }

        for(String str : answer){
            System.out.println(str);
        }

    }
}
