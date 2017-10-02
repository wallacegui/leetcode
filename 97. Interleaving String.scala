/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/


//回溯
0 4，0 5，0 10；

def isInterleaveImp(s1: String, m1:Int, s2: String, m2:Int, s3: String):Boolean = {
    if(m1+m2>=s3.length) return true;
    val c3 = s3(m1+m2);
    if(m1<s1.length && s1(m1)==c3 && isInterleaveImp(s1,m1+1,s2,m2,s3)) return true;
    if(m2<s2.length && s2(m2)==c3 && isInterleaveImp(s1,m1,s2,m2+1,s3)) return true;
    return false;
}

def isInterleave(s1: String, s2: String, s3: String): Boolean = {
    if(s1==null || s2==null ||s3==null || s3.length!=s1.length+s2.length) return false;
    isInterleaveImp(s1,0,s2,0,s3);
}

isInterleave("aabcc","dbbca","aadbbcbcac")
isInterleave("aabcc","dbbca","aadbbbaccc")


//动归
