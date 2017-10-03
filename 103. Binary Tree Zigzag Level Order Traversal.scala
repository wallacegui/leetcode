/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/
class TreeNode(var _value: Int) {
   var value: Int = _value
   var left: TreeNode = null
   var right: TreeNode = null
   override def toString = value+ ":"+ "{"+  left +","+right+"}"
}

def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    if(root == null) return List();
    var queue = scala.collection.mutable.Queue[(TreeNode,Int)]();
    val elem = (root,1);
    queue += elem;
    var result = scala.collection.mutable.ArrayBuffer[List[Int]]();
    var cureentLevel:List[Int] = List();
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
            if(current._2%2==1){
                cureentLevel ++= List(current._1.value);
            }else{
                cureentLevel = current._1.value :: cureentLevel;
            }
        }else{
            result += cureentLevel.toList;
            cureentLevel = List(current._1.value);
            preLevel = current._2;
        }
    }
    if(!cureentLevel.isEmpty) result += cureentLevel; 
    return result.toList
}
