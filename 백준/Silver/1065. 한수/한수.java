import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        int count = 0;
        if(input<=99){
            bw.write(Integer.toString(input));
        }
        else{
            for(int i=100;i<=input;i++){
                int v = i;
                int a,b,c;
                a = v / 100;
                v %= 100;
                b = v / 10;
                v %= 10;
                c = v;
                if((a-b) == (b-c)){
                    count++;
                }
            }
            bw.write(Integer.toString(count+99));
        }
        bw.flush();
    }
}