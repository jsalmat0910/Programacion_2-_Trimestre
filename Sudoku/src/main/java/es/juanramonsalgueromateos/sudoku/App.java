package es.juanramonsalgueromateos.sudoku;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Pane pantalla = new Pane();
        var scene = new Scene(pantalla, 502, 502);
        stage.setScene(scene);
        stage.show();
        
        Sudoku_Tablero sudokuTablero = new Sudoku_Tablero();
        
    }

    public static void main(String[] args) {
        launch();
    }

}