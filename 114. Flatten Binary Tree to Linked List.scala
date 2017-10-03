/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.


*/

class TreeNode(var _value: Int) {
   var value: Int = _value
   var left: TreeNode = null
   var right: TreeNode = null
   override def toString = value+ ":"+ "{"+  left +","+right+"}"
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
// TreeNode = 5:{null,4:{null,11:{null,7:{null,2:{null,8:{null,13:{null,4:{null,5:{null,1:{null,null}}}}}}}}}}
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


def flattenImp(root: TreeNode): TreeNode = {
    if(root==null) return null;    
    var left = root.left;
    var leftFlattened = flattenImp(left);

    var right = root.right;
    var rightFlatened = flattenImp(right);

    if(left!=null){
        root.left=null;
        root.right = left;
        leftFlattened.right=right;
    }

    if(rightFlatened!=null) return rightFlatened;
    if(leftFlattened!=null) return leftFlattened;
    return root; 
}


def flatten(root: TreeNode): Unit = {
    flattenImp(root);
}

//


