/×
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

×/
def plusOne(digits: Array[Int]): Array[Int] = {
    var yichu = 1;

    for(i <- (0 to digits.length-1).reverse){
        digits(i) += yichu;
        yichu = if(digits(i)>9) 1 else 0;
        digits(i) %= 10;
        if(yichu==0) return digits;
    }
    (1 :: digits.toList).toArray
}

plusOne(Array(1,2,3))
plusOne(Array(9,9,9))
