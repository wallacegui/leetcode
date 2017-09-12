/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

O(n) solution:





O(n3) solution:

object Solution {
    def longestValidParentheses(s: String): Int = {
        if(s==null || s.length ==0 ) return 0;
        var n = s.length;
        var mark = Array.ofDim[Boolean](n,n);
        var len = 1;
        var max = 0;
        while(len < n){
            for(i<-0 to n-2){
                var j = i+ len;
                if(j<n && s(i)=='(' && s(j)==')'){
                    if(len==1 || mark(i+1)(j-1)){
                        mark(i)(j)=true;
                        max = math.max(max,len+1);
                    }else{
                        var k = i+1;
                        while(k<j){
                            if(mark(i)(k) && mark(k+1)(j)){
                                mark(i)(j) = true;
                                max = math.max(max,len+1);
                                k=j;
                            }
                            k += 2
                        }

                    }
                }
            }
            len += 2;
        }
        //println(mark.map(_.mkString(" ")).mkString("\n"))
        return max;
    }
}
