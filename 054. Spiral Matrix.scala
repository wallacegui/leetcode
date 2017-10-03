/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].


*/

def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    var m = matrix.length;
    var n = matrix(0).length;
    var min = math.min(m,n);
    var result : List[Int] = List();
    for(i<- 0 to (min-1)/2){
        //1
        for(j<- i to n-1-i)
            result ++= List(matrix(i)(j))
        //2
        for(j<- i+1 to m-1-i)
           result ++= List(matrix(j)(n-1-i))
        //3
        if(m-1-i>i){
            var j = n-i-2;
            while(j>=i) {
                result ++= List(matrix(m-1-i)(j));
                j -= 1;
            };   
        }
        //4
        if(i<n-1-i){
            var j=m-i-2;
            while(j>i) {
                result ++= List(matrix(j)(i)) ;
                j -= 1;
            }
        }
    }
    result
}

val ar= Array(Array(1,2,3),Array(4,5,6),Array(7,8,9));

spiralOrder(ar);


val ar= Array(Array(1,2,3),Array(4,5,6));

spiralOrder(ar);

val ar= Array(Array(1,2,3));

spiralOrder(ar);


val ar= Array(Array(1),Array(4),Array(7));

spiralOrder(ar);


val ar= Array(Array(1,2),Array(4,5),Array(7,8));

spiralOrder(ar);
