import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int answer = -1;

        // 1. 후보 집합 초기화
        HashSet<Integer>[] total = new HashSet[9];
        for(int i = 1, NN = 0; i<9; i++){
            total[i] = new HashSet<Integer>();
            total[i].add(NN = NN*10+N)  ;
        }
        
        // 2. 단계별 실행
        for(int i = 2; i < 9; i++){
            for(int j = 1, k = i-j; j < i; ++j, k = i-j){
                // 3. 2개의 값 연산
                for(int v1 : total[j]){
                    for(int v2 : total[k]){
                        total[i].add(v1+v2);
                        total[i].add(v1-v2);
                        total[i].add(v1*v2);
                        if(v2!=0)total[i].add(v1/v2);
                    }
                }
            }
        }
        
        // 4. 결과
        for(int i = 1; i < 9; i++)
            for(int val : total[i])
                if(val == number)
                    return i;

        return answer;
    }
}
