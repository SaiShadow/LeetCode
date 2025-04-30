class Solution {
    public int findNumbers(int[] nums) {
        int numOfEven = 0;

        for(int num : nums){

            if(hasEvenDigits(num)){
                numOfEven++;
            }

        }
        return numOfEven;
    }

    private boolean hasEvenDigits(int num){
        int numOfDigits = 0;
        while (num!= 0) {
            numOfDigits++;
            num /=10;
        }
        return numOfDigits % 2 == 0;
    }
}