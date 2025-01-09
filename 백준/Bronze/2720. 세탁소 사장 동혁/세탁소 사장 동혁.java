import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(br.readLine());
        for(int i=0;i<test_case;i++){
            int input = Integer.parseInt(br.readLine());
            int Q, D, N, P;
            Q = input / 25;
            input %= 25;
            D = input / 10;
            input %= 10;
            N = input / 5;
            input %= 5;
            P = input;
            bw.write(String.valueOf(Q)+" "+String.valueOf(D)+" "+String.valueOf(N)+" "+String.valueOf(P));
            bw.newLine();
            bw.flush();
        }

    }
}

