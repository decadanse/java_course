/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campusmap;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class map {
    //Создаем фоновое изображение
    public map(){
        Image image;
        String path1 = "image/map.png";
        image = new Image(getClass().getResource(path1).toString());
        ImageView imageMap = new ImageView(image);
        CampusMap.root.getChildren().add(imageMap);
    }   
}
