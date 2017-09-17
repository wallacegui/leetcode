/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

def multiply(num1: String, num2: String): String = {
    var n1 = num1.length;
    var n2 = num2.length;
    var resuslt = new Array[Int](n1+n2);
    var i = n1-1;
    while(i>=0){
        var j = n2-1;
        while(j>=0){
            var k = n1-1-i+n2-1-j;
            var value = (num1(i)-'0')*(num2(j)-'0');
            resuslt(k) += value % 10;
            resuslt(k+1) += resuslt(k)/10;
            resuslt(k) = resuslt(k) % 10;
            resuslt(k+1) += value/10; 
            j -= 1;
        }
        i -= 1;
    }
    return(remove0(resuslt.reverse.mkString("")))
}

def remove0(res:String):String = {
    var i = 0;
    while(i<res.length && res(i)=='0' ) i+=1;
    if(i==res.length) "0"
    else res.substring(i);
}

multiply("99","99")

99*99

multiply("99","999")

99*999
