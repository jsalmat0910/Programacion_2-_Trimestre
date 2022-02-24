package es.juanramonsalgueromateos.sudoku;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.*;
import java.util.*;
import java.lang.*;


/**
 *
 * @author Juan Ramón Salguero Mateos
 */
public class App {

    //Propiedades.
    public static int nivel = 3;

    //Metodo para cargar el juego.
    public static int[][] cargarJuego(int nivel) {
        Random azar = new Random();
        //int fila = azar.nextInt(9);
        //int columna = azar.nextInt(9);

        int[][] matriz = new int[9][9];
        switch (nivel) {

            case 1:

                matriz[0][0] = 7;
                matriz[0][4] = 5;
                matriz[0][6] = 4;
                matriz[1][0] = 4;
                matriz[1][3] = 1;
                matriz[1][4] = 9;
                matriz[1][6] = 6;
                matriz[1][7] = 2;
                matriz[1][8] = 7;
                matriz[2][2] = 6;
                matriz[2][8] = 9;
                matriz[3][0] = 9;
                matriz[3][2] = 3;
                matriz[3][6] = 8;
                matriz[4][3] = 4;
                matriz[4][5] = 3;
                matriz[5][2] = 8;
                matriz[5][6] = 5;
                matriz[5][8] = 2;
                matriz[6][0] = 5;
                matriz[6][6] = 2;
                matriz[7][0] = 2;
                matriz[7][1] = 9;
                matriz[7][2] = 1;
                matriz[7][4] = 4;
                matriz[7][5] = 7;
                matriz[7][8] = 8;
                matriz[8][2] = 7;
                matriz[8][4] = 1;
                matriz[8][8] = 5;

                break;

            case 2:


                matriz[0][2] = 9;
                matriz[0][5] = 8;
                matriz[0][6] = 5;
                matriz[0][7] = 4;
                matriz[1][8] = 7;
                matriz[2][1] = 5;
                matriz[2][2] = 4;
                matriz[2][4] = 9;
                matriz[2][6] = 1;
                matriz[3][5] = 6;
                matriz[3][6] = 3;
                matriz[3][7] = 2;
                matriz[4][1] = 8;
                matriz[4][2] = 2;
                matriz[4][6] = 4;
                matriz[4][7] = 1;
                matriz[5][1] = 3;
                matriz[5][2] = 5;
                matriz[5][3] = 2;
                matriz[6][2] = 7;
                matriz[6][4] = 3;
                matriz[6][6] = 2;
                matriz[6][7] = 5;
                matriz[7][0] = 9;
                matriz[8][1] = 4;
                matriz[8][2] = 3;
                matriz[8][3] = 8;
                matriz[8][7] = 9;

                break;
            
            case 3:
                for(int f=0; f <9; f++){
                    for(int c=0; c <9; c++) {
                        int valor = azar.nextInt(9);
                        matriz[f][c] = valor;
                        if(existeFila(valor, f, matriz)) {
                            if (existeColumna(valor, c, matriz)) {
                                if (existeCaja(valor, f, c, matriz)) {
                                    
                                }
                            }
                        }  
                    }
                }
                break;
        }
        return matriz;
    }

    //Metodo para no sobreescribir valores en el juego.
    public static boolean origen(int fila, int columna, int[][] matriz) {

        boolean resultado = false;
        if (matriz[fila][columna] != 0) {
            resultado = true;
        }

        return resultado;

    }

