/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/

object Solution {
    def groupAnagrams(strs: Array[String]): List[List[String]] = {
        var prime = Array(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103);
        val hashMap = new scala.collection.mutable.HashMap[Int,List[String]]();
        for(word <- strs){
            var key = 1;
            for(c <- word){
                key *= prime(c-'a');
            }
            if(hashMap.contains(key)){
                hashMap += key -> (word :: hashMap(key));
            }else{
                hashMap += key -> List(word);
            }
        }
        return hashMap.values.toList;
    }
}
