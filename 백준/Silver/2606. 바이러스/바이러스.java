import java.io.*;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,K;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean is_visited [];

    public static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        is_visited[start] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            int crt = q.poll();
            for(int i=0;i<graph.get(crt).size();i++){
                int next = graph.get(crt).get(i);
                if(!is_visited[next]){
                    q.offer(next);
                    is_visited[next] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<K;i++){
            String s[]  =br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        is_visited = new boolean[N+1];
        int result = bfs(1);
        bw.write(String.valueOf(result));
        bw.flush();
    }
}