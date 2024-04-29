package Project2.StocksBot.Tester;

import java.io.IOException;
import Project2.StocksBot.Program.StockAnalyzer;
import Project2.StocksBot.Structures.StockDay;

public class StocksTester {

    public static void main(String[] args){
        //test import
        StockAnalyzer stockAnalyzer = new StockAnalyzer();
        try{
            stockAnalyzer.importObjects("E:\\Coding Projects\\Probability-and-Applied-Statistics-2024" +
                    "\\src\\main\\java\\Project2\\StocksBot\\Files\\MSFT.csv");
        }catch (IOException i){
            i.printStackTrace();
        }
        //check data
        StockDay aDay = stockAnalyzer.getDaysData().get(0);
        System.out.println("Date | Open | High | Low | Close | Adj Close | Volume");
        System.out.println(aDay.dailyValuesToString());
        //test buying and selling
        System.out.println(stockAnalyzer.runProgram(stockAnalyzer.getMyMoney().doubleValue() / 2));
        //test export
    }
}
