class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;

        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            char startChar = s.charAt(left);
            char endChar = s.charAt(right);

            if(!Character.isLetterOrDigit(startChar)){
                left++;
            }
            else if (!Character.isLetterOrDigit(endChar)){
                right--;
            }
            else{
                if(Character.toLowerCase(startChar) != Character.toLowerCase(endChar)){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}