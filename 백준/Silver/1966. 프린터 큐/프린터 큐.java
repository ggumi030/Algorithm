import java.io.*;
import java.util.*;

public class Main {

    static class Document {
        int sequence;
        int priority;

        Document(int sequence, int priority) {
            this.sequence = sequence;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Deque<Document> deque = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                deque.offerLast(new Document(j, Integer.parseInt(st.nextToken())));
            }

            int cnt = 1;
            while (!deque.isEmpty()) {
                Document current = deque.pollFirst();

                boolean hasHigher = false;
                for (Document doc : deque) {
                    if (doc.priority > current.priority) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    deque.offerLast(current);
                } else {
                    if (current.sequence == M) {
                        bw.write(cnt + "\n");
                        break;
                    }
                    cnt++;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
