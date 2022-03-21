package es.juanramonsalgueromateos.sudoku;

import javafx.stage.Stage;
import java.io.*;
import java.lang.*;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


/**
 *
 * @author Juan Ramón Salguero Mateos
 */
public class App extends Application{
    
    // Random para elegir aleatoriamente el nivel.
    Random azar= new Random();
    
    // Insertación del codigo de la lógica del juego.
    Sudoku_Codigo codigo = new Sudoku_Codigo();
    
    // Insertación del codigo de la gráfica del juego.
    Sudoku_Tablero tablero = new Sudoku_Tablero();
    
    @Override
    public void start (Stage primaryStage) throws IOException {
        //System.out.println(codigo.nivel);
        
        //Variables del juego.
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int[][] sudoku = new int[9][9];
        int fila = 0;
        int columna = 0;
        int valor = 0;
        short tamPantallaX = 600;
        short tamPantallaY = 600;
    
        // Creacion de pantalla del juego.
        //Pane pantalla = new Pane();
        //Scene scene = new Scene(pantalla, tamPantallaX, tamPantallaY, Color.BLACK);
        //primaryStage.setTitle("Sudoku");
        //primaryStage.setScene(scene);
        //primaryStage.show();
        
        //Cargamos el juego.
        sudoku = codigo.cargarJuego(codigo.nivel);

        while (true) {
            
            //Imprimimos el vector.
            codigo.imprimeVector(sudoku);
            
            
            //Pedimos los datos.
            System.out.println("Inserte las coordenadas (fila/columna/valor): ");

            //Introducir Fila.
            System.out.println("[fila]: ");
            fila = Integer.parseInt(teclado.readLine());

            //Introducir Columna.
            System.out.println("[columna]: ");
            columna = Integer.parseInt(teclado.readLine());

            //Introducir Valor.
            System.out.println("[valor]: ");
            valor = Integer.parseInt(teclado.readLine());

            //Comprobamos si la fila esta en el rango.
            if (!codigo.comprobarIndice(fila)) {
                codigo.mensaje("El valor de la fila no es correcto..");
            } //Comrpobamos si la columna esta en el rango.
            else if (!codigo.comprobarIndice(columna)) {
                codigo.mensaje("El valor de la columna no es correcto.");
            } //Comprobamos que el valor esta en el rango.
            else if (!codigo.comprobarValor(valor)) {
                codigo.mensaje("El valor introducido no es valido..");
            } //Comprobamos que se use casillas disponibles.
            else if (codigo.origen((fila - 1), (columna - 1), codigo.cargarJuego(codigo.nivel))) {
                codigo.mensaje("Ese valor es predeterminado del juego...");
            } //Comprueba que no se repite el valor en la fila.
            else if (codigo.existeFila(valor, fila, sudoku)) {
                codigo.mensaje("[X] El valor " + valor + " ya ha sido usado en la fila..");
            } //Comprueba que no se repite el valor en la columna.
            else if (codigo.existeColumna(valor, columna, sudoku)) {
                codigo.mensaje("[X] El valor " + valor + " ya ha sido usado en la columna..");
            } //Comprueba que el valor no existe en la caja.
            else if (codigo.existeCaja(valor, fila, columna, sudoku)) {
                codigo.mensaje("[X] El valor ya existe en la caja..");
            } //Introducimos el valor a la matriz.
            else {
                sudoku[(fila - 1)][(columna - 1)] = valor;
                codigo.mensaje("[" + fila + "," + columna + "]=" + valor + " Correcto.");
            }


            //Comprueba si se terminó el juego y se reinicia con un tablero nuevo.
            if (codigo.terminado(sudoku)) {
                codigo.mensaje("FELICIDADES!!!! HAS TERMINADO EL JUEGO!!");
                codigo.imprimeVector(sudoku);
                System.out.println("Presiona una tecla para continuar en el siguiente nivel..");
                teclado.readLine();

                //realizamos un aleatorio del nivel de juego.
                codigo.nivel = azar.nextInt(3);
                sudoku = codigo.cargarJuego(codigo.nivel);
                codigo.mensaje("SUDOKU NIVEL " + codigo.nivel);
            }
        }
    }
    
    public static void main(String[] args){
        launch();
    }
}