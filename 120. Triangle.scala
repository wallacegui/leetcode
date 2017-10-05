/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.


*/


[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

    def minimumTotal(triangle: List[List[Int]]): Int = {
        if(triangle==null || triangle.length==0) return 0;
        val n = triangle.length;
        val mark = new Array[Int](n);
        mark(0) = triangle(0)(0)
        for(i<- 1 to n-1){
            for(j<- (0 to i).reverse){
                j match {
                    case 0      => mark(j) += triangle(i)(0);
                    case x if (x==i)  => mark(j) = triangle(i)(j) + mark(j-1);
                    case _      => mark(j) = triangle(i)(j) + math.min(mark(j),mark(j-1));
                }
            }
        }
        mark.min
    }

    minimumTotal(List(List(2),List(3,4),List(6,5,7),List(4,1,8,3)))
