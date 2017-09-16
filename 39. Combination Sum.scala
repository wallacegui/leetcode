/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/
//回溯递归算法

def combinationSumImp(candidates: Array[Int], index:Int,target: Int,
    stack:scala.collection.mutable.Stack[Int],
    result:scala.collection.mutable.ArrayBuffer[List[Int]]):Unit = {
    if(target==0){
            result += stack.toList;
            return ;
    }
    if(index<candidates.length && target>0){
        for(i<- index to candidates.length-1){
            stack.push(candidates(i));
            combinationSumImp(candidates,i,target-candidates(i),stack,result)
            var p = stack.pop()
        }
    }
}


def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    var result  = new scala.collection.mutable.ArrayBuffer[List[Int]]();
    var stack = new scala.collection.mutable.Stack[Int]();
    combinationSumImp(candidates,0,target,stack,result);
    return result.toList;
}


var candidates = Array(2,3,6,7)
var target = 7;
var stack = new scala.collection.mutable.Stack[Int]();
var result = new scala.collection.mutable.ArrayBuffer[List[Int]]();
combinationSumImp(candidates,0,target,stack,result);
combinationSum(candidates,target)

//回溯非递归算法
