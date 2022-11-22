import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 1. participant를 HaspMap 으로 구성. 이때 이름이 key이며 인원이 value
        HashMap<String, Integer> partMap = new HashMap<>();
        for(String part : participant){
            if(partMap.containsKey(part)){
                int val = partMap.get(part);
                partMap.put(part, val+1);
            }else{
                partMap.put(part, 1);
            }
        }
        
        // 2. completion 이름을 키값으로 조사해 인원이 1이면 팝
        for(String comp : completion){
            if(partMap.containsKey(comp)){
                int val = partMap.get(comp);
                
                if(val == 1){
                    partMap.remove(comp);
                }else{
                    partMap.put(comp, val -1);
                }
            }
        }
        
        // 3. 모두 끝난 경우 남은 participant 결과 반환
        for(Entry<String, Integer> entry : partMap.entrySet()){
            answer = entry.getKey();
        }
        return answer;
    }
}