import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Integer A [] = new Integer[N];
        Integer B [] = new Integer[N];

        String[] aInput = br.readLine().split(" ");
        String[] bInput = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(aInput[i]);
            B[i] = Integer.parseInt(bInput[i]);
        }

        Arrays.sort(A); // A를 오름차순
        Arrays.sort(B,Collections.reverseOrder()); //B는 내림차순

        int S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i] * B[i]; // A는 내림차순으로 접근
        }

        bw.write(String.valueOf(S));
        bw.flush();
    }
}