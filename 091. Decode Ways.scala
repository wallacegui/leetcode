/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/
//1.非法判断
//2.24，25的条件

def numDecodings(s: String): Int = {
    if(s==null || s.length==0 || s(0)=='0') return 0;
    val n = s.length;
    var mark = new Array[Int](n+1);
    mark(n)=1
    for(i<- (0 to n-1).reverse){
        if(s(i)!='0') mark(i) += mark(i+1);
        if(i+2<=n && s(i)*10+s(i+1)<=554 && s(i)*10+s(i+1)>=538 ) mark(i)+=mark(i+2);
    }
    return mark(0);
}

