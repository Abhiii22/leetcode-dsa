class Solution {
    public int maxArea(int[] height) {
        int MW = 0; int lp = 0; int rp = height.length - 1;
        while(lp < rp){
            int w = rp - lp;
            int ht = Math.min(height[lp], height[rp]);
            int CW = w * ht;
            MW = Math.max(MW, CW);

            if(height[lp] < height[rp]){
                lp++;
            }else{
                rp--;
            }
        }
        return MW;
    }
}