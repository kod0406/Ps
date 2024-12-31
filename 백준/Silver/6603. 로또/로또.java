import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Main {
    static List<Integer> ary = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();

    public static void recursion(int start, int depth, BufferedWriter bw) throws IOException {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                bw.write(result.get(i) + " ");
            }
            bw.newLine();
            return;
        }
        for (int i = start; i < ary.size(); i++) {
            result.add(ary.get(i));
            recursion(i + 1, depth + 1, bw);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        boolean firstCase = true;

        while (!(line = br.readLine()).equals("0")) {
            if (!firstCase) {
                bw.newLine();
            }
            firstCase = false;

            String[] input = line.split(" ");
            int k = Integer.parseInt(input[0]);
            ary.clear();
            for (int i = 1; i <= k; i++) {
                ary.add(Integer.parseInt(input[i]));
            }
            recursion(0, 0, bw);
        }
        bw.flush();
    }
}