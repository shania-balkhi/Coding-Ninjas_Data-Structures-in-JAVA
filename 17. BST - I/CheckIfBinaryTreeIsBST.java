//1st approach (simplest) 
//O(n)
class Solution{
	public static boolean isBST(BinaryTreeNode<Integer> root){
    	boolean ans = isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return ans;
	}

    private static boolean isBSTHelper(BinaryTreeNode<Integer> root, int min, int max){
        if (root == null){
            return true;
        }
        
        if (root.data <= min || root.data > max){
            return false;
        }
        
        boolean isLeftBST = isBSTHelper(root.left, min, root.data - 1);
        boolean isRightBST = isBSTHelper(root.right, root.data, max);
        
        return isLeftBST && isRightBST;
        
    }
    
}

/************************************************************************************************************************************************************/
/************************************************************************************************************************************************************/

//2nd approach 
//O(n)
class isBSTReturn{
    int min;
    int max;
    boolean isBST;
    
    isBSTReturn(int min, int max, boolean isBST){
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }
    
}


public class Solution {

	private static isBSTReturn isBSTHelper(BinaryTreeNode<Integer> root) {

		if (root == null){
            isBSTReturn ans = new isBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
                return ans;
        }
        
        isBSTReturn LeftOutput = isBSTHelper(root.left);
        isBSTReturn RightOutput = isBSTHelper(root.right);
        
        int min = Math.min(root.data, Math.min(LeftOutput.min, LeftOutput.min));
        int max = Math.max(root.data, Math.max(RightOutput.max, RightOutput.max));
        boolean isBST = true;
        
        if (root.data <= LeftOutput.max){
            isBST = false;
        }
        
        if (root.data > RightOutput.min){
            isBST = false;
        }
        
        if (!LeftOutput.isBST){
            isBST = false;
        }
        
        if (!RightOutput.isBST){
            isBST = false;
        }
        
        isBSTReturn ans = new isBSTReturn(min,max,isBST);
        return ans;
        
	}
    
    	public static boolean isBST(BinaryTreeNode<Integer> root) {
        	isBSTReturn ans = isBSTHelper(root);
            return ans.isBST;
        }

}



/************************************************************************************************************************************************************/
/************************************************************************************************************************************************************/


//3rd approach (most time complex)
//O(n^2)
public class Solution {

	public static boolean isBST(BinaryTreeNode<Integer> root) {
		
        if (root == null){
            return true;
        }
        
        if (root.data <= maximum(root.left)){
            return false;
        }
        
        if (root.data > minimum(root.right)){
            return false;
        }
        
        boolean isBSTLeft = isBST(root.left);
        boolean isBSTRight = isBST(root.right);
        
        return isBSTLeft & isBSTRight;
        
	}
    
    private static int maximum (BinaryTreeNode<Integer> root){
        if (root == null){
            return Integer.MIN_VALUE;
        }
        
        int maxLeft = maximum(root.left);
        int maxRight = maximum(root.right);
        
        return Math.max(root.data, Math.max(maxLeft, maxRight));
        
    }
    
    private static int minimum (BinaryTreeNode<Integer> root){
        if (root == null){
            return Integer.MAX_VALUE;
        }
        
        int minLeft = minimum(root.left);
        int minRight = minimum(root.right);
        
        return Math.min(root.data, Math.min(minLeft, minRight));
        
    }
    

}





