/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice8_ballGame;
public class Team {
    private String name;
    private int win,lose,draw,goals_scored,goals_received;
        
    public Team(String name){ //constructor
        this.name=name;
        this.win=0;
        this.lose=0;
        this.draw=0;
        this.goals_scored=0;
        this.goals_received=0;
    }
        //getters
        public String getName(){ return name;}
        public int getWin(){ return win;}
        public int getLose(){ return lose;}
        public int getDraw(){ return draw;}
        public int getGoals_scored(){ return goals_scored;}
        public int getGoals_received(){ return goals_received;}
        
        //setters
        public void setWin(int win){ this.win=win;}
        public void setLose(int lose){ this.lose=lose;}
        public void setDraw(int draw){ this.draw=draw;}
        public void setGoals_scored(int goals_scored){ this.goals_scored=goals_scored;}
        public void setGoals_received(int goals_received){ this.goals_received=goals_received;}  
}