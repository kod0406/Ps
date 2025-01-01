import java.io.*;
import java.util.ArrayList;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input[] = br.readLine().split(" ");
        int R1 = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        bw.write(String.valueOf(S*2-R1));
        bw.flush();
    }
}