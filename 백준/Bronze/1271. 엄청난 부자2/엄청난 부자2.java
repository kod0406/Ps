import java.io.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        BigInteger n = new BigInteger(input[0]);
        BigInteger m = new BigInteger(input[1]);

        BigInteger quotient = n.divide(m);
        BigInteger remainder = n.remainder(m);

        System.out.println(quotient);
        System.out.println(remainder);
    }
}