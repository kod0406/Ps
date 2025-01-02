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

        while(t>0){
            if(dir==0){//내려가기
                for(;row<n && ary[row][col]==0;row++){
                    ary[row][col] = t--; //근데 이렇게 하면 +-1이 되기에 for문이 끝나면 보정 해줘야함
                }
                dir = 1;
                row--;
                col++;// ->이미 칸이 채워져 있기에 1+해줘야함
            }
            else if(dir==1){//우측으로 이동하기
                for(;col<n && ary[row][col]==0;col++){
                    ary[row][col] = t--;
                }
                dir = 2;
                col--;
                row--;
            }
            else if(dir==2){//올라가기
                for(;row>=0 && ary[row][col]==0;row--){
                    ary[row][col] = t--;
                }
                dir = 3;
                row++;
                col--;
            }
            else if(dir==3){//좌측으로 이동하기
                for(;col>=0&&ary[row][col]==0;col--){
                    ary[row][col] = t--;
                }
                dir = 0;
                col++;
                row++;
            }
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
