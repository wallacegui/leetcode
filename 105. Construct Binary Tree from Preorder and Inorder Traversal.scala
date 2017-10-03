/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.


    2
   / \
  1   3
*/

class TreeNode(var _value: Int) {
   var value: Int = _value
   var left: TreeNode = null
   var right: TreeNode = null
   override def toString = value+ ":"+ "{"+  left +","+right+"}"
}


def buildTreeImp(preorder: Array[Int], s1:Int,e1:Int,inorder: Array[Int],s2:Int,e2:Int):TreeNode = {
    if(s1>e1) return null;
    var tree = new TreeNode(preorder(s1));
    val s3 = inorder.indexOf(preorder(s1));
    tree.left = buildTreeImp(preorder,s1+1,s1+s3-s2,inorder,s2,s3-1);
    tree.right = buildTreeImp(preorder,s1+s3-s2+1,e1,inorder,s3+1,e2);
    return tree;
}

def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    if(preorder==null || inorder==null || preorder.length!=inorder.length) return null; 
    else return buildTreeImp(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
}


buildTree(Array(1,2,3),Array(2,1,3))
