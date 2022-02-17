public class Solution {

    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n) {
        BinaryTreeNode<Integer> rootNode = SortedArrayToBSTHelper(arr, 0, n-1, n);
        return rootNode;
    }

    private static BinaryTreeNode<Integer> SortedArrayToBSTHelper(int[] arr, int si, int ei, int n){
        if (n == 0){
            return null;
        }

        //findind rootData in arr[], then creating rootNode
        int mid = si + (ei - si)/2;
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(arr[mid]);

        rootNode.left = SortedArrayToBSTHelper( arr, si, mid - 1, (((mid - 1) - si) + 1) );
        rootNode.right = SortedArrayToBSTHelper( arr, mid + 1, ei, ((ei - (mid + 1)) + 1) );

        return rootNode;


    }

}
