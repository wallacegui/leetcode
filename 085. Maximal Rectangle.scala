/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
*/

def getMax(line:Array[Char],n:Int):Int ={
    var start = 0 ;
    var end = 0;
    var max = 0;
    for(i<- 0 to line.length-1){
        if(line(i)==n){
            max = math.max((end-start+1)*n,max);
            end +=1;
        }else{
            start = i;
            end = i;
        }
    }  
    return max/'1'; 
}

getMax(Array('1','0','1','1','0'),'1')

def maximalRectangle(matrix: Array[Array[Char]]): Int = {
    if(matrix==null || matrix.length==0 || matrix(0).length==0) return 0;
    var m = matrix.length;
    var n = matrix(0).length;
    var max = 0
    for(i<- 0 to m-2){
        max = math.max(getMax(matrix(i),'1'*1),max);
        for(j<-i+1 to m-1){
            matrix(i) = matrix(i).zip(matrix(j)).map(e => (e._1 + e._2).toChar)
            max = math.max(getMax(matrix(i),'1'*(j-i+1)),max);
        }
    }
    max = math.max(getMax(matrix(m-1),'1'*1),max)

    return max;
}



val matrix = Array(Array('1','0','1','1','0'),
                   Array('1','1','1','1','1'),
                   Array('1','1','1','1','1'),
                   Array('1','0','1','1','0'))
maximalRectangle(matrix)
