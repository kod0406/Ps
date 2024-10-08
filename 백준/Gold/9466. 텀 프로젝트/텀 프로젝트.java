import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] state;
    static ArrayList<ArrayList<Integer>> graph;

    static final int NOT_VISITED = 0;
    static final int VISITED = 1;
    static final int CYCLE_IN = 2;
    static final int NOT_CYCLE_IN = 3;

    public static void run(int x) {
        int cur = x;
        while (true) {
            state[cur] = VISITED;
            cur = graph.get(cur).get(0); // Get the next student
            // 다음 노드가 사이클에 포함된 노드 또는 이미 처리된 노드일 경우 ->현재 탐색 중인 노드는 포함되지 않은 노드들로 처리
            if (state[cur] == CYCLE_IN || state[cur] == NOT_CYCLE_IN) {
                cur = x;
                while (state[cur] == VISITED) {
                    state[cur] = NOT_CYCLE_IN;
                    cur = graph.get(cur).get(0);
                }
                return;
            }
            // 다른 노드와 사이클을 이룰떄
            if (state[cur] == VISITED && cur != x) {
                while (state[cur] != CYCLE_IN) {
                    state[cur] = CYCLE_IN;
                    cur = graph.get(cur).get(0);
                }
                cur = x;
                while (state[cur] != CYCLE_IN) {
                    state[cur] = NOT_CYCLE_IN;
                    cur = graph.get(cur).get(0);
                }
                return;
            }
            // 자기자신이 사이클일때(재귀)
            if (state[cur] == VISITED && cur == x) {
                while (state[cur] != CYCLE_IN) {
                    state[cur] = CYCLE_IN;
                    cur = graph.get(cur).get(0);
                }
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            graph = new ArrayList<>(); // 어짜피 배열이 아니므로 0이여도 상관X
            state = new int[n + 1]; // 배열이니 1부터


            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }


            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                int choice = Integer.parseInt(input[j - 1]);
                graph.get(j).add(choice);
            }


            for (int j = 1; j <= n; j++) {
                if (state[j] == NOT_VISITED) {
                    run(j);
                }
            }

            // 사이클에 포함되지 않는 친구들 세기
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (state[j] == NOT_CYCLE_IN) cnt++;
            }

            bw.write(String.valueOf(cnt));
            bw.newLine();
        }
        bw.flush();
    }
}