import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String,Integer>wearable = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int rst[] = new int[n];
        for(int i=0;i<n;i++){
            int m = Integer.parseInt(br.readLine());
            wearable.clear();
            for(int j=0;j<m;j++){
                String input[] = br.readLine().split(" ");
                String kind = input[1];
                wearable.put(kind,wearable.getOrDefault(kind,0)+1);
            }
            int result = 1;
            for (int count : wearable.values()) {
                result *= (count + 1);
            }

            // 알몸인 경우(아무 것도 입지 않은 경우) 제외
            result -= 1;
            
            rst[i] = result;
        }
        for(int i=0;i<n;i++){
            bw.write(String.valueOf(rst[i]));
            bw.newLine();
        }
        bw.flush();
    }
}