import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input[] = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int bucket[] = new int[a];
        for(int i=0;i<b;i++){
            String input_2[] = br.readLine().split(" ");
            //1 2 까지 3의 값을 넣는다고 바부야
            int from = Integer.parseInt(input_2[0])-1;
            int to = Integer.parseInt(input_2[1])-1;
            int ball = Integer.parseInt(input_2[2]);
            for(int j=from;j<=to;j++){
                bucket[j] = ball;
            }
        }
        bw.write(Arrays.toString(bucket).replaceAll("[\\[\\]\\,]",""));
        bw.flush();
    }
}

