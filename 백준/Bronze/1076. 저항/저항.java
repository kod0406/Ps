import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> valueMap = new HashMap<>();
        Map<String, Long> multiplierMap = new HashMap<>();

        // 값 
        valueMap.put("black", 0);
        valueMap.put("brown", 1);
        valueMap.put("red", 2);
        valueMap.put("orange", 3);
        valueMap.put("yellow", 4);
        valueMap.put("green", 5);
        valueMap.put("blue", 6);
        valueMap.put("violet", 7);
        valueMap.put("grey", 8);
        valueMap.put("white", 9);

        // 곱 
        multiplierMap.put("black", 1L);
        multiplierMap.put("brown", 10L);
        multiplierMap.put("red", 100L);
        multiplierMap.put("orange", 1000L);
        multiplierMap.put("yellow", 10000L);
        multiplierMap.put("green", 100000L);
        multiplierMap.put("blue", 1000000L);
        multiplierMap.put("violet", 10000000L);
        multiplierMap.put("grey", 100000000L);
        multiplierMap.put("white", 1000000000L);


        String color1 = br.readLine();
        String color2 = br.readLine();
        String color3 = br.readLine();


        int firstDigit = valueMap.get(color1);
        int secondDigit = valueMap.get(color2);
        long multiplier = multiplierMap.get(color3);


        long resistanceValue = (firstDigit * 10L + secondDigit) * multiplier;


        bw.write(String.valueOf(resistanceValue));
        bw.flush();
    }
}
