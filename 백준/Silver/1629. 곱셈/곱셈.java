import java.io.*;

class Main{

    public static Long mod(Long a,Long b,Long c){
        if(b == 1){
            return a%c;
        }
        Long val = mod(a,b/2,c);
        val = val * val % c; // 2^n = 2^n/2 * 2^n/2 이므로
        if(b%2 == 0){
            return val;
        }
        return val*a % c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Long A,B,C;
        String input[] = br.readLine().split(" ");
        A = Long.parseLong(input[0]);
        B = Long.parseLong(input[1]);
        C = Long.parseLong(input[2]);
        bw.write(String.valueOf(mod(A,B,C)));
        bw.flush();
    }
}

