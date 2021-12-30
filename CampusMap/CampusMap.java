/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campusmap;

//import com.sun.prism.paint.Color;
//import java.awt.Image;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CampusMap extends Application {
    public static Group root = new Group();
    
    @Override
    public void start(Stage primaryStage) {

        Image image;
        String path1 = "image/map.png";
        image = new Image(getClass().getResource(path1).toString());
        ImageView imageMap = new ImageView(image);
        
        Scene scene = new Scene(root, 937, 571);
        
        primaryStage.setTitle("Campus Map");
        primaryStage.setScene(scene);
        primaryStage.show();   
    }

    public static void main(String[] args) {
        map map1 = new map();
        aim[] aims  = new aim[2]; //массив для целей
        rect[] building = new rect[5]; //массив для зданий
        //int bs = 10; //be_smaller - уменьшить размер квадратов/прямоугольников на карте
        building[0] = new rect(60,60,1,"Campus1",aims); //x=166 y=170
        building[1] = new rect(70,70,2,"Campus2",aims);
        building[2] = new rect(110,110,3,"Campus3",aims);
        building[3] = new rect(50,50,4,"Campus4",aims);
        building[4] = new rect(60,60,5,"Campus5",aims);
        Control c1 = new Control(building); //control 1
        aims[0]=new aim("All students",c1,1);
        aims[1]=new aim("Our group",c1,0);
        launch(args);    
    }
}
