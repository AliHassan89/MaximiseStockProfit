/*

Writing programming interview questions hasn't made me rich. Maybe trading Apple
stocks will. Suppose we could access yesterday's stock prices as an array, where:

The indices are the time in minutes past trade opening time, which was 9:30am 
local time.
The values are the price in dollars of Apple stock at that time.
So if the stock cost $500 at 10:30am, stockPricesYesterday[60] = 500.

Write an efficient method that takes stockPricesYesterday and returns the best 
profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.

For example:

  int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};

getMaxProfit(stockPricesYesterday);
// returns 6 (buying for $5 and selling for $11)

No "shorting"—you must buy before you sell. You may not buy and sell in the 
same time step (at least 1 minute must pass).

 */
package maximisestockprofit;

/**
 *
 * @author Ali
 */
public class MaximiseStockProfit 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};
        System.out.println(maximiseStockProfit(stockPricesYesterday));
    }
    
    /*
        buy     arr[i]      profit      max_profit
        10          7        -3             -3
        7           5        -2             -2
        5           8         3             3
        5           11        6             6
        5           9         6             6
    */
    
    private static int maximiseStockProfit(int[] arr)
    {
        if (arr.length <= 0)
            return 0;
        
        int buy = arr[0];
        int profit = Integer.MIN_VALUE;
        int max_profit = Integer.MIN_VALUE;

        for (int i=1; i<arr.length; i++)
        {
            profit = Math.max(profit, arr[i]-buy);
            if (buy > arr[i])
            {
                buy = arr[i];
            }
            if (max_profit < profit)
                max_profit = profit;
        }
        
        return max_profit;
    }
    
}
