import java.io.*;
import java.util.Stack;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int output = 0;
        int input = Integer.parseInt(br.readLine());
        for(int i=0;i<input;i++){
            Stack<Character>rst = new Stack<>();
            String a = br.readLine();
            for(int j=0;j<a.length();j++){
                if(rst.isEmpty()){
                    rst.push(a.charAt(j));
                }
                else{
                    if(rst.peek() == a.charAt(j)){
                        rst.pop();
                    }
                    else{
                        rst.push(a.charAt(j));
                    }
                }
            }
            if(rst.isEmpty()){
                output++;
            }
        }
        bw.write(String.valueOf(output));
        bw.flush();
    }
}