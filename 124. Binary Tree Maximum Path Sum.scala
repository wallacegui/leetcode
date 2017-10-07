/*
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

*/



class TreeNode(var _value: Int) {
   var value: Int = _value
   var left: TreeNode = null
   var right: TreeNode = null
   override def toString = value+ ":"+ "{"+  left +","+right+"}"
}


       1
      / \
    -6   3
    / \
   4   6

val root = new TreeNode(1);
root.right = new TreeNode(3);
root.left = new TreeNode(-6);
root.left.left = new TreeNode(4);
root.left.right = new TreeNode(6)
//1
object Solution {
    
    var max = Int.MinValue;

    def maxPathSum(root: TreeNode): Int = {
        if(root==null) return 0;
        maxPathSumImp(root);
        max;
    }

    def maxPathSumImp(root: TreeNode): Int = {
        if(root==null) return 0;
        val left = math.max(0,maxPathSumImp(root.left));
        val right = math.max(0,maxPathSumImp(root.right));
        max = math.max(left+right+root.value,max);
        return math.max(left,right)+root.value;
    }    
}

Solution.maxPathSum(root)
Solution.maxPathSum(root.left)


object Solution {
    
    def maxPathSum(root: TreeNode): Int = {
        if(root==null) return 0;
        val mark = new Array[Int](1);
        mark(0)=Int.MinValue;
        maxPathSumImp(root,mark);
        mark(0);
    }

    def maxPathSumImp(root: TreeNode,mark:Array[Int]): Int = {
        if(root==null) return 0;
        val left = math.max(0,maxPathSumImp(root.left,mark));
        val right = math.max(0,maxPathSumImp(root.right,mark));
        mark(0)  = math.max(left+right+root.value,max);
        return math.max(left,right)+root.value;
    }    
}


Solution.maxPathSum(root)
Solution.maxPathSum(root.left)


    def maxPathSum(root:TreeNode):Int= {
        if(root==null) return 0;
        val max = Int.MinValue ;
        var left = 0;
        var righ = 0;
        val stack = new scala.collection.mutable.Stack[TreeNode]();
        stack.push(root);
        var preNode = null;
        while(!stack.isEmpty){
            val current = stack.top;
            if((current.left==null && current.right==null)||
                (preNode!=null && (preNode==root.left||preNode==root.right))){
                stack.pop;
                preNode = current;

            }else{
                if(root.left!=null) stack.push(root.left);
            }
       
        }
    }
