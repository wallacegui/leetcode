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

def numTrees(n: Int): Int = {
    val mark = new Array[Int](n);
    mark(0)=1;
    for(i<- 1 to n-1){
        for(k<- 0 to i){
            val left = if(k>=1) mark(k-1) else 1;
            val right = if(i-k-1>=1) mark(i-k-1) else 1;
            mark(i) += left*right;
        }
    }
    mark(n-1)
}
numTrees(3)
