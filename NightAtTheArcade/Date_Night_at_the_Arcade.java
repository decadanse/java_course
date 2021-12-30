/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practise7.nightAtTheArcade;
import java.util.Scanner;

public class Date_Night_at_the_Arcade {
    
    public static void main(String[] args) {
        System.out.print("Enter your card 1 number: ");
        Scanner console = new Scanner(System.in);
        int ncard1 = console.nextInt();
        
        System.out.print("Enter your card 2 number: ");
        int ncard2 = console.nextInt();
        
        Card card1 = new Card(ncard1); //create card 1 
        Card card2 = new Card(ncard2); //create card 2
        Terminal terminal = new Terminal(); //create Terminal to start program
        terminal.menu(card1, card2);  
    }    
}
