import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(N);
        }
        if(sb.length()>M){
            bw.write(sb.substring(0,M));
        }else{
            bw.write(String.valueOf(sb));
        }
        bw.flush();
    }
}
