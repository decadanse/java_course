/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practise7.nightAtTheArcade;
import java.util.ArrayList;
import java.util.Scanner;

public class Terminal 
{
    ArrayList<PrizeCategory> prizes; //arraylist called prizesto hold PrizeCategory objects

    public Terminal() 
    {
        this.prizes = new ArrayList<>();
        prizes.add(new PrizeCategory("Big Prize", 50, 2));
        prizes.add(new PrizeCategory("Medium Prize", 25, 7));
        prizes.add(new PrizeCategory("Small Prize", 10, 10));
    }
    
    public void menu(Card firstCard, Card secondCard) 
    { 
        //menu terminal program
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter choosed card number: ");
        int cardNo = scan.nextInt();
        Card transactionCard = new Card(); 
        if (cardNo == firstCard.getCardNumber()) 
        {
            transactionCard = firstCard;
        }
        else if (cardNo == secondCard.getCardNumber()) 
        {
            transactionCard = secondCard;
        }
        else 
        {
            System.out.println("Invalid card number.");
            System.exit(0);
        }
        
        int exit = 1;
        while (exit != 0){
            //start menu
            System.out.println("\nWELCOME TO THE TERMINAL || CHOOSE AN OPTION BELOW");
            System.out.println("1. Main Menu \n2. Buy Credits \n3. Check Balance \n"
                + "4. Transfer Portal \n5. Claim Prizes \n6. Play Games \n0. Exit Program");
            int ch = scan.nextInt();
            switch(ch) 
            { 
                //access different menu functions
                case 1:
                    menu(firstCard, secondCard);
                break;
                case 2: 
                    convertMoney(transactionCard);
                //break;
                case 3:
                    checkBalance(transactionCard);
                break;
                case 4:
                    transferPortal(firstCard, secondCard);
                break;
                case 5:
                    claimPrizes(transactionCard);
                break;
                case 6:
                    Game game = new Game();
                    game.winRandomTickets(transactionCard);
                break;
                case 0:
                    exit = 0;
                    System.exit(0);
                break;
                default: 
                    System.out.println("INVALID INPUT.");
                break;
            }
        }
    }
    
    public void convertMoney(Card card) 
    { 
        // convert $ into credits
        System.out.println("Enter $ amount to convert /($1 = 2 CREDITS): ");
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();
        if (amount < 0) 
        {
            System.out.println("INVALID AMOUNT.");
        }
        else 
        {
            int newCredits = amount*2;
            card.setCreditBalance(card.getCreditBalance() + newCredits); //update credits
        }
    }
    
    public void checkBalance(Card card) 
    { 
        System.out.println("Card Number: " + card.getCardNumber() + "\n"
            + "Total Credits: " + card.getCreditBalance() + "\n"
                + "Total Tickets: " + card.getTicketBalance());
    }
    
    public void transferPortal(Card card1, Card card2) 
    { 
        // transfer credits/tickets menu
    	Scanner scan = new Scanner(System.in);
        System.out.println("\nWELCOME TO THE TRANSFER PORTAL || CHOOSE AN OPTION BELOW");
        System.out.println("1. Transfer Credits \n2. Transfer Tickets \n"
            + "0. Main Menu");
        int ch = scan.nextInt(); 
        switch(ch) 
        { 
            //access different functions
            case 1: 
                transferCredits(card1, card2);
            break;
            case 2:
                transferTickets(card1, card2);
            break;
            case 0:
                menu(card1, card2);
            break;
            default: 
                System.out.println("INVALID INPUT.");
            break;
        }
    }
    
    public void transferCredits(Card card1, Card card2) 
    { 
        // transfer credits
        System.out.print("Enter sender's card number: "); // choose sender/recipient
        Scanner scan = new Scanner(System.in);
        int cardNo = scan.nextInt();
        if (cardNo == card1.getCardNumber())
        {
            System.out.print("Enter credits to transfer: ");
            int newCreds = scan.nextInt();
            if (newCreds > card1.getCreditBalance()) 
            { 
                // check credit balance before transfer
                System.out.println("Insufficient credits.");
            }
            else 
            { 
                // update credits in both cards
                card1.setCreditBalance(card1.getCreditBalance() - newCreds); 
                card2.setCreditBalance(card2.getCreditBalance() + newCreds);
            }
        }
        else if (cardNo == card2.getCardNumber()) 
        {
            System.out.print("Enter credits to transfer: ");
            int newCreds = scan.nextInt();
            if (newCreds > card2.getCreditBalance()) 
            { 
                // check credit balance before transfer
                System.out.println("Insufficient credits.");
            }
            else 
            { 
                // update credits to both cards
                card2.setCreditBalance(card2.getCreditBalance() - newCreds);
                card1.setCreditBalance(card1.getCreditBalance() + newCreds);
            }
        }
        else 
        {
            System.out.println("INVALID CARD NUMBER.");
        }
    }
    
