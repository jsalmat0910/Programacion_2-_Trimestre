package es.juanramonsalgueromateos.sudoku;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Juan Ramón Salguero Mateos
 */
public class Sudoku_Tablero {
    
    public void crearTablero() {
        //Creación de casillas.
        for(int Ex=1; Ex<500; Ex+=167) {
            for(int Ey=1; Ey<500; Ey+=167) {
                Rectangle casillaExterior = new Rectangle(Ex, Ey, 167, 167);
                casillaExterior.setFill(Color.PAPAYAWHIP);
                casillaExterior.setStroke(Color.BLACK);
                casillaExterior.setStrokeWidth(6);
                //Crea casillas interiores.
                for(float Ix=1; Ix<500; Ix+=55.6){
                    for(float Iy=1; Iy<500; Iy+=55.6) {
                        Rectangle casillaInterior = new Rectangle(Ix, Iy, 55.6, 55.6);
                        casillaInterior.setFill(Color.TRANSPARENT);
                        casillaInterior.setStroke(Color.BLACK);
                        casillaInterior.setStrokeWidth(1);
                    }
                }
            }
        }
    }
}
