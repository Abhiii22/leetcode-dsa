class Solution {
    public boolean isPalindrome(int n) {
        int original = n;
        int revNum = 0;
        while(n > 0){
            int lastdigit = n % 10;
            revNum = (revNum * 10) + lastdigit;
            n = n / 10;
        }
        return original == revNum;
    }
}