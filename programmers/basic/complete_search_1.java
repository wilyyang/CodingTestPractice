 import java.lang.Math; 

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] pair = new int[2];
        for(int[] temp : sizes){
            int maxIdx = temp[0]>temp[1] ? 0 : 1;
            int minIdx = maxIdx == 1 ? 0 : 1;
            
            // 1. 큰 값 검사
            if(temp[maxIdx] > pair[0])
                pair[0] = temp[maxIdx];
            
            // 2. 작은 값 검사
            if(temp[minIdx] > pair[1])
                pair[1] = temp[minIdx];
        }

        // 3. 두 값을 곱
        answer = pair[0] * pair[1];
        
        return answer;
    }
}
