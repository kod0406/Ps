import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 
        
        List<int[]> pillars = new ArrayList<>();
        
        int leftMost = Integer.MAX_VALUE;
        int rightMost = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()); 
            int H = Integer.parseInt(st.nextToken());
            pillars.add(new int[]{L, H});
            
            // 가장 왼쪽과 오른쪽 기둥 위치를 저장
            leftMost = Math.min(leftMost, L);
            rightMost = Math.max(rightMost, L);
        }
        
        // 기둥을 위치(L)를 기준으로 정렬
        Collections.sort(pillars, Comparator.comparingInt(a -> a[0]));
        

        int[] heights = new int[rightMost + 1];
        

        for (int[] pillar : pillars) {
            heights[pillar[0]] = pillar[1];
        }
        
        // 가장 높은 기둥을 찾기
        int maxHeight = 0;
        int maxIdx = 0;
        for (int i = 0; i <= rightMost; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                maxIdx = i;
            }
        }
        
        // 면적 계산
        int area = 0;
        
        // 왼쪽에서 최대 높이 기둥까지 면적 계산
        int currentHeight = 0;
        for (int i = leftMost; i <= maxIdx; i++) {
            currentHeight = Math.max(currentHeight, heights[i]);
            area += currentHeight;
        }
        
        // 오른쪽에서 최대 높이 기둥까지 면적 계산
        currentHeight = 0;
        for (int i = rightMost; i > maxIdx; i--) {
            currentHeight = Math.max(currentHeight, heights[i]);
            area += currentHeight;
        }
        

        System.out.println(area);
    }
}
