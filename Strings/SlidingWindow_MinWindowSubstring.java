//LC_76 
class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[256];
        int r=0, l=0, count=0, minLen=Integer.MAX_VALUE, startIdx=0;
        for(char ch : t.toCharArray()){
           freq[(int)ch]++;
        }
        while(r<s.length()){
            int ch = s.charAt(r);
            if( freq[ch] > 0) count++;
            freq[ch]--;

            while(count == t.length()){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    startIdx = l;
                }
                
                int lch = s.charAt(l);
                freq[lch]++;
                if(freq[lch] > 0) count--;
                l++;
            }
            r = r+1;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
