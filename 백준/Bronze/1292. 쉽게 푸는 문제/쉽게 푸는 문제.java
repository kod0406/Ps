import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);


        int[] sequence = new int[1001];  
        int index = 1;


        for (int i = 1; index <= 1000; i++) {
            for (int j = 0; j < i && index <= 1000; j++) {
                sequence[index++] = i;
            }
        }


        int sum = 0;
        for (int i = A; i <= B; i++) {
            sum += sequence[i];
        }


        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
