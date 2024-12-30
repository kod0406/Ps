class Solution {
    public int solution(int[] common) {
        int n = common.length;
        if (common[1] - common[0] == common[2] - common[1]) {
            // 등차수열인 경우
            int difference = common[1] - common[0];
            return common[n - 1] + difference;
        } else {
            // 등비수열인 경우
            int ratio = common[1] / common[0];
            return common[n - 1] * ratio;
        }
    }
}