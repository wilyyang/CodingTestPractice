import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        // 1. 학생 배열 초기화
        int[] students = new int[n+2];
        Arrays.fill(students, 1);
        for(int l : lost) students[l] = 0;
        for(int r : reserve) students[r] = students[r] == 0 ? 1: 2;
        
        // 2. 정답 찾기
        for(int i = 1; i<students.length-1; i++){
            if( (students[i]==0 && students[i+1]==2) ||
               (students[i+1]==0 && students[i]==2)){
                answer+=2;
                ++i;
            } else if (students[i] > 0){
                answer+=1;
            }
        }
        
        return answer;
    }
}
