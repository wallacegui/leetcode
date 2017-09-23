/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

object Solution {
        def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
        if(matrix==null || matrix.length==0 || matrix(0)==null) return false;
        var m = matrix.length;
        var n = matrix(0).length;
        var j = n-1;
        var i = 0;
        while(j>=0 && i<=m-1){
            if(matrix(i)(j)==target) return true;
            if(matrix(i)(j)>target){
                j -= 1;
            }else{
                i += 1;
            }
        }
        return false;
    }
}
