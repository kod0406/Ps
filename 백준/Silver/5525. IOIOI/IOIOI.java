import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); 
        int M = Integer.parseInt(br.readLine()); 
        String S = br.readLine(); 

        int count = 0; 
        int patternCount = 0; // 연속된 IOI의 개수

       
        for (int i = 1; i < M - 1; i++) {
            // IOI 패턴을 찾았을 때
            if (S.charAt(i) == 'O' && S.charAt(i + 1) == 'I' && S.charAt(i - 1) == 'I') {
                patternCount++; // IOI 패턴이 연속되므로 개수를 셈
                
                // PN 패턴이 완성되면 (연속된 IOI의 개수가 N 이상이면 PN 패턴 포함)
                if (patternCount >= N) {
                    count++;
                }
                // 이미 IOI를 찾았으니 다음으로 바로 이동 
                i++;
            } else {
                patternCount = 0; // 연속되지 않는 경우 초기화
            }
        }

        System.out.println(count);
    }
}
