import java.util.*;
import java.lang.Math;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        // 1. 배열로 트리 생성
        int[] tree = new int[(int)Math.pow(2, numbers.length+1) ];
        for(int i = 0; i < numbers.length; i++){
            Arrays.fill(tree, (int)(Math.pow(2, i+1)), (int)(Math.pow(2, i+2)), numbers[i]);
        }
        
        for(int i = 1; i < tree.length; i+=2){
            tree[i] *= -1;
        }

        // 2. 말단부터 결과 찾기
        for(int i = (int)(Math.pow(2, numbers.length)); i< tree.length; i++){
            int cIdx = i, sum = tree[cIdx];
            
            do{
                int pIdx = cIdx/2;
                sum = tree[pIdx] + sum;
                cIdx = pIdx;
            }while(cIdx > 3);
            
            if(sum == target)++answer;
        }
        return answer;
    }
}
