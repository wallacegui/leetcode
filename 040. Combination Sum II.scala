/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/
def combinationSumImp(candidates: Array[Int], index:Int,target: Int,
    stack:scala.collection.mutable.Stack[Int],
    result:scala.collection.mutable.ArrayBuffer[List[Int]]):Unit = {
    if(target==0){
            result += stack.toList;
            return ;
    }
    if(index<candidates.length && target>0){
        for(i<- index to candidates.length-1){
            if(i==0 || candidates(i)!=candidates(i-1) || (stack.size>0 && stack.top==candidates(i))){//前一个放了你才能放，不放的话都不放
                stack.push(candidates(i));
                combinationSumImp(candidates,i+1,target-candidates(i),stack,result)
                stack.pop()   
            }else{
                combinationSumImp(candidates,i+1,target,stack,result)
            }
        }
    }
}


def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    var result  = new scala.collection.mutable.ArrayBuffer[List[Int]]();
    var stack = new scala.collection.mutable.Stack[Int]();
    var sorted = candidates.sortWith(_<_)
    combinationSumImp(sorted,0,target,stack,result);
    return result.toList;
}


var candidates = Array(2,2,3)
var target = 5;
var stack = new scala.collection.mutable.Stack[Int]();
var result = new scala.collection.mutable.ArrayBuffer[List[Int]]();
combinationSumImp(candidates,0,target,stack,result);
combinationSum(candidates,target)