    public void transferTickets(Card card1, Card card2) 
    { 
        // transfer tickets, similar to credits
        System.out.print("Enter sender's card number: "); // choose sender/recipient
        Scanner scan = new Scanner(System.in);
        int cardNo = scan.nextInt();
        if (cardNo == card1.getCardNumber()) 
        {
            System.out.print("Enter tickets to transfer: "); // number of tickets to transfer
            int newTickets = scan.nextInt(); 
            if (newTickets > card1.getTicketBalance()) 
            { // checking tickets balance
                System.out.println("Insufficient credits."); 
            }
            else 
            { 
                // update both cards after transfer
                card1.setTicketBalance(card1.getTicketBalance() - newTickets);
                card2.setTicketBalance(card2.getTicketBalance() + newTickets);
            }
        }
        else if (cardNo == card2.getCardNumber()) 
        {
            System.out.print("Enter tickets to transfer: ");
            int newTickets = scan.nextInt();
            // check ticket balance
            if (newTickets > card2.getTicketBalance()) 
            { 
                System.out.println("Insufficient credits.");
            }
            else 
            { 
                // update both cards after transfer
                card2.setTicketBalance(card2.getTicketBalance() - newTickets);
                card1.setTicketBalance(card1.getTicketBalance() + newTickets);
            }
        }
        else 
        {
            System.out.println("INVALID CARD NUMBER.");
        }
    }
    
    public void claimPrizes(Card card) 
    { 
        // prize bmenu
    	Scanner scan = new Scanner(System.in);
        // start menu
        System.out.println("\nWELCOME TO THE TERMINAL || CHOOSE AN OPTION BELOW");
        System.out.println("1. Claim 1st Prize \n2. Claim 2nd Prize \n"
            + "3. Claim 3rd Prize \n0. Go back");
        int ch = scan.nextInt();
        switch(ch) 
        { 
            //access different prizes
            case 1:
                if (card.getTicketBalance() < prizes.get(0).getNumberOfTickets()) 
                { 
                    // check tickets before claiming
                    System.out.println("Insufficient tickets.");
                }
                else 
                {
                    if (prizes.get(0).getNumberOfPrizeItems() < 0) 
                    { 
                        // check if any prizes are left in the terminal
                        System.out.println("Out of prizes, sorry!"); 
                    }
                    else 
                    {
                        System.out.println("1st Prize Claimed for " + prizes.get(0).getNumberOfTickets() + " tickets!"); // update prizes
                        card.setTicketBalance(card.getTicketBalance() - prizes.get(0).getNumberOfTickets());
                        prizes.get(0).setNumberOfPrizeItems(prizes.get(0).getNumberOfPrizeItems() - 1);
                    }
                }
            break;
            case 2:
                if (card.getTicketBalance() < prizes.get(1).getNumberOfTickets()) 
                {
                    System.out.println("Insufficient tickets.");
                }
                else 
                {
                    if (prizes.get(1).getNumberOfPrizeItems() < 0) 
                    { 
                        System.out.println("Out of prizes, sorry!");
                    }
                    else 
                    {
                        System.out.println("2nd Prize Claimed for " + prizes.get(1).getNumberOfTickets() + " tickets!");
                        card.setTicketBalance(card.getTicketBalance() - prizes.get(1).getNumberOfTickets());
                        prizes.get(1).setNumberOfPrizeItems(prizes.get(1).getNumberOfPrizeItems() - 1);
                    }
                }
            break;
            case 3:
                if (card.getTicketBalance() < prizes.get(2).getNumberOfTickets()) 
                {
                    System.out.println("Insufficient tickets.");
                }
                else 
                {
                    if (prizes.get(2).getNumberOfPrizeItems() < 0) 
                    {
                        System.out.println("Out of prizes, sorry!");
                    }
                    else 
                    {
                        System.out.println("3rd Prize Claimed for " + prizes.get(2).getNumberOfTickets() + " tickets!");
                        card.setTicketBalance(card.getTicketBalance() - prizes.get(2).getNumberOfTickets());
                        prizes.get(2).setNumberOfPrizeItems(prizes.get(2).getNumberOfPrizeItems() - 1);
                    }
                }
            break;
            default: 
                System.out.println("INVALID INPUT.");
            break;
        }
    }
}

