class Solution {
    public int integerBreak(int n) {

        switch(n){
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 4;
            default:
                break;
        }
        int sol = 1;
        while(n>4){
            sol*= 3;
            n -= 3;
        }
        sol *= n;
        return sol;
    }
}