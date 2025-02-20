import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                bw.write("*");
            }
            for (int j = 0; j < 2 * (N - i); j++) {
                bw.write(" ");
            }
            for (int j = 0; j < i; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                bw.write("*");
            }
            for (int j = 0; j < 2 * (N - i); j++) {
                bw.write(" ");
            }
            for (int j = 0; j < i; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}