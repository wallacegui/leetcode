/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

*/

class TreeNode(var _value: Int) {
   var value: Int = _value
   var left: TreeNode = null
   var right: TreeNode = null
   override def toString = value+ ":"+ "{"+  left +","+right+"}"
}
def levelOrder(root: TreeNode): List[List[Int]] = {
    if(root == null) return List();
    var queue = scala.collection.mutable.Queue[(TreeNode,Int)]();
    val elem = (root,1);
    queue += elem;
    var result = scala.collection.mutable.ArrayBuffer[List[Int]]();
    var cureentLevel = scala.collection.mutable.ArrayBuffer[Int]();
    var preLevel = 1;
    while(!queue.isEmpty){
        val current = queue.dequeue;
        if(current._1.left!=null) {
            val left = (current._1.left,current._2+1) ;
            queue += left;   
        }
        if(current._1.right!=null) {
            val right = (current._1.right,current._2+1);
            queue += right;
        }
        if(current._2==preLevel){
            cureentLevel += current._1.value;
        }else{
            result += cureentLevel.toList;
            cureentLevel.clear;
            cureentLevel += current._1.value;
            preLevel = current._2;
        }
    }
    if(!cureentLevel.isEmpty) result += cureentLevel.toList; 
    return result.toList
}
