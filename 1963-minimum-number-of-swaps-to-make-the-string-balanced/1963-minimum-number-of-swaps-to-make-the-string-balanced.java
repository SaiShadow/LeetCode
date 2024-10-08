class Solution {
    public int minSwaps(String s) {
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '['){
                count++;
            }else if(count>0){
                count--;
            }
        }
    return (++count)/2;}
}