/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campusmap;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import campusmap.Control;

public class aim {
    public String name;
    public double xPoint,yPoint;
    public VBox box1;
    public Image image;
    public int swi; //switch
    Control c1; 
    public Circle point;

    public aim(String name,Control c1,int swi){   

        this.box1 = new VBox();
        this.swi=swi; //1 - если "Все студенты". Некий индекс.
        this.c1=c1;  //control 1
        //Задаем картинку цели
        String path1 = "image/aim.png";
        image = new Image(getClass().getResource(path1).toString());
        ImageView imageMap = new ImageView(image);
        //Задаем текст цели
        Text display1 = new Text();
        display1.setText(name);
        display1.setFont(new Font(15));
        display1.setFill(Color.RED);
        //Задаем вертикальную панель и добавляем на нее элементы: картинка,текст,кнопка
        box1.getChildren().add(imageMap);
        box1.getChildren().add(display1);
        //Добавляем вертикальную панель на сцену
        CampusMap.root.getChildren().add(box1);
        this.setXpoint();
        this.setYpoint();
        this.updateDrawing();
    }
    
    //Сеттеры
    public void updateDrawing() {
        box1.setLayoutX(xPoint);
        box1.setLayoutY(yPoint);           
    }
    public void setXpoint(){
        if (swi==1){
            this.xPoint=c1.getAllnewX()-(image.getWidth()/2); //установка Центра масс Всех студентов  
        }else{
            this.xPoint=c1.getGroupX()-(image.getWidth()/2);
        }
    }
    public void setYpoint(){
        if(swi==1){
            this.yPoint=c1.getAllnewY()-(image.getHeight()/2);//установка Центра масс Всех студентов  
        }else{
            this.yPoint=c1.getGroupY()-(image.getHeight()/2);}
        }
    public void setPointA(){
            this.setXpoint();
            this.setYpoint();
            this.updateDrawing();
    }
}
