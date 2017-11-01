
class TreeNode(var _value: Int) {
   var value: Int = _value
   var left: TreeNode = null
   var right: TreeNode = null
   override def toString = value ; //+ ":"+ "{"+  left +","+right+"}"
}

def toRight(node:TreeNode):String = {
    if(node == null) return "null" ;
    return (node +" -> " + toRight(node.right))
}

def toLeft(node:TreeNode):String = {
    if(node == null) return "null" ;
    return (toLeft(node.left) +" <- " + node );
}

val root = new TreeNode(2)
val left = new TreeNode(1)
val right = new TreeNode(3)
root.left = left;
root.right = right;

def replay(root:TreeNode):(TreeNode,TreeNode) = {
    println(root);
    var head  = root;
    var end  = root;
    if(root==null) return (null,null);
    val leftList = replay(root.left);
    if(leftList._2!=null) {
        root.left = leftList._2;
        leftList._2.right = root;
        head = leftList._1;
    }
    
    val rightList = replay(root.right);
    if(rightList._1!=null){
        root.right = rightList._1;
        rightList._1.left = root;
        end = rightList._2;
    }
    return (head,end);
}

val x = replay(root);

toLeft(x._2)
toRight(x._1)
