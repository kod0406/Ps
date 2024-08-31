import java.io.*;
import java.util.HashSet;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> rst = new HashSet<>();
        String input = br.readLine();
        for(int i=0;i<input.length();i++){
            for(int j=i+1;j<=input.length();j++){
                rst.add(input.substring(i,j));
            }
        }
        int output = rst.size();
        bw.write(String.valueOf(output));
        bw.flush();
    }
}