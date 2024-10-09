class Solution {
    public int minAddToMakeValid(String s) {
        if(s.isEmpty()){
            return 0;
        }

        int open = 0 , close = 0;
        
        for(char c : s.toCharArray()){
            if(c == '('){
                open++;
            }else {
                if(open == 0){
                    close++;
                }else{
                    open--;
                }
            }
            
        }
        return open + close;
    }
}