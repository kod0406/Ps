import java.io.*;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        int[] dice = new int[N];
        Arrays.fill(dice, 1);
        while (true) {
            bw.write(Arrays.toString(dice) + "\n");
            bw.flush();

            int i;
            for(i=N-1;i>=0;i--){
                if(dice[i]<R){
                    dice[i]++;
                    break;
                }
                else{
                    dice[i] = 1;
                }
            }
            if(i<0){
                break;
            }
        }
    }
}