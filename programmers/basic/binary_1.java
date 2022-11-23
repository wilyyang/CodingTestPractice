import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        // 1. 초기화
        Arrays.sort(times);
        long min = 1, max = (long)times[0]*(long)n;
        long pivotTime = min + (max - min) / 2;
        long answer = max;
        
        while(true){
            // 2. 누적 처리 인원 계산
            long pass = 0;
            for(int i = 0; i<times.length; i++){
                pass += pivotTime / times[i];
            }
            // 3. 비교
            if(pass < n) {
                min = pivotTime;
            }else{
                max = pivotTime;
                // 3.1 정답 후보
                if(answer > pivotTime) answer = pivotTime;
            }

            // 4. 결정
            if(min >= (max-1)){
                break;
            }else{
                pivotTime = min + (max - min) / 2;
            }
        }
        return answer;
    }
}
