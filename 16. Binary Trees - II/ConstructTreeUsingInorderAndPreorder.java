/*
Construct Tree Using Inorder and Preorder

For a given preorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.
Note:
Assume that the Binary Tree contains only unique elements. 
Input Format:
The first line of input contains an integer N denoting the size of the list/array. It can also be said that N is the total number of nodes the binary tree would have.

The second line of input contains N integers, all separated by a single space. It represents the preorder-traversal of the binary tree.

The third line of input contains N integers, all separated by a single space. It represents the inorder-traversal of the binary tree.
Output Format:
The given input tree will be printed in a level order fashion where each level will be printed on a new line. 
Elements on every level will be printed in a linear fashion. A single space will separate them.
Constraints:
1 <= N <= 10^4
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
7
1 2 4 5 3 6 7 
4 2 5 1 6 3 7 
Sample Output 1:
1 
2 3 
4 5 6 7 
Sample Input 2:
6
5 6 2 3 9 10 
2 6 3 9 5 10 
Sample Output 2:
5 
6 10 
2 3 
9 
*/

class Solution {

	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		int preS = 0, preE = preOrder.length - 1;
		int inS = 0, inE = inOrder.length - 1;

        return buildTreeHelper(preOrder, inOrder, preS, preE, inS, inE);
        // return buildTreeHelper(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
	}

    private static BinaryTreeNode<Integer> buildTreeHelper(int[] preOrder, int[] inOrder, int preS, int preE, int inS, int inE){
        //base case
        if (preS > preE /*|| inS > inE*/){
            return null;
        }

        //find root in preOrder[]
        int rootData = preOrder[preS];
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(rootData);

        //find rootIndex in inOrder[]
        int rootIndex = -1;
        for(int i = inS; i <= inE; ++i){
            if (inOrder[i] == rootData){
                rootIndex = i;
                break;
            }

        }

        //if rootDataElement in preOrder[] is not found in inOrder[], it implies the input provided is wrong. hence, terminate
        //program & return null
        if (rootIndex == -1){
            return null;
        }

        int leftPreS = preS + 1;
        int leftInS = inS;
        int leftInE = rootIndex - 1;
        int leftPreE = (leftInE - leftInS) + leftPreS;
        int rightPreS = leftPreE + 1;
        int rightPreE = preE;
        int rightInS = rootIndex + 1;
        int rightInE = inE;
        

        //use recursion & connect with left & right child of rootNode
        rootNode.left = buildTreeHelper(preOrder, inOrder, leftPreS, leftPreE, leftInS, leftInE);
        rootNode.right = buildTreeHelper(preOrder, inOrder, rightPreS, rightPreE, rightInS, rightInE);

        return rootNode;

    }

}
