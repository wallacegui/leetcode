/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

object Solution {
    def generateParenthesis(n: Int): List[String] = {
        val mark = new Array[Char](n*2);
        return generateParenthesis(n,n,0,mark);
    }
    
    def generateParenthesis(left:Int,right:Int,i:Int,mark:Array[Char]):List[String] = {
        var result:List[String] = List();
        if(left==0 && right==0){
            return List(mark.mkString(""));
        }else{
            if(left <=right && left != 0 ){
                mark(i) = '(' ;
                result = result ++ generateParenthesis(left-1,right,i+1,mark);
            }
            if(left < right && right !=0 ){
                mark(i) = ')';
                result = result ++  generateParenthesis(left,right-1,i+1,mark);
            }
        }
        return result;
    }
}
