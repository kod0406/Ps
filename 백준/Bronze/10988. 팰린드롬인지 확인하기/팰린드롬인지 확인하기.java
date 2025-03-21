import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  =new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        bw.write(String.valueOf(is_palindrome(str)));
        bw.flush();
    }
    public static int is_palindrome(String input){
        int len = input.length();
        for(int i=0;i<len/2;i++){
            if(input.charAt(i) != input.charAt(len-i-1)){
                return 0;
            }
        }
        return 1;
    }
}