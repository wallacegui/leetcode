/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

//递归算法
def subsets(nums: Array[Int]): List[List[Int]] = {
    var sorted = nums.sortWith(_<_);
    subsetsImp(sorted,0).distinct    
}

def subsetsImp(nums:Array[Int],index:Int): List[List[Int]] = {
    if(index==nums.length-1){
        List(List(),List(nums(index)))
    }else{
        var notContainsN = subsetsImp(nums,index+1);
        var containsN = notContainsN.map( l => nums(index)::l);
        notContainsN ++ containsN;
    }
}
