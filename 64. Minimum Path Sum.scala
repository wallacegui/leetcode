/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Seen this question in a real interview before?   Yes  
*/

def minPathSum(mark: Array[Array[Int]]): Int = {
    if(mark==null || mark.length==0 || mark(0).length==0) return 0;
    var m = mark.length;
    var n = mark(0).length;
    

    for(i<- 1 to m-1){
        mark(i)(0) += mark(i-1)(0)
    }
        
    for(j<- 1 to n-1){
        mark(0)(j) += mark(0)(j-1)
    }
    for(i<-1 to m-1){
        for(j<-1 to n-1){
            mark(i)(j) += math.min(mark(i)(j-1),mark(i-1)(j));
        } 
    }
    mark(m-1)(n-1);
}
