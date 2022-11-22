import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        // 1. 배열 초기화
        answer = new int[commands.length];
        
        for(int cmd = 0; cmd < commands.length; cmd++){
            // 2. 자르기
            int[] temp = Arrays.copyOfRange(array, commands[cmd][0]-1, commands[cmd][1]);
            
            // 3. 정렬
            Arrays.sort(temp);
            
            // 4. 값 가져오기
            answer[cmd] = temp[commands[cmd][2]-1];
        }
        return answer;
    }
}
