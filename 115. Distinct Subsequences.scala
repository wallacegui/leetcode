/*
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.


*/
// 注意dp公式，美团面试题目

    def numDistinct(t: String, s: String): Int = {
      if(s==null || t==null || t.length<s.length) return 0;
      val m = s.length;
      val n = t.length;
      val mark = Array.ofDim[Int](m,n);
      mark(0)(0) = if(s(0)==t(0)) 1 else 0;
      for(j<-1 to n-1) mark(0)(j) = mark(0)(j-1) + (if(s(0)==t(j)) 1 else 0);
      for(i<-1 to m-1)
        for(j<- 1 to n-1){
            if(s(i)==t(j)) mark(i)(j) = mark(i-1)(j-1)+mark(i)(j-1);
            else mark(i)(j) = mark(i)(j-1);
            println(mark.map(_.mkString(",")).mkString("\n")+"\n");
       }
      return mark(m-1)(n-1)
    }

    numDistinct("rabbbit","rabbit")
