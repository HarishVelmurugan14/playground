package OnlinePlatforms.Scaler.DSA.Advanced.Part2;

import Resources.Utilities.PrintHelper;

/**
 * @author Harish Velmurugan
 * @last-modified 19-03-2025
 * @since 19-03-2025
 */
@SuppressWarnings({"unused", "ClassEscapesDefinedScope"})
public class d31_Trees3_BST {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d31_Trees3_BST d31_trees3_bst = new d31_Trees3_BST();

        d31_trees3_bst.sortedArrayToBST(new int[]{1, 3, 5, 6, 7, 8}); // Q2
        d31_trees3_bst.searchInABST(input(), 3); // Q4


    }

    public static TreeNode input() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
//        root.left.left = new TreeNode(65);
        root.left.right = new TreeNode(68);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */

    public int searchInABST(TreeNode A, int B) {
        /* QUESTION :
        Given a Binary Search Tree A. Check whether there exists a node with value B in the BST.
        */

        if (A == null) {
            return 0;
        }

        if (A.val == B) return 1;
        if (A.val > B) {
            return searchInABST(A.left, B);
        } else {
            return searchInABST(A.right, B);
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length - 1);
    }

    public TreeNode convert(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convert(nums, l, mid - 1);
        root.right = convert(nums, mid + 1, r);
        return root;
    }

    public void optimal() {
        // Complexity : Time : [  ]
        // Complexity : Space : [  ]


    }

    private void print(String message) {
        printHelper.print(message, "");
    }


    /* Section : ------------------------------- [ Generic Utilities ] ------------------------------- */

    private void definitions() {
        /**/
    }

    /* Section : ------------------------------- [ Definition Resources ] ---------------------------- */

    private void links() {
        /**/
    }

    /* Section : ------------------------------- [ Specific Utilities ] ------------------------------- */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    /* Section : --------------------------------------- [ End ] ------------------------------------ */


}
