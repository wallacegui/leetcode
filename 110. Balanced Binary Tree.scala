/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


*/

    1
   / \
  2   3

class TreeNode(var _value: Int) {
   var value: Int = _value
   var left: TreeNode = null
   var right: TreeNode = null
   override def toString = value+ ":"+ "{"+  left +","+right+"}"
}

def isBalanced(root: TreeNode): Boolean = {
    isBalancedImp(root)._1
}

def isBalancedImp(root:TreeNode): (Boolean,Int) = {
    if(root==null) return (true,0);
    val left = isBalancedImp(root.left);
    val right = isBalancedImp(root.right);
    if(left._1 && right._1 && math.abs(left._2 - right._2)<=1){
        return (true,math.max(left._2,right._2)+1);
    }else{
        return (false,math.max(left._2,right._2)+1);
    }
}
