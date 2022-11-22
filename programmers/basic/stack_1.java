import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        int[] temp = new int[arr.length];
        temp[0] = arr[0];
        // 1. arr에서 값을 하나씩 가져온다.
        int j = 0;
        for(int i = 1; i< arr.length; i++){
            // 2. 마지막 값이랑 비교해 다르면 추가한다.
            if(temp[j] != arr[i]){
                temp[++j] = arr[i];
            }
        }
        answer = new int[j+1];
        answer = Arrays.copyOf(temp, j+1);
        return answer;
    }
}