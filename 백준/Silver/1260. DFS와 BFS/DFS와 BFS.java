import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, V;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean is_visited[];

    public static void bfs(int V) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        is_visited[V] = true;
        while (!q.isEmpty()) {
            int crt = q.poll();
            bw.write(String.valueOf(crt) + " ");
            for (int i = 0; i < graph.get(crt).size(); i++) {
                int y = graph.get(crt).get(i);
                if (!is_visited[y]) {
                    q.offer(y);
                    is_visited[y] = true;
                }
            }
        }
        bw.newLine();
        bw.flush();
    }

    public static void dfs(int V) throws IOException {
        Stack<Integer> stack = new Stack<>();
        stack.push(V);
        is_visited[V] = true;
        bw.write(V + " ");

        while (!stack.isEmpty()) {
            int crt = stack.peek(); // 현재 정점을 스택의 최상위로 확인
            boolean foundUnvisited = false; // 방문할 수 있는 미방문 정점 확인

            for (int i = 0; i < graph.get(crt).size(); i++) {
                int y = graph.get(crt).get(i);
                if (!is_visited[y]) {
                    stack.push(y); // 다음 방문할 정점만 푸시
                    is_visited[y] = true; 
                    bw.write(y + " ");
                    foundUnvisited = true; // 미방문 정점이 있음을 표시
                    break; // 한 번 방문하면 루프 종료
                }
            }

            if (!foundUnvisited) {
                stack.pop(); // 더 이상 방문할 수 있는 정점이 없다면 현재 정점을 pop
            }
        }
        bw.newLine();
    }

    public static void main(String[] args) throws IOException {
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]);

        for (int i = 0; i <= N; i++) { //정점 번호가 1부터 시작하기 때문 그렇기에 N-1이 아닌 N까지며, boolean또한 N+1로 초기화 및 설정함
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String s[] = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        } //방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문 -> 오름차순으로 정렬

        is_visited = new boolean[N + 1];
        dfs(V);

        is_visited = new boolean[N + 1];
        bfs(V);

        bw.flush();
    }
}