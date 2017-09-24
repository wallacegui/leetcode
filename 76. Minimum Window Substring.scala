/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

object Solution {
    def minWindow(s: String, t: String): String = {
        if(s==null || t==null || s.length==0 || t.length =="") return "";
        var map = new Array[Int](128);
        for(c <- t) map(c) += 1;
        var begin=0;var end = 0;var minBegin =0;var minEnd = Int.MaxValue;var mark = t.length;
        for(end <- 0 to s.length-1){
            map(s(end)) -= 1;
            if(map(s(end))>=0) mark -= 1;
            while(mark==0){
                map(s(begin)) += 1;
                if(map(s(begin))>0) mark += 1;
                if(end-begin<minEnd-minBegin){
                    minBegin = begin;
                    minEnd = end;
                }
                begin += 1;
            }
       }
       if(minEnd==Int.MaxValue) "" else s.substring(minBegin,minEnd+1);
    }
}

scala> minWindow("ABNCADB","BC")
res40: String = BNC

scala> minWindow("ABNCADB","AD")
res41: String = AD

scala> minWindow("ABNCADB","B")
res42: String = B

scala> minWindow("ABNCADB","D")
res43: String = D

scala> minWindow("ABNCADB","AB")
res44: String = AB

scala> minWindow("ABNCADC","AB")
res45: String = AB

scala> minWindow("ABNCADC","AC")
