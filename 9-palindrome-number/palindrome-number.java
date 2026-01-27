class Solution {
    public boolean isPalindrome(int x) {
        int original = x;
        int revNum = 0;
        while(x > 0){
            int lastdigit = x % 10;
            revNum = (revNum * 10) + lastdigit;
            x = x / 10;
        }
        return original == revNum;
    }
}