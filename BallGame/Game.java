/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice8_ballGame;
public class Game {
    private int number,temp,goal_home,goal_away;
    private String home,away;
    //constructor
    public Game(int number,int temp,String home,String away,int goal_home,int goal_away){
        this.number=number;
        this.temp=temp;
        this.home=home;
        this.away=away;
        this.goal_home=goal_home; //забито 1й выбранной командой (принимающей)
        this.goal_away=goal_away; //забито 2й выбранной командой
    }
    //getters
    public int getNumber(){ return number;}
    public int getTemp(){ return temp;}
    public int getGoal_home(){ return goal_home;}
    public int getGoal_away(){ return goal_away;}
    public String getHome(){ return home;}
    public String getAway(){ return away;}
    //setters
    public void setGoal_home(int goal_home){ this.goal_home=goal_home;}
    public void setGoal_away(int goal_away){ this.goal_away=goal_away;}
}
