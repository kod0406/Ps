import java.io.*;

class Main{
    public static void main(String args[])throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1;i<16;i++){
            bw.write(String.valueOf(i)+" ");
        }
        bw.flush();
    }
}