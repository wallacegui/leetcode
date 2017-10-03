/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.
*/

object Solution {
    def setZeroes(matrix: Array[Array[Int]]): Unit = {
        var m = matrix.length;
        var n = matrix(0).length;
        var firstCol = 1;
        var firstRow = 1;
        for(i<-0 to m-1){
            if(matrix(i)(0)==0) firstCol = 0;
        }
        for(j<-0 to n-1){
            if(matrix(0)(j)==0) firstRow = 0;
        }
        for(i<-1 to m-1){
            for(j<-1 to n-1){
                if(matrix(i)(j)==0) {
                    matrix(i)(0)=0;
                    if(j>0) matrix(0)(j)=0;
                }
            }
        }
        for(i<-1 to m-1){
            for(j<-1 to n-1){
                if(matrix(i)(0)==0 || matrix(0)(j)==0) matrix(i)(j)=0;
            }
        }
        if(firstRow==0){
            for(j<-0 to n-1){
                matrix(0)(j)=0;
            }
        }
        if(firstCol==0){
            for(i<-0 to m-1){
               matrix(i)(0)=0 ;
            }
        }
    }
}

[[0,0,0,5],
 [4,3,1,4],
 [0,1,1,4],
 [1,2,1,3],
 [0,0,1,1]]

var x = Array(Array(0,0,0,5),Array(4,3,1,4),Array(0,1,1,4),Array(1,2,1,3),Array(0,0,1,1))
