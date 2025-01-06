package Resources.Interviews.Preparation.DSA.Tree.Applications;

import Resources.Interviews.Preparation.DSA.Tree.BinarySearchTree;

public class OneDimensionalRangeSearch {
    BinarySearchTree binarySearchTree = new BinarySearchTree();

    public int rangeCount(String lo, String hi) {
        if (binarySearchTree.contains(hi)) {
            return binarySearchTree.rank(hi) - binarySearchTree.rank(lo) + 1;
        }
        return binarySearchTree.rank(hi) - binarySearchTree.rank(lo);
    }
}
