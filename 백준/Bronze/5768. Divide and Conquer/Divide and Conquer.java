import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 약수의 개수를 구하는 함수
    private static int countDivisors(int x) {
        int count = 0;
        for (int i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                count++;
                if (i != x / i) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        while (true) {
           
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            

            if (M == 0 && N == 0) {
                break;
            }

            int maxX = -1;  // 약수가 가장 많은 X
            int maxY = -1;  // 가장 많은 약수의 개수

           
            for (int i = M; i <= N; i++) {
                int divisors = countDivisors(i);
                
                if (divisors > maxY || (divisors == maxY && i > maxX)) {
                    maxX = i;
                    maxY = divisors;
                }
            }

           
            System.out.println(maxX + " " + maxY);

        }
    }
}
