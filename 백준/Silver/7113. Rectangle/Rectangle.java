import java.io.*;

class Main{

    public static int recursion(int n,int m){
        if(n == m) {
            return 1;
        }
        if(n == 0 || m == 0){
            return 0;
        }
        if(n > m){
            //return n/m + recursion(n%m,m);
            return 1 + recursion(n-m,m);
        }
        else{
            //return m/n + recursion(n,m%n);
            return 1 + recursion(n,m-n);
        }
    }//나누기를 할때 0되는 문젤 해결해야함


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input[] = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        bw.write(String.valueOf(recursion(n,m)));
        bw.flush();
    }
}