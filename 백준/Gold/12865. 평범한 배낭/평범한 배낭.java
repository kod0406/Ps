import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input_1[] = br.readLine().split(" ");
        int amount = Integer.parseInt(input_1[0]);
        int max_weight  = Integer.parseInt(input_1[1]);
        int dp[][] = new int[amount+1][max_weight+1];
        int weight[] = new int[amount];
        int value[] = new int[amount];

        for(int i=0;i<amount;i++){
            String input_2[] = br.readLine().split(" ");
            for(int j=0;j<amount;j++){
                weight[i] = Integer.parseInt(input_2[0]);
                value[i] = Integer.parseInt(input_2[1]);
            }
        }

       for(int i=0;i<amount;i++){
            Arrays.fill(dp[i],0);
       }

       for(int i=1;i<=amount;i++){
           for(int j=0;j<=max_weight;j++){
               if(j<weight[i-1]){
                   dp[i][j] = dp[i-1][j];
               }else{
                   dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]] + value[i-1]);
               }//dp[i-1][j-weight[i-1]] = i번째 물건을 새로 넣을 때, 이 물건 빼고 남는 공간으로 이전의 (i-1)개 물건만으로 만들 수 있는‘최대 가치
           }
       }
       bw.write(String.valueOf(dp[amount][max_weight]));
       bw.flush();
    }
}