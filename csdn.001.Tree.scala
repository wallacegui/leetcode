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



//最近公共祖先
def findPath(root:TreeNode,node:TreeNode):Array[TreeNode] = {
    val stack = new scala.collection.mutable.Stack[TreeNode]();
    stack.push(root);
    var pre:TreeNode =null;
    while(!stack.isEmpty){
        println(stack.toList.reverse);
        val top = stack.top;
        val right=top.right;
        val left = top.left;
        if((left==null && right ==null) ||
           (right!=null && pre==right) ||
           (right==null && pre==left)){
            if(top==node) return stack.toArray.reverse;
            stack.pop();
            pre = top;
            println(top);
        }else{
            if(left!=null&&pre!=left) stack.push(left);
            if((left==null || (left!=null &&pre==left))&&(right!=null)){
                stack.push(right);
            }
        }
    }
    return Array()
}

def findCommonParent(root:TreeNode,node1:TreeNode,node2:TreeNode):TreeNode = {
    if(root==null || node1==null || node2==null) return null;
    val fstPath = findPath(root,node1);
    val sndPath = findPath(root,node2);
    if(fstPath.length<=0 && sndPath.length<=0) return null;
    var result: TreeNode= null;
    var i = 0;
    while(i<math.min(fstPath.length,sndPath.length)){
      if(fstPath(i)!=sndPath(i)) return result;
      result = fstPath(i);
      i+=1;
    }
    return result;
}
