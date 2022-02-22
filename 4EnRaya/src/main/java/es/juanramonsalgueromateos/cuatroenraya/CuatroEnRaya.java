package es.javiergarciaescobedo.cuatroenraya;

public class CuatroEnRaya {

    short tamXTablero;
    short tamYTablero;
    char[][] tablero;
    
    static final char JUGADOR1 = '1';
    static final char JUGADOR2 = '2';
    final char VACIO = '.';
    char turnoJugador = JUGADOR1;
    boolean finPartida = false;
    
    // Método constructor
    public CuatroEnRaya() {  
        tamXTablero = 7;
        tamYTablero = 6;
        tablero = new char[tamXTablero][tamYTablero];
        for(int x=0; x<tamXTablero; x++) {
            for(int y=0; y<tamYTablero; y++) {
                tablero[x][y] = VACIO;
            }
        }
    }   
    
    public CuatroEnRaya(short tamX, short tamY) {  
        tamXTablero = tamX;
        tamYTablero = tamY;
        tablero = new char[tamXTablero][tamYTablero];
        for(int x=0; x<tamXTablero; x++) {
            for(int y=0; y<tamYTablero; y++) {
                tablero[x][y] = VACIO;
            }
        }
    } 
    
    public void mostrarTableroConsola() {
        for(int y=0; y<tamYTablero; y++) {
            for(int x=0; x<tamXTablero; x++) {
                System.out.print(tablero[x][y]);
            }
            System.out.println();
        }    
        System.out.println();
    }
    
    public int colocarFicha(int columna) {        
        if(columna >= 0 && columna < tamXTablero) {
            int fila = this.buscarFila(columna);
            if(fila != -1) {
                tablero[columna][fila] = turnoJugador;   
            }
            return fila;
        } else {
            return -1;
        }        
    }
    
    /**
     *
     * @param columna
     * @return Fila en la que se debe colocar la ficha, 
     *          ó -1 si no se puede colocar
     */
    public int buscarFila(int columna) {
        int fila = 0;
        while(fila < tamYTablero && tablero[columna][fila] == VACIO) {
            fila++;
        }
        return fila-1;
    }
    
    public boolean comprobar4EnRayaHorizontal(int columna, int fila, char jugador) {
        int contador = 0;
        // Recuento a la izquierda
        int pos = 1;
        while(columna-pos >= 0 && tablero[columna-pos][fila]==jugador) {
            contador++;
            pos++;
        }
        // Recuento a la derecha
        pos = 1;
        while(columna+pos < tamXTablero && tablero[columna+pos][fila]==jugador) {
            contador++;
            pos++;
        }
        System.out.println("Contador horizontal: " + contador);
        if(contador >= 3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean comprobar4EnRayaVertical(int columna, int fila, char jugador) {
        int contador = 0;
        // Recuento hacia arriba
        int pos = 1;
        while(fila-pos >= 0 && tablero[columna][fila-pos]==jugador) {
            contador++;
            pos++;
        }
        // Recuento hacia abajo
        pos = 1;
        while(fila+pos < tamYTablero && tablero[columna][fila+pos]==jugador) {
            contador++;
            pos++;
        }
        System.out.println("Contador vertical: " + contador);
        if(contador >= 3) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean comprobar4EnRayaDiagonal1(int columna, int fila, char jugador) {
        int contador = 0;
        // Recuento hacia arriba
        int pos = 1;
        while(fila-pos >= 0 && columna-pos >= 0 && tablero[columna-pos][fila-pos]==jugador) {
            contador++;
            pos++;
        }
        // Recuento hacia abajo
        pos = 1;
        while(fila+pos < tamYTablero && columna+pos < tamXTablero && tablero[columna+pos][fila+pos]==jugador) {
            contador++;
            pos++;
        }
        System.out.println("Contador diagonal 1: " + contador);
        if(contador >= 3) {
            return true;
        } else {
            return false;
        }
    }    

    public boolean comprobar4EnRayaDiagonal2(int columna, int fila, char jugador) {
        int contador = 0;
        // Recuento hacia arriba
        int pos = 1;
        while(fila-pos >= 0 && columna+pos < tamXTablero && tablero[columna+pos][fila-pos]==jugador) {
            contador++;
            pos++;
        }
        // Recuento hacia abajo
        pos = 1;
        while(fila+pos < tamYTablero && columna-pos >= 0 && tablero[columna-pos][fila+pos]==jugador) {
            contador++;
            pos++;
        }
        System.out.println("Contador diagonal 2: " + contador);
        if(contador >= 3) {
            return true;
        } else {
            return false;
        }
    }    
    
    public void cambiarTurnoJugador() {
        if(turnoJugador == JUGADOR1) {
            turnoJugador = JUGADOR2;
        } else {
            turnoJugador = JUGADOR1;
        }
    }
    
    public boolean finPartidaEmpate() {
        for(int x=0; x<tamXTablero; x++) {
            for(int y=0; y<tamYTablero; y++) {
                if(tablero[x][y] == VACIO) {
                    return false;
                }
            }
        }
        finPartida = true;
        return true;        
    }
    
    public boolean finPartidaGanador(int columna, int fila) {
        if(comprobar4EnRayaHorizontal(columna, fila, turnoJugador) ||
                comprobar4EnRayaVertical(columna, fila, turnoJugador) ||
                comprobar4EnRayaDiagonal1(columna, fila, turnoJugador)||        
                comprobar4EnRayaDiagonal2(columna, fila, turnoJugador) ) {
            finPartida = true;
            return true;
        } else {
            return false;
        }
    }
}
