/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practise7.nightAtTheArcade;
public class Card 
{
    private int creditBalance;
    private int ticketBalance;
    private int cardNumber;
    public Card() {   }
    
    public Card(int cardNumber) 
    {
        this.cardNumber = cardNumber;
    }
    
    public int getCreditBalance()
    {
        return creditBalance;
    }

    public void setCreditBalance(int creditBalance)
    {
        this.creditBalance = creditBalance;
    }

    public int getTicketBalance()
    {
        return ticketBalance;
    }

    public void setTicketBalance(int ticketBalance)
    {
        this.ticketBalance = ticketBalance;
    }

    public int getCardNumber()
    {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber)
    {
        this.cardNumber = cardNumber;
    }
}
