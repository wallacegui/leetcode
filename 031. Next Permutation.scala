/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/

def nextPermutation(nums: Array[Int]): Unit = {
    if(nums==null || nums.length ==0 ) return ;
    var n = nums.length-1;
    while(n>0 && nums(n)<=nums(n-1)) n -= 1;
    if(n==0){
        reverse(nums,0,nums.length-1);
    }else{
        var i = findminMax(nums,n-1);
        swap(nums,n-1,i);
        reverse(nums,n,nums.length-1);
    }
}

def reverse(nums:Array[Int],start:Int,end:Int):Unit = {
    for(i <- start to (end+start)/2){
        swap(nums,i,end-(i-start));
    }
}

def findminMax(nums:Array[Int],primary:Int):Int = {
    var mark = primary+1;
    for(i <- primary+2 to nums.length-1){
        if(nums(i) <= nums(primary)) return mark;
        else{
            mark = i;
        }
    }
    return mark;
}

def swap(nums:Array[Int],i:Int,j:Int):Unit = {
    var temp = nums(i);
    nums(i) = nums(j);
    nums(j) = temp;
}
