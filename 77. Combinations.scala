/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

def combine(n: Int, k: Int): List[List[Int]] = {
    if(n<=0 || k <=0) return List();
    if(k==1) return (1 to n).map(x => List(x)).toList;
    var containsN = combine(n-1,k-1).map(l => l ++ List(n));
    var notConatainsN = combine(n-1,k);
    notConatainsN++containsN;
}
combine(4,2)
