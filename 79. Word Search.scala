/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/



def existImp(board:Array[Array[Char]],i:Int,j:Int,mark:Array[Array[Int]],word:String,k:Int):Boolean = {
    var m = board.length;
    var n = board(0).length;
    if(k==word.length) return true ;
    if(i<0 || i >=m || j<0 || j>=n || board(i)(j)!=word(k) || mark(i)(j)==1){
        return false;
    }else{
        mark(i)(j) = 1;
        var move=
            existImp(board,i-1,j,mark,word,k+1) || //up
            existImp(board,i,j+1,mark,word,k+1) || //right
            existImp(board,i,j-1,mark,word,k+1) || //left
            existImp(board,i+1,j,mark,word,k+1);   //down
        if(move) {
            return true;
        } else{
            mark(i)(j)=0;
            return false;
        }
    }
}

var board =
  Array(Array('A','B','C','E'),
        Array('S','F','C','S'),
        Array('A','D','E','E'))

var word = "ABFD";
var m = board.length;
var n = board(0).length;
var mark = Array.ofDim[Int](m,n);
existImp(board,0,0,mark,word,0);

var word = "ABFE";
var m = board.length;
var n = board(0).length;
var mark = Array.ofDim[Int](m,n);
existImp(board,0,0,mark,word,0);

def exist(board: Array[Array[Char]], word: String): Boolean = {
    if(board==null || board.length==0 || board(0).length==0 || word==null || word.length==0) return false;
    var m = board.length;
    var n = board(0).length;
    var mark = Array.ofDim[Int](m,n);
    for(i<- 0 to m-1){
        for(j<- 0 to n-1){
            if(board(i)(j)==word(0) && existImp(board,i,j,mark,word,0)) return true; 
        }
    }
    return false;
}

var board =
  Array(Array('A','B','C','E'),
        Array('S','F','C','S'),
        Array('A','D','E','E'))

var word = "ABFD";
exist(board,word);
