/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.


*/

object Solution {
    def lengthOfLastWord(s: String): Int = {
        if(s==null || s.length==0) return 0;
        var n = s.length-1;
        var end =0;
        var word = false;
        while(n>=0){
            if(s(n)==' '){
                if(word) return (end-n);
            }else{
                if(!word) {
                    end = n;
                    word = true;
                }
            }
            n -= 1;
        }
        end+(if(word) 1 else 0);
    }
}
