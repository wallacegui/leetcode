/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/


object Solution {
    def letterCombinations(digits: String): List[String] = {
        if(digits==null || digits.length==0) return List();
        var alpha = int2CharMap(digits(0).toInt-48);
        if(digits.length == 1) return alpha;
        else{
            var subString = digits.substring(1);
            var beata = letterCombinations(subString);
            return joinArray(alpha,beata);
        }
    }

    def joinArray(alpha:List[String],beata:List[String]) : List[String] = {
        if(alpha==null || alpha.length==0) return beata;
        if(beata==null || beata.length==0) return alpha;
        alpha.map( str => beata.map(str+_)).reduce( _ ++ _)
    }

    def int2CharMap(i:Int) : List[String] = {
        i match {
            case x if(x>1 && x <7) => {
                var y = (x-2)*3;
                List((y+97).toChar.toString,(y+98).toChar.toString,(y+99).toChar.toString)
            }
            case 7 => List("p","q","r","s");
            case 8 => List("t","u","v");
            case 9 => List("w","x","y","z");
            case 0 => List("");
            case _ => List();
        }
    }
}
