package es.javiergarciaescobedo.cuatroenraya;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class PanelPuntuaciones extends StackPane {
    
    static Label labelTurno = new Label();
    
    public PanelPuntuaciones() {
        this.getChildren().add(labelTurno);
        this.setMinHeight(100);
    } 
    
    public static void mostrarTurno(char jugador) {
        labelTurno.setText("Turno: " + jugador);
    }
    
    
}
