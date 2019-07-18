package areFollowingPatterns;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    boolean areFollowingPatterns(String[] strings, String[] patterns) {

        Map<String, String> map = new HashMap<>();
        for(int i = 0; i <strings.length;i++){
            String string =strings[i];
            String pattern = patterns[i];
            if((map.containsKey(string)  && !pattern.equals(map.get(string))))
            {
                return false;
            }

            if((map.containsKey(pattern)  && !string.equals(map.get(pattern)))){
                return false;
            }

            map.put(string,pattern);
            map.put(pattern,string);

        }
        return true;

    }

}
