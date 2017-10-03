/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/
object Solution {
    def sortColors(nums: Array[Int]): Unit = {
        
    }
}

def swap(nums:Array[Int],i:Int,j:Int) ={
    val temp = nums(i);
    nums(i) = nums(j);
    nums(j) = temp;
}

def sortColors(nums: Array[Int]): Unit = {
    var n = nums.length;
    var i = -1;
    var j = -1;
    var k =0;
    while(k<n){
        if(nums(k)<2){
            j += 1;
            swap(nums,j,k);
            if(nums(j)==0){
                i += 1;
                swap(nums,i,j);
            }
        }
        k += 1;
    }
}

scala> val x  = Array(2,1,0,2,1,2,2,1,0)
x: Array[Int] = Array(2, 1, 0, 2, 1, 2, 2, 1, 0)

scala> sortColors(x)

scala> x
res7: Array[Int] = Array(0, 0, 1, 1, 1, 2, 2, 2, 2)
