import java.io.*;
/*
//https://www.acmicpc.net/problem/9184 BOJ 9184 "신나는 함수 실행"
class main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String input[] = br.readLine().split(" ");
            if(input[0].equals("-1")&&input[1].equals("-1")&&input[2].equals("-1"))
                break;


        }
    }
}*/
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 처리
        int n = Integer.parseInt(br.readLine());
        int location = Integer.parseInt(br.readLine()); // 특정 위치 값
        int[][] ary = new int[n][n]; // 나선형 배열
        int t = n * n; // 채울 값

        // 초기 위치 및 방향
        int row = 0, col = 0;
        int dir = 0; // 0: 아래, 1: 오른쪽, 2: 위, 3: 왼쪽

        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};
        while(t>0){
            ary[row][col] = t--;
            int next_col = col+dx[dir];
            int next_row = row+dy[dir];
            if (next_row >= n || next_col >= n || next_row < 0 || next_col < 0 || ary[next_row][next_col] != 0) { //bfs처럼 제한 두기
                dir = (dir + 1) % 4;
                next_row = row + dy[dir];
                next_col = col + dx[dir];
            }
            row = next_row;
            col = next_col;
        }

        // 결과 출력 및 location 값 확인
        int locRow = 0, locCol = 0; // location 값의 위치를 추적
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(ary[i][j] + " ");
                if (ary[i][j] == location) {
                    locRow = i+1;
                    locCol = j+1;
                }
            }
            bw.newLine();
        }

        bw.write(locRow + " " + locCol);
        bw.newLine();
        bw.flush();
    }
}
