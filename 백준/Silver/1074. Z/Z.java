import java.io.*;

class Main{

    public static int recursion(int N,int r,int c){
        if(N == 0){
            return 0;
        }
        //사분면의 크기 구하기
        int half = (int)Math.pow(2,N-1);
        int area = half*half;
        //각각 1 2 3 4분면 구하는
        if(r<half && c<half){//1사분면
            return recursion(N-1,r,c);
        }else if(r<half && c>=half){//2사분면
            return area+recursion(N-1,r,c-half);
        }else if(r>=half && c<half){//3사분면
            return area*2 + recursion(N-1,r-half,c);
        }else{//4사분면
            return area*3 + recursion(N-1,r-half,c-half);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int rst = recursion(N,r,c);
        bw.write(String.valueOf(rst));
        bw.flush();
    }
}