import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] line = new char[N];
        
        for (int i = 0; i < N; i++) {
            line[i] = br.readLine().charAt(0);
        }
        
        int position = 1; // Start counting from 1 for Aron
        for (int i = 1; i < N; i++) {
            if (line[i] != line[i - 1]) {
                position++;
            }
        }
        
        System.out.println(position + 1); // Aron is after the last group/individual
    }
}