import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 연두의 이름 입력
        String yeonduName = scanner.nextLine();
        
        // 팀 이름 후보 개수 입력
        int n = Integer.parseInt(scanner.nextLine());
        
        // 팀 이름 후보 입력
        String[] teamNames = new String[n];
        for (int i = 0; i < n; i++) {
            teamNames[i] = scanner.nextLine();
        }
        
        String bestTeam = "";
        int bestScore = -1;
        
        for (String teamName : teamNames) {
            // L, O, V, E의 개수 계산
            int L = countCharacter(yeonduName + teamName, 'L');
            int O = countCharacter(yeonduName + teamName, 'O');
            int V = countCharacter(yeonduName + teamName, 'V');
            int E = countCharacter(yeonduName + teamName, 'E');
            
            // 공식에 따라 점수 계산
            int score = ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;
            
            // 최고 점수 갱신 (사전순 고려)
            if (score > bestScore || (score == bestScore && teamName.compareTo(bestTeam) < 0)) {
                bestTeam = teamName;
                bestScore = score;
            }
        }
        
        // 결과 출력
        System.out.println(bestTeam);
        scanner.close();
    }

    // 특정 문자의 개수를 세는 메서드
    private static int countCharacter(String str, char c) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }
}
