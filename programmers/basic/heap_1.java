import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 1. 값을 Heap 에 넣기 (자동정렬)
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int temp : scoville)
            heap.add(temp);
        
        // 2. 스코빌 검사
        while(heap.peek() < K){
            // 예외 검사
            if(heap.size() < 2){
                answer = -1;
                break;
            }
            // 3.1 가장 낮은 2개의 값 섞기
            int mix = heap.poll() + heap.poll() * 2;
            heap.add(mix);
            
            // 4. 
            ++answer;
        }
        
        // 3.2 통과
        return answer;
    }
}
