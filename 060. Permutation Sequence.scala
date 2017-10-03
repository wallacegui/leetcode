/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

def getPermutation(n: Int, k: Int): String = {
    var mark = (1 to n).toArray;
    for(i<-2 to k){
        next(mark)
    }
    mark.mkString("")        
}


def swap(mark:Array[Int],i:Int,j:Int):Unit = {
    val temp = mark(i);
    mark(i) = mark(j);
    mark(j) = temp;
}

def reverse(mark:Array[Int],i:Int):Unit = {
    var start = i;
    var end = mark.length-1;
    while(start<end) {
        swap(mark,start,end);
        start += 1;
        end -= 1;
    }
}

def findMin(mark:Array[Int],i:Int):Int ={
    for(j<-i to mark.length-2){
        if(mark(j+1)<mark(i)) return j;
    }
    return mark.length-1;
}

def next(mark:Array[Int]):Unit = {
    var n = mark.length-1;
    while(n>0 && mark(n-1)>mark(n)) n-=1;
    var min = findMin(mark,n-1);
    swap(mark,min,n-1);
    reverse(mark,n);
}





val mark = Array(2,4,3,1)
next(mark);
println(mark.mkString(" "))
