/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

object Solution {
    def isValid(s: String): Boolean = {
        if(s==null) return false;
        var stack = new scala.collection.mutable.Stack[Char]();
        for(c <- s){
            c match {
                case x if(List('(','[','{').exists(y => y == x)) => stack.push(x);
                case ')' => {
                    if(stack.isEmpty || stack.pop != '(') return false;
                }
                case ']' => {
                    if(stack.isEmpty || stack.pop != '[') return false;
                }
                case '}' => {
                    if(stack.isEmpty || stack.pop != '{') return false;
                }
                case _ => return false;
            }
        }
        if(stack.isEmpty) return true;
        else return false;
    }
}
