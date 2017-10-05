/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?


*/

[    [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

object Solution {
    def generate(numRows: Int): List[Int] = {
        if(numRows<0) return List();
        var line = new Array[Int](numRows+1);

        for(i<- 1 to numRows+1){
            line(0) = 1;
            for(j<- (1 to i-2).reverse){
                line(j)=line(j-1)+line(j)
            }
            line(i-1) = 1;
        }
        line.toList;
    }

    generate(1)
    generate(2)
    generate(3)
    generate(4)
}
