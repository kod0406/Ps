import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 입력된 7개의 숫자를 배열에 저장
        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 배열 정렬
        Arrays.sort(arr);
        
        // A, B, C 값 추출
        int A = arr[0];
        int B = arr[1];
        int C = arr[6] - (A + B);  // A + B + C = arr[6]이므로, C = arr[6] - (A + B)
        
        // 결과 출력
        System.out.println(A + " " + B + " " + C);
    }
}
