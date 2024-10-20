import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int totalPlugs = 0;

        for (int i = 0; i < N; i++) {
            totalPlugs += Integer.parseInt(br.readLine());
        }


        int maxComputers = totalPlugs - (N - 1);
        System.out.println(maxComputers);
    }
}