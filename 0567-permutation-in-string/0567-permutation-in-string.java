class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for(int i=0;i<s1.length();i++){
            c1[s1.charAt(i)-'a']++;
            c2[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<=s2.length()-s1.length();i++){
            if(Arrays.equals(c1,c2)){
                return true;
            }
            if(i+s1.length()<s2.length()){
                c2[s2.charAt(i)-'a']--;
                c2[s2.charAt(i+s1.length())-'a']++;
            }
        }
        return false;
    }
}