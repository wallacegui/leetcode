

/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/

def removeDuplicates(nums: Array[Int]): Int = {
    if(nums==null || nums.length==0) return 0;
    var n = nums.length;
    var deleted=0;
    var i = 0;
    while(i<n){
        nums(i-deleted) = nums(i);
        if(i<n-2 && nums(i+1)==nums(i)){
            i+=1;
            nums(i-deleted)=nums(i);
            i+=1;
            while(i<n && nums(i)==nums(i-1)){
                i += 1;
                deleted += 1;
            }
        }else{
            i += 1;
        }
    }
    return n-deleted;
}


var mark = Array(1,1,2,2,2,3)
removeDuplicates(mark
mark

var mark = Array(1,1,2,2,2,2)
removeDuplicates(mark)
mark


var mark = Array(1,1,1)
removeDuplicates(mark)
mark

var mark = Array(1,1,2,2,3,3)
removeDuplicates(mark)
mark

var mark = Array(1)
removeDuplicates(mark)
mark


var mark = Array(1,2)
removeDuplicates(mark)
mark

var mark = Array(1,1,2)
removeDuplicates(mark)
mark


var mark = Array(1,2,2)
removeDuplicates(mark)
mark


var mark = Array(1,2,3)
removeDuplicates(mark)
mark
