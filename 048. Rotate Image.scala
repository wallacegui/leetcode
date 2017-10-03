/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
*/


    def col2row(matrix: Array[Array[Int]]): Unit = {   
        val n = matrix.length;
        for(i<- 0 to n-1){
            for(j<-i+1 to n-1){
                val temp = matrix(i)(j)
                matrix(i)(j) = matrix(j)(i);
                matrix(j)(i) = temp
            }
        }
        println(matrix.map(_.mkString(",")).mkString("\n"))
        println("======")
    }

    def left2right(matrix: Array[Array[Int]]): Unit = {
        val n = matrix.length;
        for(i<- 0 to n/2-1){
            for(j<- 0 to n-1){
                val temp = matrix(j)(i);
                matrix(j)(i) = matrix(j)(n-1-i);
                matrix(j)(n-1-i) = temp;
            }
        }
        println(matrix.map(_.mkString(",")).mkString("\n"))
    }
    def rotate(matrix: Array[Array[Int]]): Unit = {
          col2row(matrix);
          left2right(matrix); 
    }

    val input= Array(Array(1,2,3),Array(4,5,6),Array(7,8,9))

    rotate(input)


    val input = Array(Array(5,1,9,11),Array(2,4,8,10),Array(13,3,6,7),Array(15,14,12,16))
    rotate(input)
