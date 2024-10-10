import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int[] percentages = new int[M];


        for (int i = 0; i < M; i++) {
            percentages[i] = Integer.parseInt(br.readLine());
        }


        int N = 1;
        while (true) {
            boolean valid = true;


            for (int p : percentages) {
                boolean found = false;


                for (int x = 0; x <= N; x++) {
                    int rounded = (int)Math.round((x * 100.0) / N);
                    if (rounded == p) {
                        found = true;
                        break;
                    }
                }

               
                if (!found) {
                    valid = false;
                    break;
                }
            }

            
            if (valid) {
                System.out.println(N);
                return;
            }

           
            N++;
        }
    }
}
