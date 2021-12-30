/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practise7.nightAtTheArcade;

public class PrizeCategory 
{
    private String prizeLevel;
    private int numberOfTickets;
    private int numberOfPrizeItems;
    
    public PrizeCategory(String prizeLevel, int numberOfTickets, int numberOfPrizeItems) 
    {
        this.prizeLevel = prizeLevel;
        this.numberOfTickets = numberOfTickets;
        this.numberOfPrizeItems = numberOfPrizeItems;
    }
    
    public String getPrizeLevel() { return prizeLevel; }
    
    public void setPrizeLevel(String prizeLevel)
    {
        this.prizeLevel = prizeLevel;
    }

    public int getNumberOfTickets() { return numberOfTickets; }

    public void setNumberOfTickets(int numberOfTickets)
    {
        this.numberOfTickets = numberOfTickets;
    }

    public int getNumberOfPrizeItems() { return numberOfPrizeItems; }

    public void setNumberOfPrizeItems(int numberOfPrizeItems)
    {
        this.numberOfPrizeItems = numberOfPrizeItems;
    }
}
