import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        int symmetricDifferenceSize = 0;

        for (int num : setA) {
            if (!setB.contains(num)) {
                symmetricDifferenceSize++;
            }
        }

        for (int num : setB) {
            if (!setA.contains(num)) {
                symmetricDifferenceSize++;
            }
        }

        System.out.println(symmetricDifferenceSize);
    }
}