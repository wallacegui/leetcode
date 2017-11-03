class TreeNode(var _value: Int) {
   var value: Int = _value
   var left: TreeNode = null
   var right: TreeNode = null
   override def toString = value + ":"+ "{"+  left +","+right+"}"
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
right.left=new TreeNode(4)
right.right=new TreeNode(5)
right.left.left = new TreeNode(0)
/*  
    2
   /\
  1  3    
    /\
   4  5
  /
 0	 		*/
//先序非递归
def preOrder(root:TreeNode):Unit = {
    val stack = new scala.collection.mutable.Stack[TreeNode]();
    stack.push(root);
    while(!stack.isEmpty){
        var top = stack.pop();
        println(top);
        if(top.right!=null) stack.push(top.right);
        if(top.left!=null) stack.push(top.left);
    }
}

//中序非递归
def inOrder(root:TreeNode):Unit = {
    val stack = new scala.collection.mutable.Stack[TreeNode]();
    stack.push(root);
    while(stack.top.left!=null){
        stack.push(stack.top.left);
    }
    while(!stack.isEmpty){
        var top = stack.pop();
        println(top);
        if(top.right!=null){
            stack.push(top.right);
            while(stack.top.left!=null){
                stack.push(stack.top.left);
            }
        }
    }
}


//后序非递归
def postOrder(root:TreeNode):Unit = {
    val stack = new scala.collection.mutable.Stack[TreeNode]();
    stack.push(root);
    var pre:TreeNode =null;
    while(!stack.isEmpty){
        val top = stack.top;
        val right=top.right;
        val left = top.left;
        if((left==null && right ==null) ||
           (right!=null && pre==right) ||
           (right==null && pre==left)){
            stack.pop();
            println(top);
            pre = top;
        }else{
            if(right!=null) stack.push(right);
            if(left!=null) stack.push(left);
        }
    }
}
