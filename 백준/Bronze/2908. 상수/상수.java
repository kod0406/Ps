import java.io.*;

class Main {
    public static int reverse(int a) {
        StringBuilder sb = new StringBuilder(String.valueOf(a));
        return Integer.parseInt(sb.reverse().toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int w = reverse(n);
        int u = reverse(m);
        bw.write(String.valueOf(Math.max(w, u)));
        bw.flush();
        
    }
}