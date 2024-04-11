public class Tablero {
    private char[][] cuadros;
    private int n;
    
    public Tablero(int n){
        this.n = n;
        cuadros = new char[n][n];
        inicializarTablero();
    }

    public void inicializarTablero(){
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                if ((i + j) % 2 == 0){
                    cuadros[i][j] = 'B';
                } else {
                    cuadros[i][j] = 'N';
                }
            }
        }
    }

    public String toString() {
        String resultado = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultado += cuadros[i][j] + " ";
            }
            resultado += "\n";
        }
        return resultado;
    }

    public int dimencion(){
        return n;
    }

    public boolean esPosicionTablero(int x, int y){
        return x<=n && x>=1 && y<=n && y>=1;
    }

    public boolean esCuadroBlanco(int x, int y){
        if (!esPosicionTablero(x, y)) 
            return false;
        return (x + y)%2 == 0;
    }

    public boolean esCuadroAmenazado(int x, int y, int xReina, int yReina){
        if (!esPosicionTablero(x, y) || !esPosicionTablero(xReina, yReina))
            return false;
        return x == xReina || y == yReina || Math.abs(x - xReina) == Math.abs(y - yReina);
    }

    public void marcarAmenazadas(int xReina, int yReina){
        if (!esPosicionTablero(xReina, yReina))
            System.out.println("La reina esta fuera del tablero");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (esCuadroAmenazado(i, j, xReina, yReina)) {
                    cuadros[i - 1][j - 1] = 'X';
                }
            }
        }
        cuadros[xReina - 1][yReina - 1] = 'Q';
    }
}


