import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] fre = new int[26];
        String input = br.readLine().toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            fre[input.charAt(i) - 'A']++;
        }

        int maxFreq = Integer.MIN_VALUE;
        char mostFrequentChar = '?';
        boolean isDuplicate = false;

        for (int i = 0; i < 26; i++) {
            if (fre[i] > maxFreq) {
                maxFreq = fre[i];
                mostFrequentChar = (char) (i + 'A');
                isDuplicate = false; // 새로운 최대값이 나타났으므로 중복은 없음
            } else if (fre[i] == maxFreq) {
                isDuplicate = true; // 동일한 최대값이 나타나면 중복 처리
            }
        }

        if (isDuplicate) {
            bw.write("?");
        } else {
            bw.write(mostFrequentChar);
        }

        bw.flush();
    }
}
