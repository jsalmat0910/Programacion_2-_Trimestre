package es.javiergarciaescobedo.cuatroenraya;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class PanelMensajes extends StackPane {
        
    static Label labelMensaje = new Label();
    final static byte TIEMPO_MENSAJE = 3;
    
    public PanelMensajes() {
        this.getChildren().add(labelMensaje);
        this.setMinHeight(100);
    } 
    
    public static void mostrarMensaje(String mensaje) {
        labelMensaje.setText(mensaje);
        Timeline timelineMensaje = new Timeline(
            new KeyFrame(Duration.seconds(TIEMPO_MENSAJE), (ActionEvent t) -> {
                labelMensaje.setText("");
        })
        );
        timelineMensaje.setCycleCount(1);
        timelineMensaje.play();
    }
    
    
}
