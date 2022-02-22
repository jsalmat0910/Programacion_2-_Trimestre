package es.javiergarciaescobedo.cuatroenraya;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.shape.Circle;

public class Ficha extends Group {
        
    static final double TAM_FICHA = 40;
    double posX;
    double posY;
    
    public Ficha(char jugador) {
        Circle circleExterior = new Circle();
        circleExterior.setRadius(TAM_FICHA / 2);
        if(jugador == CuatroEnRaya.JUGADOR1) {
            circleExterior.setFill(Color.RED);
        } else {
            circleExterior.setFill(Color.BLUE);
        }
        circleExterior.setCenterX(0);
        circleExterior.setCenterY(0);
        circleExterior.setStroke(Color.DARKGRAY);
        
        Circle circleInterior = new Circle();
        circleInterior.setRadius(TAM_FICHA / 2 - 5);
        if(jugador == CuatroEnRaya.JUGADOR1) {
            LinearGradient g = LinearGradient.valueOf("from 0% 0% to 100% 100%, DarkRed 0%, Red 75% , White 100%");
            circleInterior.setFill(g);
        } else {
            LinearGradient g = LinearGradient.valueOf("from 0% 0% to 100% 100%, DarkBlue 0%, Blue 75% , White 100%");
            circleInterior.setFill(g);
        }
        circleInterior.setCenterX(0);
        circleInterior.setCenterY(0);
        circleInterior.setStroke(Color.LIGHTGRAY);
        
        this.setLayoutX(0);
        this.setLayoutY(0);
        this.getChildren().addAll(circleExterior, circleInterior);
    }
    
    public void setPosX(double posX) {
        this.posX = posX;
        this.setLayoutX(this.posX);
    }
        
    public void setPosY(double posY) {
        this.posY = posY;  
        this.setLayoutY(this.posY);
    }
    
    public void moverY(int inc) {
        this.posY += inc;  
        this.setLayoutY(this.posY);
    }

    
}
