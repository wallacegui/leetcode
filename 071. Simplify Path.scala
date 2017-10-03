/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/

def simplifyPath(path: String): String = {
    if(path==null) return "/";
    var mark = path.split("/");
    var stack = new scala.collection.mutable.Stack[String]();
    for(i<- 0 to mark.length-1){
        mark(i) match {
            case "." => {}
            case "" => {}
            case ".." => if(!stack.isEmpty) stack.pop();
            case _ => stack.push(mark(i))

        }
    }
    "/" + stack.toList.reverse.mkString("/");    
}

simplifyPath("/home/")

simplifyPath("/a/./b/../../c/")

simplifyPath("/../")

simplifyPath("/home//foo/")

simplifyPath(""/abc/..."")
