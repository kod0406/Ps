import java.io.*;

class Main{
    static int graph[][];
    static int min_one = 0;
    static int zero = 0;
    static int one = 0;
    public static void recursion(int col,int row,int size){
        if(is_same_color(col,row,size)){
            return;
        }
        int new_size = size/3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                recursion(col+i*new_size,row+j*new_size,new_size);
            }
        }
    }
    //재귀의 조건식 -> 이전의 인덱스와 현재 인덱스의 값이 다르면 /9를 해서 재귀 돌리기
    //그러면 이전에 인덱스와 비교해서 같은지 아닌지를 확인하는 메서드 필여
    public static boolean is_same_color(int col,int row,int size){
        int color = graph[col][row];
        for(int i=col;i<col+size;i++){
            for (int j=row;j<row+size;j++){
                if(color != graph[i][j]){
                    return false;
                }
            }
        }
        if(color == -1){
            min_one++;
        } else if (color == 0){
            zero++;
        } else if(color == 1){
            one++;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for(int i=0;i<n;i++){
            String input[] = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }
        recursion(0,0,n);
        bw.write(min_one + "\n" + zero + "\n" + one + "\n");
        bw.flush();
    }
}