/*

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

*/

def restoreIpAddresses(s: String): List[String] = {
    val result = scala.collection.mutable.ArrayBuffer[String]();
    for(i <- 1 to 3)
    for(j <- 1 to 3)
    for(k <- 1 to 3)
    for(l <- 1 to 3){
        if(i+j+k+l==s.length){
            val fst = s.substring(0,i).toInt;
            val snd = s.substring(i,i+j).toInt;
            val thd = s.substring(i+j,i+j+k).toInt;
            val fth = s.substring(i+j+k,i+j+k+l).toInt;
            if(fst<=255 && snd <= 255 && thd <= 255 && fth<=255){
                result += (fst+"."+snd+"."+thd+"."+fth);
            }
        }
    }
    return result.toList;
}

restoreIpAddresses("25525511135")
