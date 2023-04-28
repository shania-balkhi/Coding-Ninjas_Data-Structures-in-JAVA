/*
Sum of all nodes

Given a generic tree, count and return the sum of all nodes present in the given tree.
Input format :
Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Sum of all nodes
Sample Input :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output :
190
*/

// ****************************************************************************************

public class Solution {
	public static int sumOfAllNode(TreeNode<Integer> root){
		int SumOfNode = root.data;
        for(int i = 0; i < root.children.size(); ++i){
            SumOfNode += sumOfAllNode(root.children.get(i));
        }
        return SumOfNode;
	}
}
