/*
import java.util.*;
import java.io.*;

class BFS {
    public static boolean visited[] = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void bfs(int value) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> q = new LinkedList<>();
        q.offer(value);

        while (!q.isEmpty()) { // 큐가 빌 때까지 실행
            int x = q.poll(); //  맨 첫 원소 빼기
            if (!visited[x]) { //  방문하지 않았을때
                visited[x] = true; // 큐에서 빼낼 때 방문 표시
                bw.write(String.valueOf(x) + " ");
                for (int i = 0; i < graph.get(x).size(); i++) {
                    int y = graph.get(x).get(i);
                    if (!visited[y]) {
                        q.offer(y);
                    }
                }
            }
        }
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 0번 인덱스는 제외
        // 노드 1에 연결된 노드 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        graph.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        graph.get(8).add(1);
        graph.get(8).add(7);
        bfs(1);
    }
}*/

import java.io.*;
import java.util.*;

class Main{
    public static boolean visited [][];
    public static int graph [][];
    public static int n,m;
    //배열 상에서 상하좌우 이동을 위한 배열 생성
    public static int dx [] = {-1, 1, 0, 0};
    public static int dy [] = {0, 0, -1, 1};

    public static int bfs(int start_x,int start_y) {
        int area = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start_x,start_y});
        visited[start_x][start_y] = true;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            area++;
            // 상하좌우로 이동 가능한 위치 탐색
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 이동할 위치가 유효한 범위 내에 있고, 아직 방문하지 않은 1이라면 큐에 추가
                if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && graph[nx][ny] ==1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return area;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input_NM [] = br.readLine().split(" ");
        n = Integer.parseInt(input_NM[0]);
        m = Integer.parseInt(input_NM[1]);
        visited = new boolean [n][m];
        graph = new int[n][m];
        for(int i=0;i<n;i++){
            String input [] = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }
        int numberOfPictures = 0;
        int maxArea = 0;
        // 도화지의 모든 위치를 순회
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                // 현재 위치가 1이고 방문하지 않은 경우, 새로운 그림의 시작
                if(graph[i][j] == 1 && !visited[i][j]){
                    numberOfPictures++;
                    int Area = bfs(i,j);
                    maxArea = Math.max(maxArea,Area);
                }
            }
        }
        bw.write(String.valueOf(numberOfPictures));
        bw.newLine();
        bw.write(String.valueOf(maxArea));
        bw.flush();
    }
}