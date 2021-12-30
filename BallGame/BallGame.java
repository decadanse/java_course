package practice8_ballGame;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
        
public class BallGame {
    public static Pair Score(int num,int temp,Team team1,Team team2){
        String t1=team1.getName();
        String t2=team2.getName();
        //Генерация зависимости максимального числа голов от температуры
        //Чем выше температура - тем больше суммарное число голов
        Random rndNum = new Random();
        int randomNum1 = rndNum.nextInt(6);
        int randomNum2 = rndNum.nextInt(6);
        int score1 = randomNum1+((randomNum1*randomNum1*temp)/100);
        int score2 = randomNum2+((randomNum2*randomNum2*temp)/100);
        //Начисляем очки победы,поражения,ничей обоим командам
        if (score1>score2){
            team1.setWin(team1.getWin()+1);
            team2.setLose(team2.getLose()+1);
        }
        else if (score1==score2){
            team1.setDraw(team1.getDraw()+1);
            team2.setDraw(team2.getDraw()+1);  
        }
        else{
            team1.setLose(team1.getLose()+1);
            team2.setWin(team2.getWin()+1);
        }
        //Записываем забитые и пропущенные мячи обоим командам
        team1.setGoals_scored(team1.getGoals_scored()+score1);
        team1.setGoals_received(team1.getGoals_received()+score2);
        team2.setGoals_scored(team2.getGoals_scored()+score2);
        team2.setGoals_received(team2.getGoals_received()+score1);
        //return score_result[];
        //games[num].setGoal_home(int goal_home);
        //games[num].setGoal_away(int goal_away);
        return new Pair(score1,score2);
        
    }
   
    public static void main(String[] args) {
        //Создание массива Команд
        Team [] teams = new Team[4];
        teams[0] = new Team("Team 1");
        teams[1] = new Team("Team 2");
        teams[2] = new Team("Team 3");
        teams[3] = new Team("Team 4");
        //Создание массива Игр
        ArrayList<Game> games = new  ArrayList();
        //счётчик холода,недель,температуры,игр
        int cold=0,week=0,htemp=0,num=0,avrg_temp=0,maxTemp=0;
        //ВВОД
        Scanner sc = new Scanner(System.in);
        int input;
        //Цикл ВВОДА
        while (cold<3){ //Играем до трех подряд холодных недель - конец сезона
            System.out.print("Введите температуру воздуха: ");
            input = sc.nextInt();
            if (input>=0){
                System.out.println("Играем!");
                cold=0;
                week+=1;
                num+=1;
                htemp+=input;
                //Проверяем-устанавливаем (новую) максимальную температуру
                if(input>maxTemp){
                    maxTemp=input;
                }
                //Выбираем 2 случайные команды из 4
                int kmd1=0,kmd2=0;
                Random rndTeam = new Random();
                while (kmd1==kmd2){ //команда не может играть сама с собой
                    kmd1 = rndTeam.nextInt(4);
                    kmd2 = rndTeam.nextInt(4);
                }

                Pair test = Score(num,input,teams[kmd1],teams[kmd2]);
                games.add(new Game(num,input,teams[kmd1].getName(),teams[kmd2].getName(),test.getFirst(),test.getSecond()));
            }
            else{
                cold=cold+1;
                week+=1;
                System.out.println("Слишком холодно для игры!");
            }  
        }
        //Выводим результаты команд
        for(int i=0;i<teams.length;i++){
            System.out.println(teams[i].getName()+"\n"+
                    "Wins: "+teams[i].getWin()+", Losses: "+teams[i].getLose()+", Ties: "+teams[i].getDraw()+"\n"+
                    "Points Scored: "+teams[i].getGoals_scored()+", Points Allowed: "+teams[i].getGoals_received()+"\n");   
        }
        //Выводим результаты всех игр
        for(int i=0;i<games.size();i++){
        System.out.println("Game #"+games.get(i).getNumber()+"\n"+
            "Day temperature :"+games.get(i).getTemp()+"\n"+
            "Home Team: "+games.get(i).getHome()+" goals:"+games.get(i).getGoal_home()+"\n"+
            "Away Team: "+games.get(i).getAway()+" goals:"+games.get(i).getGoal_away()+"\n");
        }
        //Узнаем температуру
        avrg_temp=htemp/week;
        
        System.out.println("Hottest Temp: "+maxTemp);
        System.out.println("Average Temp: "+avrg_temp+"\n");
        }        
    }
    