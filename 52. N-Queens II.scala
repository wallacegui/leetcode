/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/

// 同一行/列： (i,j) (m,n)  i==m || j==n
// 对角线： n-j == m-i || n-j == i-m


def attack(mark:Array[Int],i:Int):Boolean = {
    for(j <- 0 to i-1){
        if(mark(j)==mark(i) || mark(i)-mark(j)==i-j || mark(i)-mark(j)== j-i) return true;
    }
    return false;
}

def solveNQueensImp(mark:Array[Int],i:Int):Int = {
        var n = mark.length;
        var result = 0;
        if(i>= n) return 0;
        for(j <-0 to n-1){
            mark(i) = j;
            if(!attack(mark,i)){
                if(i==n-1){
                    result += 1;
                }else{
                    result +=solveNQueensImp(mark,i+1);   
                }
            }
        }
        return result;
}


def solveNQueens(n: Int): Int = {
    var mark = new Array[Int](n);
    solveNQueensImp(mark,0);
}

solveNQueens(4)
