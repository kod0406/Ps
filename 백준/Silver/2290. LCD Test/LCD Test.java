import java.io.*;

class Main {
    static int digit[][] ={
            {1, 1, 1, 0, 1, 1, 1}, // 0
            {0, 0, 1, 0, 0, 1, 0}, // 1
            {1, 0, 1, 1, 1, 0, 1}, // 2
            {1, 0, 1, 1, 0, 1, 1}, // 3
            {0, 1, 1, 1, 0, 1, 0}, // 4
            {1, 1, 0, 1, 0, 1, 1}, // 5
            {1, 1, 0, 1, 1, 1, 1}, // 6
            {1, 0, 1, 0, 0, 1, 0}, // 7
            {1, 1, 1, 1, 1, 1, 1}, // 8
            {1, 1, 1, 1, 0, 1, 1}  // 9
    };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        String m = input[1];
        int len = m.length();

        //최상단
        for(int i=0;i<len;i++){
            if(i>0){
                bw.write(" ");
            }
            int digits = Integer.parseInt(String.valueOf(m.charAt(i)));
            bw.write(" ");
            if(digit[digits][0] == 1){
                bw.write("-".repeat(n));
            }else{
                bw.write(" ".repeat(n));
            }
            bw.write(" ");
        }
        bw.newLine();
        //상단 세로
        for(int i=0;i<n;i++){
            for(int j=0;j<len;j++){
                if(j>0){
                    bw.write(" ");
                }
                int digits = Integer.parseInt(String.valueOf(m.charAt(j)));
                if(digit[digits][1] == 1){
                    bw.write("|");
                }
                else{
                    bw.write(" ");
                }
                bw.write(" ".repeat(n));
                if(digit[digits][2] == 1){
                    bw.write("|");
                }
                else{
                    bw.write(" ");
                }
            }
            bw.newLine();
        }
        //중간부분
        for(int i=0;i<len;i++){
            if(i>0){
                bw.write(" ");
            }
            int digits = Integer.parseInt(String.valueOf(m.charAt(i)));
            bw.write(" ");
            if(digit[digits][3] == 1){
                bw.write("-".repeat(n));
            }else{
                bw.write(" ".repeat(n));
            }
            bw.write(" ");
        }
        bw.newLine();
        //하단 세로
        for(int i=0;i<n;i++){
            for(int j=0;j<len;j++){
                if(j>0){
                    bw.write(" ");
                }
                int digits = Integer.parseInt(String.valueOf(m.charAt(j)));
                if(digit[digits][4] == 1){
                    bw.write("|");
                }
                else{
                    bw.write(" ");
                }
                bw.write(" ".repeat(n));
                if(digit[digits][5] == 1){
                    bw.write("|");
                }
                else{
                    bw.write(" ");
                }
            }
            bw.newLine();
        }
        //맨 하단
        for(int i=0;i<len;i++){
            if(i>0){
                bw.write(" ");
            }
            int digits = Integer.parseInt(String.valueOf(m.charAt(i)));
            bw.write(" ");
            if(digit[digits][6] == 1){
                bw.write("-".repeat(n));
            }else{
                bw.write(" ".repeat(n));
            }
            bw.write(" ");
        }
        bw.flush();
    }
}