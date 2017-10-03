/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

// 同一行/列： (i,j) (m,n)  i==m || j==n
// 对角线： n-j == m-i || n-j == i-m

def line(n:Int,i:Int):String ={
    var result ="";
    for(j<- 0 to n-1){
        result += (if(i==j) 'Q' else '.');
    }
    return result;
}

def mkString(mark:Array[Int]): List[String] ={
    var n = mark.length;
    var result: List[String] = List();
    for(i<- mark){
        result = result ++ List(line(n,i));
    }
    return result;
}


def attack(mark:Array[Int],i:Int):Boolean = {
    for(j <- 0 to i-1){
        if(mark(j)==mark(i) || mark(i)-mark(j)==i-j || mark(i)-mark(j)== j-i) return true;
    }
    return false;
}

def solveNQueensImp(mark:Array[Int],i:Int,
    result:scala.collection.mutable.ArrayBuffer[List[String]]):Unit = {
        var n = mark.length;
        if(i>= n) return;
        for(j <-0 to n-1){
            mark(i) = j;
            if(!attack(mark,i)){
                if(i==n-1){
                    result += mkString(mark);
                }else{
                    solveNQueensImp(mark,i+1,result);   
                }
            }
        }
}


def solveNQueens(n: Int): List[List[String]] = {
    var result = new scala.collection.mutable.ArrayBuffer[List[String]]();
    var mark = new Array[Int](n);
    solveNQueensImp(mark,0,result);
    return result.toList;
}

solveNQueens(4)
