class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;
        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            freq[ch-'A']++;
            maxFreq = Math.max(maxFreq,freq[ch-'A']);
            while((r-left+1)-maxFreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, r-left+1);
        }
        return maxLen;
    }
}