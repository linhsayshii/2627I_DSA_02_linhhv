import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine().trim());

        Deque<Integer> inStack = new ArrayDeque<>();
        Deque<Integer> outStack = new ArrayDeque<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int x = Integer.parseInt(st.nextToken());
                inStack.push(x);
            } else {
                if (outStack.isEmpty()) {
                    while (!inStack.isEmpty()) {
                        outStack.push(inStack.pop());
                    }
                }

                if (type == 2) {
                    outStack.pop();
                } else { // type == 3
                    answer.append(outStack.peek()).append('\n');
                }
            }
        }
        System.out.print(answer);
    }
}