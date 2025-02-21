import java.io.*;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int arr[] = new int[N];
        String input_2[] = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(input_2[i]);
        }
        int prefix_sum[] = new int[N+1];
        for(int i=0;i<N;i++){
            prefix_sum[i+1] = prefix_sum[i] + arr[i];
        }
        for(int i=0;i<M;i++){
            String input3[] = br.readLine().split(" ");
            int a = Integer.parseInt(input3[0]);
            int b = Integer.parseInt(input3[1]);
            int rst = prefix_sum[b] - prefix_sum[a-1];
            bw.write(String.valueOf(rst));
            bw.newLine();
        }
        bw.flush();
    }
}