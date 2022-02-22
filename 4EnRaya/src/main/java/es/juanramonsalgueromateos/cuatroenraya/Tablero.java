package es.javiergarciaescobedo.cuatroenraya;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Tablero extends Pane {
    
    Timeline timelineFicha;
    CuatroEnRaya cuatroEnRaya;
    boolean fichaCayendo = false;
    final byte VELOCIDAD_FICHA = 5;
    
    public Tablero(CuatroEnRaya cuatroEnRaya) {
        this.cuatroEnRaya = cuatroEnRaya;
        this.setBackground(new Background(
            new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setMinWidth(Ficha.TAM_FICHA * cuatroEnRaya.tamXTablero);
        this.setMinHeight(Ficha.TAM_FICHA * (cuatroEnRaya.tamYTablero + 1)); 
        this.setMaxWidth(Ficha.TAM_FICHA * cuatroEnRaya.tamXTablero);
        this.setMaxHeight(Ficha.TAM_FICHA * (cuatroEnRaya.tamYTablero + 1)); 
        
        PanelPuntuaciones.mostrarTurno(cuatroEnRaya.turnoJugador);
        
        this.setOnMouseClicked((event) -> {
            if(!fichaCayendo && !cuatroEnRaya.finPartida) {
                int columna = (int)(event.getX() / Ficha.TAM_FICHA);
                colocarFicha(columna); 
            }
        });
    }
    
    public void colocarFicha(int columna) {
        Ficha ficha = new Ficha(cuatroEnRaya.turnoJugador);
        ficha.setPosX(columna * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
        ficha.setPosY(Ficha.TAM_FICHA / 2);
        int filaFin = cuatroEnRaya.colocarFicha(columna);
        if(filaFin != -1) {
            this.getChildren().add(ficha);
            animarCaida(ficha, filaFin);
            cuatroEnRaya.mostrarTableroConsola();              
            if(cuatroEnRaya.finPartidaGanador(columna, filaFin)) {
                PanelMensajes.mostrarMensaje("GANADOR JUGADOR: " + cuatroEnRaya.turnoJugador);
            } else if(cuatroEnRaya.finPartidaEmpate()) {
                PanelMensajes.mostrarMensaje("EMPATE");
            } else {
                cuatroEnRaya.cambiarTurnoJugador();
                PanelPuntuaciones.mostrarTurno(cuatroEnRaya.turnoJugador);                
            }          
        } else {
            PanelMensajes.mostrarMensaje("No se puede colocar la ficha");
        }
    }
    
    public void animarCaida(Ficha ficha, int filaFin) {
        fichaCayendo = true;
        timelineFicha = new Timeline(
            new KeyFrame(Duration.seconds(0.017), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {                    
                    if(ficha.posY < Ficha.TAM_FICHA * filaFin + Ficha.TAM_FICHA*1.5) {
                        ficha.moverY(VELOCIDAD_FICHA);
                    } else {
                        timelineFicha.stop();
                        fichaCayendo = false;
                    }
                }        
            })
        );
        timelineFicha.setCycleCount(Timeline.INDEFINITE);
        timelineFicha.play();        
    }    
    
    
}
