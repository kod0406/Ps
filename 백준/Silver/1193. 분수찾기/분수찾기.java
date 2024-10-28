import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int X = Integer.parseInt(br.readLine());
        int diagonal = 1;
        int sum = 0;

        
        while (sum < X) {
            sum += diagonal;
            diagonal++;
        }

        diagonal--; 
        sum -= diagonal; 

        int positionInDiagonal = X - sum;
        int numerator, denominator;

        if (diagonal % 2 == 0) {
            
            numerator = positionInDiagonal;
            denominator = diagonal - positionInDiagonal + 1;
        } else {
            
            numerator = diagonal - positionInDiagonal + 1;
            denominator = positionInDiagonal;
        }

        bw.write(numerator + "/" + denominator);
        bw.flush();
    }
}