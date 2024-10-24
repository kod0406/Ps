import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] yut = new int[4];
            int zeroCount = 0;

            for (int j = 0; j < 4; j++) {
                yut[j] = Integer.parseInt(st.nextToken());
                if (yut[j] == 0) {
                    zeroCount++;
                }
            }

            switch (zeroCount) {
                case 1:
                    bw.write("A\n");
                    break;
                case 2:
                    bw.write("B\n");
                    break;
                case 3:
                    bw.write("C\n");
                    break;
                case 4:
                    bw.write("D\n");
                    break;
                case 0:
                    bw.write("E\n");
                    break;
            }
        }

        bw.flush();
    }
}