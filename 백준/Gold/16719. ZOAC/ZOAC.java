import java.io.*;

class Main {
    static char[] charArr;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        charArr = input.toCharArray();
        used = new boolean[input.length()];
        recursion(0, input.length() - 1);
    }

    public static void recursion(int start, int end) {
        // 종료 조건: 시작 인덱스가 끝 인덱스보다 크면 종료
        if (start > end) {
            return;
        }

        int minIdx = -1;
        char minChar = Character.MAX_VALUE;

        // 현재 구간에서 사용되지 않은 문자 중 가장 작은 문자를 찾음
        for (int i = start; i <= end; i++) {
            if (!used[i] && charArr[i] < minChar) {
                minChar = charArr[i];
                minIdx = i;
            }
        }

        // 사용 가능한 문자가 없으면 종료
        if (minIdx == -1) {
            return;
        }

        used[minIdx] = true;

        // 지금까지 선택된 문자들을 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArr.length; i++) {
            if (used[i]) {
                sb.append(charArr[i]);
            }
        }
        System.out.println(sb);

        // 재귀 호출: 현재 선택한 인덱스 이후 구간과 그 이전 구간을 탐색
        recursion(minIdx + 1, end); // 우측 먼저
        recursion(start, minIdx - 1);
    }
}