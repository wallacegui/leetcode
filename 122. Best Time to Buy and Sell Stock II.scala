/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

 
    def maxProfit(prices: Array[Int]): Int = {
        if(prices==null || prices.length<2) return 0;
        val n = prices.length;
        var earn = 0;
        var index = 0;
        while(index<n){
            while(index<n-1 && prices(index)>=prices(index+1)) index += 1;
            val buy: Int = prices(index);
            index += 1;
            while(index<n && prices(index)>prices(index-1)) index += 1;
            val sell = prices(index-1);
            earn += sell-buy; 
        }
        return earn;    
    }

    maxProfit(Array(1, 5, 3, 4, 6,2,3))

    maxProfit(Array(7, 6, 4, 3, 1))
    
