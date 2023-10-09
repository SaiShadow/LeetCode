import java.util.Arrays;
import java.util.List;

class Solution {

    private int searchBack(int[] nums, int i, int target) {

        do {
            i--;
            if(i == -1){
                return 0;
            }
        } while (nums[i] == target);
        return ++i;
    }

    private int searchFront(int[] nums, int j, int target) {
        while (nums[j] == target) {
            j++;
            if(j == nums.length){
                return j-1;
            }
        }
        return --j;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] sol = new int[]{-1, -1};

        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return sol;
        }

        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return sol;
            }
        }
        int i = (nums.length - 1) / 2;
        int j = i + 1;

//        if (nums[0] == target) {
//            if (nums[nums.length - 1] == target) {
//                return new int[]{0, nums.length - 1};
//            }
//            sol[0] = 0;
//            sol[1] = searchFront(nums, )
//        }
        if (nums[i] == target) {
            sol[0] = searchBack(nums, i, target);
            sol[1] = searchFront(nums, j, target);
            return sol;

        } else if (target < nums[i]) {

            do {
                i--;
                if(i < 0){
                    return sol;
                }
            } while ((nums[i] != target));
            sol[1] = i;
            sol[0] = searchBack(nums, i, target);

        } else {
            while ((nums[j] != target)) {
                j++;
                if(j == nums.length){
                    return sol;
                }
            }
            sol[0] = j;
            sol[1] = searchFront(nums, j, target);
        }
        return sol;
    }
}