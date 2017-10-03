/*
Examples of nth sequence
At the beginning, I got confusions about what is the nth sequence. Well, my solution is accepted now, so I'm going to give some examples of nth sequence here. The following are sequence from n=1 to n=10:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221 
 6.     312211
 7.     13112221
 8.     1113213211
 9.     31131211131221
 10.   13211311123113112211
*/


object Solution {
    def countAndSay(n: Int): String = {
     if(n==1) return "1";
     var preStr = countAndSay(n-1);
     var result = "";
     var count = 1;
     for(i <- 1 to preStr.length-1){
        if(preStr(i) == preStr(i-1)){
            count += 1;
        }else{
            result = result + count + preStr(i-1);
            count = 1;
        }
     }
     return result + count + preStr.last;
    }
}
