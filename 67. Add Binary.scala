/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

def addBinary(a: String, b: String): String = {
    var result = "";
    var n = math.max(a.length,b.length);
    var newA = if(n==a.length) a else mk(a,n-a.length);
    var newB = if(n==b.length) b else mk(b,n-b.length);
    var yichu =0;
    for(i<- (0 to n-1).reverse){
        var sum = newA(i).toInt-48 + newB(i).toInt-48 + yichu;
        yichu = if(sum>1) 1 else 0;
        sum %= 2;
        result = sum + result;
    }
    if(yichu==0) result else (1+result);
}

addBinary("11","1")

addBinary("11","10")

addBinary("11","11")
