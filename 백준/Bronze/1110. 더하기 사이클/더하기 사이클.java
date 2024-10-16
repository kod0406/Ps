import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int loop = n;
        do {
            int ten = loop/10;
            int one = loop%10;
            int sum = (ten+one) %10;
            loop = (one*10) + sum;
            cnt++;
        }while(loop != n);
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}