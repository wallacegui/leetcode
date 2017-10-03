/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

def swap(nums:Array[Int],i:Int,j:Int):Unit = {
    val temp = nums(i);
    nums(i) =nums(j);
    nums(j) = temp;
}

def permuteImp(nums:Array[Int],i:Int,result:scala.collection.mutable.ArrayBuffer[List[Int]]):Unit = {
    if(i == nums.length-1) {
        result += nums.toList;
    }else{
        for(j <- i to nums.length-1){
            swap(nums,i,j);
            permuteImp(nums,i+1,result);
            swap(nums,i,j);
        }
    }
}

def permute(nums: Array[Int]): List[List[Int]] = {
    val result = new scala.collection.mutable.ArrayBuffer[List[Int]]();
    permuteImp(nums,0,result);
    return result.toList;
}

