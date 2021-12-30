/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campusmap;
public class Control {
    public double pointaX;
    public double pointaY;
    public double pointgX;
    public double pointgY;
    public double AllMass;
    public double AllGroupMass;
    rect[] shapes;
    
    public Control(rect[] shapes){
        this.shapes=shapes;
    }
    //Геттеры
    //Установка новой координаты X центра масс всех студентов
    public double getAllnewX(){
        AllMass=0;
        for (int i=0;i<shapes.length;++i){
            pointaX+= shapes[i].getXpointC()*shapes[i].getAllMass();
            AllMass+= shapes[i].getAllMass();   
        }
        pointaX= pointaX/AllMass;
        System.out.println(pointaX);
        return pointaX;
    }
    //Установка новой координаты Y центра масс всех студентов
    public double getAllnewY(){
        AllMass=0;
        for (int i=0;i<shapes.length;++i){
            pointaY+=shapes[i].getYpointC()*shapes[i].getAllMass();
            AllMass+=shapes[i].getAllMass();   
        }
        pointaY= pointaY/AllMass;
        System.out.println(pointaY);
        return pointaY;
        
    }
    //Установка новой координаты X центра масс всей группы
    public double getGroupX(){
        AllGroupMass=0;
        for (int i=0;i<shapes.length;++i) {
            pointgX += shapes[i].getXpointC()*shapes[i].getGroupMass();
            AllGroupMass += shapes[i].getGroupMass();   
        }
        pointgX=pointgX/AllGroupMass;
        System.out.println(pointgX);
        return pointgX;
    }
    //Установка новой координаты Y центра масс всей группы
    public double getGroupY(){
        AllGroupMass=0;
        for (int i=0;i<shapes.length;++i) {
            pointgY += shapes[i].getYpointC()*shapes[i].getGroupMass();
            AllGroupMass += shapes[i].getGroupMass();   
        }
        pointgY=pointgY/AllGroupMass;
        System.out.println(pointgY);
        return pointgY;
    } 
}
