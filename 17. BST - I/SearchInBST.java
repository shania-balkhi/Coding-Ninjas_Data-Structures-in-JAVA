public class Solution {

    static boolean searchLeft, searchRight;
	public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		if (root == null){
            return false;
        }
        
        if (root.data == k){
            return true;
        }
        
        
        if (k < root.data){
        	searchLeft = searchInBST(root.left, k);
            return searchLeft;
        }
        
        if (k > root.data){
        	searchRight = searchInBST(root.right, k);
        	return searchRight;
        }
        
        return false;
	}
}
