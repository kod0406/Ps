import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        Stack<Character> stk = new Stack<>();
        int rst = 0;
        int len = input.length();
        for(int i=0;i<len;i++){
            if(input.charAt(i) == '('){
                stk.push(input.charAt(i));
            } else { // 끝나는 지점이면
                stk.pop();
                if(input.charAt(i-1) == '('){ //레이저의 끝나는 지점일 경우
                    rst += stk.size();
                }
                else{ // 파이프의 끝일 경우
                    rst+=1;
                }
            }
        }
        bw.write(String.valueOf(rst));
        bw.flush();
    }
}