/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.


*/


def hasPathSum(root: TreeNode, sum: Int): Boolean = {
    if(root==null) return false;
    if(root.left==null && root.right==null && sum-root.value==0) return true; 
    if(hasPathSum(root.left,sum-root.value) || hasPathSum(root.right,sum-root.value)) return true;
    return false;
}
