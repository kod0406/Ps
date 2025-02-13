import java.io.*;

class Main{
    public static void main(String[] args)throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         int n = Integer.parseInt(br.readLine());
         int dp_table[] = new int[1001];
         dp_table[0] = 1;
         dp_table[1] = 2;
        if (n > 2) {
            for(int i=2;i<n;i++){
                dp_table[i] = (dp_table[i-1]+dp_table[i-2])%10007;
            }
        }
         bw.write(String.valueOf(dp_table[n-1]));
         bw.flush();
    }
}