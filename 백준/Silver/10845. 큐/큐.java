import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        List<Integer> queue = new ArrayList<>();
        int num = 0;
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            switch(st.nextToken()) {
                case "push" :
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    if(queue.size() == 0) {
                        bw.write(-1 + "\n");
                        break;
                    }
                    num = queue.get(0);
                    bw.write(num + "\n");
                    queue.remove(0);
                    break;
                case "size" :
                    bw.write(queue.size() + "\n");
                    break;
                case "empty" :
                    if(queue.isEmpty()) {
                        bw.write(1 + "\n");
                        break;
                    }
                    bw.write(0 + "\n");
                    break;
                case "front" :
                    if(queue.size() == 0) {
                        bw.write(-1 + "\n");
                        break;
                    }
                    num = queue.get(0);
                    bw.write(num + "\n");
                    break;
                case "back" :
                    if(queue.size() == 0) {
                        bw.write(-1 + "\n");
                        break;
                    }
                    num = queue.get(queue.size() - 1);
                    bw.write(num + "\n");
                    break;
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}