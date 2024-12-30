import java.io.*;

class Main{
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        if(input<0){
            bw.write(String.valueOf(input)+"\nminus");
        }
        else{
            bw.write(String.valueOf(input));
        }
        bw.flush();
    }
}