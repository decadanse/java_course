/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practise7.nightAtTheArcade;
import java.util.Random;
public class Game 
{
    static int REQUIRED_CREDITS = 10; 
    private int tickets;
    
    public boolean checkBalance(Card card) 
    { 
        //checke card balance
        return card.getCreditBalance() >= REQUIRED_CREDITS; 
    }
    
    public void winRandomTickets(Card card) 
    {   
        //random tickets game
        //check balance with call to previous method
        if (checkBalance(card) == false) 
        { 
            System.out.println("Insufficient balance. At least 10 Credits required to play game.\n");
        }
        else 
        {
            Random rand = new Random(); //generate random number of tickets 
            int newTickets = rand.nextInt(16); //between 0 and 25
            card.setCreditBalance(card.getCreditBalance() - REQUIRED_CREDITS); //update credit balance
            card.setTicketBalance(card.getTicketBalance() + newTickets); //add new tickets
            System.out.println("Card Number: " + card.getCardNumber() + "\n"
                + "Tickets Won: " + newTickets + "\n"
                    + "New Total: " + card.getTicketBalance()); //card information
        }
    }
    
    public int getTickets() { return tickets; }
    
    public void setTickets(int tickets) { this.tickets = tickets; }   
}

