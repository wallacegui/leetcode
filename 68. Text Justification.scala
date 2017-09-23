/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

*/

object Solution {
    
def mkSpace(n:Int):String = {
    var result = "";
    for(i<- 1 to n){
        result += " ";
    }
    return result;
}



def mk(words:Array[String],start:Int,end:Int,maxWidth:Int):String ={
    if(start>end) return "";
    var result ="";
    var length = 0;
    for(i<-start to end){
        length += words(i).length;
    }
    var spaceNum = if(start==end) 0 else (maxWidth-length)/(end-start);
    var lastSpaceNum = (maxWidth-length)-(end-start)*spaceNum;
    if(end<words.length-1){
        result = result + words(start);
        result = result + mkSpace(spaceNum);
        if(lastSpaceNum>0) result = result + " ";
        lastSpaceNum -= 1;

        for(i<-start+1 to end-1){
            result = result + words(i);
            result = result + mkSpace(spaceNum);
        
            if(lastSpaceNum>0) result = result + " ";
            lastSpaceNum -= 1;
        }
        if(end>start) result += words(end);
        else{
            result = result + mkSpace(lastSpaceNum);
        }
    }else{
        for(i<-start to end-1){
            result = result + words(i);
            result = result + " ";
            length += words.length;
            length += 1;
        }
        result += words(end);
        val spaceNum = maxWidth-result.length;
        result = result + mkSpace(spaceNum);
    }
    return result;
}



def fullJustify(words: Array[String], maxWidth: Int): List[String] = {
    var result:List[String] = List();
    var preIndex = -1;
    var currentLen =0;
    for(i<- 0 to words.length-1){
        
        currentLen += words(i).length;

        //如果刚好装下
        if(currentLen==maxWidth){
            result = result ++ List(mk(words,preIndex+1,i,maxWidth));
            preIndex = i;
            currentLen = 0;
        }else if(currentLen > maxWidth){//如果装不下
            result = result ++ List(mk(words,preIndex+1,i-1,maxWidth));
            preIndex = i-1;
            currentLen = words(i).length+1;
        } else {//如果装下了
            currentLen += 1;
        }
    }
    if(preIndex<words.length-1) result = result ++ List(mk(words,preIndex+1,words.length-1,maxWidth));
    return result
}


}