    //Metodo que detecta si el juego fue terminado.
    public static boolean terminado(int[][] matriz) {

        boolean resultado = true;

        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[0].length; c++) {
                if (matriz[f][c] == 0) {
                    resultado = false;
                }
            }
        }


        return resultado;

    }

    //Metodo que imprime un mensaje con borde.
    public static void mensaje(String mensaje) {
        //Cabecera
        System.out.println(" ");
        System.out.print("Resultado: ");
        //Cuerpo.
        System.out.print(mensaje);
        System.out.println(" ");
        System.out.println(" ");
    }

    //Metodo que imprime el vector.
    public static void imprimeVector(int[][] matriz) {


        System.out.println("  -----------  -----------  -----------  ");

        for (int f = 0; f < matriz.length; f++) {

            System.out.print(" | ");

            for (int c = 0; c < matriz.length; c++) {

                if (matriz[f][c] != 0) {
                    System.out.print(matriz[f][c]);
                } else {
                    System.out.print(" ");
                }

                if (origen(f, c, cargarJuego(nivel))) {
                    System.out.print(".");
                } else {
                    System.out.print(" ");
                }

                if (c == 2 || c == 5) {
                    System.out.print("|| ");
                } else {
                    System.out.print("| ");
                }

            }
            System.out.println();
            if (f != 2 && f != 5) {
                System.out.print("  -----------  -----------  -----------  ");
            } else {
                System.out.print("  :::::::::::::::::::::::::::::::::::::: ");
            }
            System.out.println();
        }
    }

    //Metodo para comprobar filas.
    public static boolean existeFila(int numero, int fila, int[][] matriz) {

        boolean resultado = false;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[(fila)][i] == numero) {
                resultado = true;
                break;
            }
        }
        return resultado;

    }

    //Metodo para comprobar columnas.
    public static boolean existeColumna(int numero, int columna, int[][] matriz) {

        boolean resultado = false;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][(columna)] == numero) {
                resultado = true;
                break;
            }
        }

        //Comprobamos si es 0.
        if (numero == 0) {
            resultado = false;
        }

        return resultado;

    }

    // Metodo para comprobar indices.
    public static boolean comprobarIndice(int indice) {

        if (indice > 0 && indice < 10) {
            return true;
        } else {
            return false;
        }

    }

    // Metodo para comprobar los valores.
    public static boolean comprobarValor(int valor) {

        if (valor >= 0 && valor < 10) {
            return true;
        } else {
            return false;
        }

    }

    //Metodo para comprobar las cajas.
    public static boolean existeCaja(int valor, int fila, int columna, int[][] matriz) {

        //Variables.
        int minimo_fila;
        int maximo_fila;
        int minimo_columna;
        int maximo_columna;
        boolean resultado = false;

        //Determinamos las filas de la caja.
        if (fila > 0 && fila < 4) {
            minimo_fila = 0;
            maximo_fila = 2;
        } else if (fila > 3 && fila < 7) {
            minimo_fila = 3;
            maximo_fila = 5;
        } else {
            minimo_fila = 6;
            maximo_fila = 8;
        }

        //Determinamos las columnas de la caja.
        if (columna > 0 && columna < 4) {
            minimo_columna = 0;
            maximo_columna = 2;
        } else if (columna > 3 && columna < 7) {
            minimo_columna = 3;
            maximo_columna = 5;
        } else {
            minimo_columna = 6;
            maximo_columna = 8;
        }

        //Recorremos el rango de la caja, y  buscamos el valor.
        for (int f = minimo_fila; f <= maximo_fila; f++) {
            for (int c = minimo_columna; c <= maximo_columna; c++) {
                if (matriz[f][c] == valor) {
                    resultado = true;
                    break;

                }
            }
        }


        //Comprobamos si es 0.
        if (valor == 0) {
            resultado = false;
        }

        //Regresamos el valor booleano(Azar).
        return resultado;



    }

    //Metodo principal.
    public static void main(String[] args) throws Exception {
        
        //Variables.
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int[][] sudoku = new int[9][9];
        int fila = 0;
        int columna = 0;
        int valor = 0;

        //Cargamos el juego.
        sudoku = cargarJuego(nivel);

        while (true) {

            //Imprimimos el vector.
            imprimeVector(sudoku);

            //Pedimos los datos.
            System.out.println("Inserte las coordenadas (fila/columna/valor): ");

            //Fila.
            System.out.println("[fila]: ");
            fila = Integer.parseInt(teclado.readLine());

            //Columna.
            System.out.println("[columna]: ");
            columna = Integer.parseInt(teclado.readLine());

            //Valor.
            System.out.println("[valor]: ");
            valor = Integer.parseInt(teclado.readLine());

            //Comprobamos si la fila esta en el rango.
            if (!comprobarIndice(fila)) {
                mensaje("El valor de la fila no es correcto..");
            } //Comrpobamos si la columna esta en el rango.
            else if (!comprobarIndice(columna)) {
                mensaje("El valor de la columna no es correcto.");
            } //Comprobamos que el valor esta en el rango.
            else if (!comprobarValor(valor)) {
                mensaje("El valor introducido no es valido..");
            } //Comprobamos que se use casillas disponibles.
            else if (origen((fila - 1), (columna - 1), cargarJuego(nivel))) {
                mensaje("Ese valor es predeterminado del juego...");
            } //Comprueba que no se repite el valor en la fila.
            else if (existeFila(valor, fila, sudoku)) {
                mensaje("[X] El valor " + valor + " ya ha sido usado en la fila..");
            } //Comprueba que no se repite el valor en la columna.
            else if (existeColumna(valor, columna, sudoku)) {
                mensaje("[X] El valor " + valor + " ya ha sido usado en la columna..");
            } //Comprueba que el valor no existe en la caja.
            else if (existeCaja(valor, fila, columna, sudoku)) {
                mensaje("[X] El valor ya existe en la caja..");
            } //Introducimos el valor a la matriz.
            else {
                sudoku[(fila - 1)][(columna - 1)] = valor;
                mensaje("[" + fila + "," + columna + "]=" + valor + " Correcto.");
            }


            //Comprueba si se terminó el juego.
            if (terminado(sudoku)) {
                mensaje("FELICIDADES!!!! HAS TERMINADO EL JUEGO!!");
                imprimeVector(sudoku);
                System.out.println("Presiona una tecla para continuar en el siguiente nivel..");
                teclado.readLine();

                //Aumentamos nivel de juego.
                nivel++;
                sudoku = cargarJuego(nivel);
                mensaje("SUDOKU NIVEL " + nivel);
            }


        }

    }
}