import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> dwarfs = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            dwarfs.add(Integer.parseInt(br.readLine()));
        }
        findSevenDwarfs(dwarfs);
    }

    public static void findSevenDwarfs(ArrayList<Integer> dwarfs) {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                int sum = 0;
                ArrayList<Integer> selectedDwarfs = new ArrayList<>();
                for (int k = 0; k < 9; k++) {
                    if (k != i && k != j) {
                        sum += dwarfs.get(k);
                        selectedDwarfs.add(dwarfs.get(k));
                    }
                }
                if (sum == 100) {
                    for (int dwarf : selectedDwarfs) {
                        System.out.println(dwarf);
                    }
                    return;
                }
            }
        }
    }
}