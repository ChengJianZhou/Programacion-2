package hl;

public class Casilla {

    public int color;

    public Casilla(){
        this.color = 0;
    }

    public Casilla(int color){
        this.color = color;
    }

    public void cambiarColor(){
        if (this.color == 1){
            this.color = 0;
        } else if(this.color == 0) {
            this.color = 1;
        } else {
            this.color = 2;
        }
    }

    public int color(){
        return this.color;
    }
}
