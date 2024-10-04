import java.io.*;
import java.util.*;

class Main{

    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static boolean is_visited[];
    static int distance[];

    public static int bfs(int start_node){
        int value = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start_node);
        is_visited[start_node] = true;
        distance[start_node] = 0;
        while(!q.isEmpty()){
            int crt = q.poll();
            for(int i=0;i<arrayList.get(crt).size();i++){
                int node = arrayList.get(crt).get(i);
                if(!is_visited[node]){
                    q.offer(node);
                    is_visited[node] = true;
                    distance[node] = distance[crt]+1;
                    value += distance[node];
                }
            }
        }
        return value;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        is_visited = new boolean[n+1];
        distance = new int[n+1];

        for(int i=0;i<=n;i++){
            arrayList.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            String input_2[] = br.readLine().split(" ");
            int one = Integer.parseInt(input_2[0]);
            int two = Integer.parseInt(input_2[1]);
            arrayList.get(one).add(two);
            arrayList.get(two).add(one);
        }


        int rst = Integer.MAX_VALUE;
        int people = -1;

        for(int i=1;i<=n;i++){
           Arrays.fill(is_visited,false);
           Arrays.fill(distance,0);
           int val = bfs(i);
           if(val < rst){
               rst = val;
               people = i;
           } else if(rst == val && i<people){
               people = i; // 작은 쪽 선택
           }
        }
        bw.write(String.valueOf(people));
        bw.flush();
    }
}
