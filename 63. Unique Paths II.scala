/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

def uniquePathsWithObstacles(mark: Array[Array[Int]]): Int = {
    if(mark==null || mark.length==0 || mark(0).length==0) return 0;
    var m = mark.length;
    var n = mark(0).length;
    
    mark(0)(0) = if(mark(0)(0)==0) 1 else 0;

    for(i<- 1 to m-1){
        if(mark(i)(0)==0 && mark(i-1)(0)==1)
            mark(i)(0) = 1
        else mark(i)(0) = 0;
    }
        
    for(j<- 1 to n-1){
        if(mark(0)(j)==0 && mark(0)(j-1)==1)
            mark(0)(j) =1 
        else mark(0)(j) = 0;
    }
    for(i<-1 to m-1){
        for(j<-1 to n-1){
                if(mark(i)(j)==0){
                    mark(i)(j) = mark(i-1)(j) + mark(i)(j-1);
                }else{
                    mark(i)(j)=0;
                }
            } 
    }
    mark(m-1)(n-1);
}

val mark = Array(Array(0,0,0),Array(0,1,0),Array(0,0,0))
mark.map(line => println(line.mkString("")))
println()
uniquePathsWithObstacles(mark)
