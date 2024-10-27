import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[26]; // 알파벳 소문자의 개수를 세기 위한 배열

        for (int i = 0; i < N; i++) {
            String surname = br.readLine();
            count[surname.charAt(0) - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] >= 5) {
                result.append((char) (i + 'a'));
            }
        }

        if (result.length() == 0) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(result.toString());
        }
    }
}