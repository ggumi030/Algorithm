import java.util.*;

public class Main {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);

        int testcase = input.nextInt();
        input.nextLine();

        String[] roomInfo = new String[testcase];

        int maxFloor = 0;
        int maxRoomNum = 0;

        for(int i =0 ; i< testcase ; i++){
            int floor = input.nextInt();
            input.nextLine();
            int roomnumber = input.nextInt();
            input.nextLine();
            roomInfo[i] = floor + " " + roomnumber;

            if(maxFloor < floor){
                maxFloor = floor;
            }

            if(maxRoomNum < roomnumber){
                maxRoomNum = roomnumber;
            }
        }

        int[][] family = new int[maxFloor+1][maxRoomNum];
        //2 14
        //1 14
        
        for(int j=0; j<maxRoomNum; j++){
            family[0][j] = j+1;
        }

        for(int i=0; i<maxFloor+1; i++){
            family[i][0] = 1;
        }
        
        for(int i=1; i<maxFloor+1; i++){
            for(int j=1; j<maxRoomNum; j++){
                family[i][j] = family[i][j-1] + family[i-1][j];
            }
        }
        
        //출력
        for(int i=0 ; i<testcase; i++){
            System.out.println(family[Integer.parseInt(roomInfo[i].split(" ")[0])][Integer.parseInt(roomInfo[i].split(" ")[1])-1]);
        }
        
    }
}