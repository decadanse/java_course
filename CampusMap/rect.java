/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campusmap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.regex.*;

//import javafxapplication1.Control;
//import javafxapplication1.aim;

public class rect  {
    public int x,y,z;
    public String name;
    public double xPoint,yPoint,xPointC,yPointC,allMass,groupMass,rWidth,rHeight; 
    aim[] aims;
    //public Control c2;
    public rect(int x,int y,int z,String name,aim[] aims){ //z - color
        allMass=1.0;
        groupMass=1.0;
        rWidth=1.0;
        rHeight=1.0;
        Rectangle rect = new Rectangle(0,0,x,y);
        String[] color = new String[6];
        //Цвета фигур и контур
        color[0] = "#FF0000";//RED
        color[1] = "#00FFFF";//AQUA
        color[2] = "#00FF00";//LIME
        color[3] = "#DA70D6";//ORCHID
        color[4] = "#FFD700";//GOLD
        color[5] = "#D2691E";//CHOCOLATE
        //Задаем цвет заливки и контур для фигуры
        rect.setFill(Color.web(color[z],0.5));
        rect.setStroke(Color.web(color[0]));
        //Задаем текст фигуры
        Text rectName = new Text();
        rectName.setText(name);
        rectName.setFont(new Font(25));
        rectName.setFill(Color.RED);
        //Панель задания Всех студентов
        HBox text1 = new HBox();
        //Текст Всех студентов
        Text display1 = new Text();
        display1.setText("All students:");
        display1.setFont(new Font(15));
        display1.setFill(Color.RED);
        //Поле ввода Всех студентов
        TextField textp = new TextField();
        textp.setPrefColumnCount(5);
        //textp.setText("1");
        //Кнопка изменения Всех студентов
        Button btnf = new Button();
        btnf.setText("OK");
        //Добавление элементов на горизонтальную панель Всех студентов
        text1.getChildren().addAll(display1,textp,btnf);
        //Панель задания Группы
        HBox text2 = new HBox();
        //Текст Группы
        Text OurGroup = new Text();
        OurGroup.setText("Our group:");
        OurGroup.setFont(new Font(15));
        OurGroup.setFill(Color.RED);
        //Поле ввода Группы
        TextField textField1 = new TextField();
        textField1.setPrefColumnCount(5);
        //textField1.setText("1");
        //Кнопка изменения Группы
        Button btn1 = new Button();
        btn1.setText("OK");
        //Добавление элементов на горизонтальную панель Группы
        text2.getChildren().addAll(OurGroup,textField1,btn1);
        //
        //Добавление элементов на вертикальную панель
        //this.box1=box1;
        VBox box1 = new VBox();
        box1.getChildren().add(rect);
        box1.getChildren().add(rectName);
        box1.getChildren().add(text1);
        box1.getChildren().add(text2);
        
        //Изменение начальных координат квадратов //почему-то ломает мишень
        //не ломает. надо просто чуть подвигать каждый квадрат
        if (name=="Campus1"){ 
            //+ необходима поправка на 30 по y и 30 по x
            //relocate(double x, double y) 
            box1.relocate(136,150); 
        }else if(name=="Campus2"){
            box1.relocate(722,313);
        }else if(name=="Campus3"){
            box1.relocate(400,165); 
        }else if(name=="Campus4"){
            box1.relocate(572,420); 
        }else if(name=="Campus5"){
            box1.relocate(420,397); 
        }
        
        //Добавление элемента на сцену
        CampusMap.root.getChildren().add(box1);
        //Действия над объектами
        //Перетаскивание объекта
        box1.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                box1.setLayoutX(event.getSceneX());
                box1.setLayoutY(event.getSceneY());
                xPoint=box1.getLayoutX();
                yPoint=box1.getLayoutY();
                rWidth=rect.getWidth();
                rHeight=rect.getHeight(); 
                xPointC=xPoint+(rWidth/2);
                yPointC=yPoint+(rHeight/2);
                aims[0].setPointA();
                aims[1].setPointA();
            }
        });
        //Изменение размера Квадрата от вводимого размера
        btnf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int parse=0;
                String jojo = textp.getText();
                if(jojo.matches("\\d+")){ //match a string having the positive integer data of any length
                    parse = Integer.parseInt(jojo);
                    if(parse<=0||parse>100){ //допустим, студентов не больше 100(группы с потока)
                        parse=1;
                    }
                }
                else{
                    parse = 1;
                }
                
                rect.setWidth(parse*0.5);
                rect.setHeight(parse*0.5);
                allMass= parse;
                rWidth=rect.getWidth();
                rHeight=rect.getHeight(); 
                xPointC=xPoint+(rWidth/2);
                yPointC=yPoint+(rHeight/2);
                aims[0].setPointA();
                aims[1].setPointA();
            }
        });
        //Изменение группы от вводимого размера
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int parse1=0;
                String jojo1 = textField1.getText();
                if (jojo1.matches("\\d+")){
                    parse1 = Integer.parseInt(jojo1);
                    if(parse1<=0||parse1>400){
                        parse1=1;
                    }
                }
                else{
                    parse1 = 1;
                }
                groupMass= parse1;
                rWidth=rect.getWidth();
                rHeight=rect.getHeight(); 
                xPointC=xPoint+(rWidth/2);
                yPointC=yPoint+(rHeight/2);
                aims[0].setPointA();
                aims[1].setPointA();
            }
        });
    }
    //Геттеры
    public double getXpoint(){
        System.out.println("X: "+xPoint);
        return xPoint;
        }
    public double getYpoint(){
        System.out.println("Y: "+yPoint);
        return yPoint;
        }
    public double getXpointC(){
        System.out.println("центр X: "+xPointC);
        return xPointC;
        }
    public double getYpointC(){
        System.out.println("центр Y: "+yPointC);
        return yPointC;
        }
    public double getAllMass(){
        return allMass;
        }
    public double getGroupMass(){
        return groupMass;
        }
    public double getWidth1(){
        System.out.println("ширина: "+rWidth);
        return rWidth;
        }
    public double getHeight1(){
        System.out.println("высота: "+rHeight);
        return rHeight;
        }
}

