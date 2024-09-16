import java.io.*;
import java.util.Arrays;

class Main {
    public static int find_card(int deck[], int k, int n) {
        int s = 0, e = n - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (deck[mid] == k) {
                return 1;
            } else if (deck[mid] < k) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int card = Integer.parseInt(br.readLine());
        int deck[] = new int[card];
        String input_1[] = br.readLine().split(" ");
        for (int i = 0; i < card; i++) {
            deck[i] = Integer.parseInt(input_1[i]);
        }
        Arrays.sort(deck);

        int search_card = Integer.parseInt(br.readLine());
        String input_2[] = br.readLine().split(" ");

        for (int i = 0; i < search_card; i++) {
            int result = find_card(deck, Integer.parseInt(input_2[i]), card);
            bw.write(result + " ");
        }

        bw.flush();
    }
}