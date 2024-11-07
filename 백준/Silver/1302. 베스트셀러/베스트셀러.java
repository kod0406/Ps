import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        scanner.nextLine();
        
       
        Map<String, Integer> bookSales = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String book = scanner.nextLine();
            bookSales.put(book, bookSales.getOrDefault(book, 0) + 1);
        }
        
        
        String bestSeller = "";
        int maxSales = 0;
        
        for (Map.Entry<String, Integer> entry : bookSales.entrySet()) {
            String book = entry.getKey();
            int sales = entry.getValue();
            
            // 더 많이 팔렸거나, 판매 수가 같으면 사전순으로 앞서는 책 선택
            if (sales > maxSales || (sales == maxSales && book.compareTo(bestSeller) < 0)) {
                maxSales = sales;
                bestSeller = book;
            }
        }
        
        System.out.println(bestSeller);
        scanner.close();
    }
}
