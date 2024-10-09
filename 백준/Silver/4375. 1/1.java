import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println(findSmallestOnesMultiple(n));
        }
        
        scanner.close();
    }
    
    private static int findSmallestOnesMultiple(int n) {
        int count = 1;
        int num = 1 % n;
        
        while (num != 0) {
            num = (num * 10 + 1) % n;
            count++;
        }
        
        return count;
    }
}