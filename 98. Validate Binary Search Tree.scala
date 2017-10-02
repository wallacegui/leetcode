/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
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


def isValidBSTImp(root: TreeNode): (Boolean,Int,Int) = {
    (root.left,root.right) match {
        case (null,null) => return (true,root.value,root.value);
        case (null,_)    =>  {
            val right = isValidBSTImp(root.right);
            if(right._1 && right._2 > root.value){
                return (true,root.value,right._3);
            }else{
                return (false,right._2,right._3);
            }
        }
        case (_,null)   => {
           val left = isValidBSTImp(root.left);
            if(left._1 && left._3 < root.value){
                return (true,left._2,root.value);
            }else{
                return (false,left._2,left._3);
            } 
        }
        case (_,_)     => {
            val right = isValidBSTImp(root.right);
            val left = isValidBSTImp(root.left);
            if(left._1 && right._1 && left._3 < root.value && right._2 > root.value) return (true,left._2,right._3);
            else return (false,left._2,right._3);
        } 
    }
}

val root = new TreeNode(2)
val left = new TreeNode(1)
val right = new TreeNode(3)
root.left = left;
root.right = right;
isValidBSTImp(root);

val root = new TreeNode(2)
val left = new TreeNode(3)
val right = new TreeNode(3)
root.left = left;
root.right = right;
isValidBSTImp(root);


def isValidBST(root: TreeNode): Boolean = {
    if(root==null) return false;
    else isValidBSTImp(root)._1;   
}
