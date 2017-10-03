/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

*/

class TreeNode(var _value: Int) {
   var value: Int = _value
   var left: TreeNode = null
   var right: TreeNode = null
   override def toString = value+ ":"+ "{"+  left +","+right+"}"
}

def hasPathSumImp(root: TreeNode, sum: Int,currentPath:scala.collection.mutable.Stack[Int],result:scala.collection.mutable.ArrayBuffer[List[Int]]):Unit = {
    currentPath.push(root.value);
    if(root.left==null && root.right==null && sum==root.value) result += currentPath.toList;
    if(root.left!=null) hasPathSumImp(root.left,sum-root.value,currentPath);
    if(root.right!=null) hasPathSumImp(root.right,sum-root.value,currentPath);
    currentPath.pop();
}

/*
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
*/ 

var root = new TreeNode(5);
root.left = new TreeNode(4);
root.right = new TreeNode(8);
root.left.left = new TreeNode(11);
root.right.left = new TreeNode(13);
root.right.right = new TreeNode(4);
root.left.left.left = new TreeNode(7);
root.left.left.right = new TreeNode(2);
root.right.right.left = new TreeNode(5);
root.right.right.right = new TreeNode(1);


var currentPath = new scala.collection.mutable.Stack[Int]();
var result = new scala.collection.mutable.ArrayBuffer[List[Int]]();
var sum =22;
hasPathSumImp(root,sum,currentPath);

def pathSum(root: TreeNode, sum: Int): List[List[Int]] = {
    if(root==null) return List();
    var currentPath = new scala.collection.mutable.ArrayBuffer[Int]();
    var result = new scala.collection.mutable.ArrayBuffer[List[Int]]();
    hasPathSumImp(root,sum,currentPath,result);
    return result.toList
}


pathSum(root,22);




