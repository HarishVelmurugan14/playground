package OnlinePlatforms.Scaler.DSA.Advanced.Part2;

import Resources.Utilities.PrintHelper;

import java.util.ArrayList;

/**
 * @author Harish Velmurugan
 * @last-modified 10-03-2025
 * @since 10-03-2025
 */
public class d29_Trees1_StructureAndTraversal {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d29_Trees1_StructureAndTraversal d29_trees1_structureAndTraversal = new d29_Trees1_StructureAndTraversal();

        System.out.println(d29_trees1_structureAndTraversal.getSize(basicInput(), 0));
        ArrayList<Integer> res = d29_trees1_structureAndTraversal.inorderTraversal(basicInput()); // Q1
        d29_trees1_structureAndTraversal.print("", res);
        res = d29_trees1_structureAndTraversal.preOrderTraversal(basicInput()); // Q2
        d29_trees1_structureAndTraversal.print("", res);
        int x = d29_trees1_structureAndTraversal.hasPathSum(hasPathSumInput(), 22, "Pre"); // Q3
        System.out.println(x);
    }

    /* Section : ----------------------------------- [ Inputs ] ------------------------------------ */

    public static TreeNode basicInput() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.right = node2;
        node2.left = node3;
        return root;
    }

    public static TreeNode hasPathSumInput() {
        TreeNode root = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node4_1 = new TreeNode(4);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);

        root.left = node4;
        root.right = node8;
        node4.left = node11;
        node11.left = node7;
        node11.right = node2;
        node8.left = node13;
        node8.right = node4_1;
        node4_1.right = node1;
        return root;
    }

    /* Section : ----------------------------------- [ Problems ] ------------------------------------ */


    public int hasPathSum(TreeNode A, int B, String met) {
        if (A == null) {
            return 0;
        }
        if (A.left == null && A.right == null && B == A.val) {
            return 1;
        }


        int lst = hasPathSum(A.left, B - A.val, "LST");
        int rst = hasPathSum(A.right, B - A.val, "RST");

        return (lst == 1 || rst == 1) ? 1 : 0;
    }

    /* Section : ------------------------------- [ Specific Utilities ] ------------------------------- */

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        return inorderTraversal(A, new ArrayList<>(), "IN");
    }

    public ArrayList<Integer> inorderTraversal(TreeNode A, ArrayList<Integer> res, String met) {
        System.out.println((A != null ? A.val : null) + " - " + met);
        if (A == null) {
            return res;
        }
        res = inorderTraversal(A.left, res, "LST");
        res.add(A.val);
        print("", res);
        res = inorderTraversal(A.right, res, "RST");
        return res;
    }

    public ArrayList<Integer> preOrderTraversal(TreeNode A) {
        return preOrderTraversal(A, new ArrayList<>());
    }

    public ArrayList<Integer> preOrderTraversal(TreeNode A, ArrayList<Integer> res) {
        if (A == null) {
            return res;
        }
        res.add(A.val);
        print("", res);
        res = preOrderTraversal(A.left, res);
        res = preOrderTraversal(A.right, res);
        return res;
    }

    public ArrayList<Integer> postOrderTraversal(TreeNode A) {
        return postOrderTraversal(A, new ArrayList<>());
    }

    public ArrayList<Integer> postOrderTraversal(TreeNode A, ArrayList<Integer> res) {
        if (A == null) {
            return res;
        }
        res = postOrderTraversal(A.left, res);
        res = postOrderTraversal(A.right, res);
        res.add(A.val);
        return res;
    }

    public int getSize(TreeNode A, int i) {
        if (A == null) {
            return i;
        }
        i++;
        i = getSize(A.left, i);
        i = getSize(A.right, i);
        return i;
    }

    private void print(String message, int[] arr) {
        printHelper.print(message, arr);
    }

    private void print(String message, ArrayList<Integer> arr) {
        printHelper.print(message, arr);
    }

    private void definitions() {
        /**/
    }

    /* Section : ------------------------------- [ Generic Utilities ] ------------------------------- */

    private void links() {
        /**/
    }

    /* Section : ------------------------------- [ Definition Resources ] ---------------------------- */

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
