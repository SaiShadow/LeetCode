/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
class Solution {

    public List<Integer> find(List<Integer> list, TreeNode root, int index) {
        if (list.size() > index) {
            if (list.get(index) < root.val) {
                list.set(index, root.val);
            }
        } else {
            list.add(root.val);
        }

        TreeNode left = root.left;
        if (left != null) {
            find(list, left, index + 1);
        }

        TreeNode right = root.right;
        if (right != null) {
            find(list, right, index + 1);
        }


        return list;
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        int i = 0;

        return find(list, root, i);
    }

    // public class TreeNode {
    //     int val;
    //     TreeNode left;
    //     TreeNode right;

    //     TreeNode() {
    //     }

    //     TreeNode(int val) {
    //         this.val = val;
    //     }

    //     TreeNode(int val, TreeNode left, TreeNode right) {
    //         this.val = val;
    //         this.left = left;
    //         this.right = right;
    //     }

    // }


}