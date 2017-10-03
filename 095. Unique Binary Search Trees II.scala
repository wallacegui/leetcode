/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/

class TreeNode(var _value: Int) {
   var value: Int = _value
   var left: TreeNode = null
   var right: TreeNode = null
   override def toString = value+ ":"+ "{"+  left +","+right+"}"
}

def generateTreesImp(mark:Array[Int],begin:Int,end:Int):List[TreeNode] = {
    if(begin>end) return List();
    if(begin==end){
        return List(new TreeNode(mark(begin)));
    }else{
        var result = new scala.collection.mutable.ArrayBuffer[TreeNode]();
        for(i<- begin to end){

            var left = generateTreesImp(mark,begin,i-1);
            var right = generateTreesImp(mark,i+1,end);
            if(left.length==0) left ++= List(null);
            if(right.length==0) right ++= List(null);
            for(leftSon <- left){
                for(rightSon <- right){
                    val root = new TreeNode(mark(i)); //why can not init before for?
                    root.left = leftSon;
                    root.right = rightSon;
                    result += root;
                }
            }
        }
        return result.toList;
    }
}


def generateTrees(n: Int): List[TreeNode] = {
    if(n<=0) return List()
    var mark = new Array[Int](n);
    for(i<- 0 to n-1) mark(i) = i+1;
    generateTreesImp(mark,0,n-1);
}

