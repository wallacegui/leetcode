/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
*/

    def maxProfit(prices: Array[Int]): Int = {
        if(prices==null || prices.length<2) return 0;
        val n = prices.length;
        var max = prices(n-1);
        var earn = 0;
        for(i <- (0 to n-2).reverse){
            earn = math.max(earn,max - prices(i));
            max = math.max(max,prices(i))
        }
        return earn;    
    }

    maxProfit(Array(7, 1, 5, 3, 6, 4))

    maxProfit(Array(7, 6, 4, 3, 1))
    
