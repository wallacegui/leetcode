/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
*/

    2
   / \
  1   3


class TreeNode(var _value: Int) {
   var value: Int = _value
   var left: TreeNode = null
   var right: TreeNode = null
   override def toString = value+ ":"+ "{"+  left +","+right+"}"
}

def isSymmetricImp(left: TreeNode,right:TreeNode): Boolean = {
    (left,right) match {
        case (null,null) => return true;
        case (null,_) => return false;
        case (_,null) => return false
        case (_,_)    => {
            if(left.value==right.value && isSymmetricImp(left.left,right.right)
                && isSymmetricImp(left.right,right.left))
                return true;
            else return false;
        } 
    }
}

def isSymmetric(root: TreeNode): Boolean = {
    if(root==null ) return true;
    return isSymmetricImp(root.left,root.right);
}
