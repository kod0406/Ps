import java.io.*;
import  java.util.Set;
import java.util.HashSet;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input[] = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int cnt = 0;

        Set<String> list = new HashSet<>();

        for(int i=0;i<n;i++){
            list.add(br.readLine());
        }
        for(int i=0;i<m;i++){
            String str = br.readLine();
            if(list.contains(str)) {
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}