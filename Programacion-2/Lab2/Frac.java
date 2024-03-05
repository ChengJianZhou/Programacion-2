/**
 * Frac
 * Autor: ChengJian Zhou 
 */
public class Frac {
    private int numerador;
    private int denominador;

    public Frac(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
        
    }

    public Frac(int numerador){
        this.numerador = numerador;
        this.denominador = 1;
    }
    
    public void sum(Frac otra) {
        int nuevodenominador = this.denominador * otra.denominador;
        int nuevonumerador = (this.numerador * otra.denominador) + (this.denominador * otra.numerador);
        
        this.denominador = nuevodenominador;
        this.numerador = nuevonumerador;

    }

    public void res(Frac otra) {
        int nuevodenominador = this.denominador * otra.denominador;
        int nuevonumerador = (this.numerador * otra.denominador) - (this.denominador * otra.numerador);
        
        this.denominador = nuevodenominador;
        this.numerador = nuevonumerador;

    }

    public void mul(Frac otra) {
        int nuevodenominador = this.denominador * otra.denominador;
        int nuevonumerador = this.numerador * otra.numerador;
        
        this.denominador = nuevodenominador;
        this.numerador = nuevonumerador;

    }

    public void div(Frac otra) {
        int nuevodenominador = this.denominador * otra.numerador;
        int nuevonumerador = this.numerador * otra.denominador;
        
        this.denominador = nuevodenominador;
        this.numerador = nuevonumerador;

    }

    public void equals(Frac otra) {
        System.out.println(this.numerador * otra.denominador == this.denominador * otra.numerador);
    }
    
    public void sim() {
        int negativo = 1;
        if (this.denominador < 0 && this.numerador >= 0) { // Asegurar que el denominador sea positivo
            this.denominador *= -1;
            negativo = -1;
        }

        if (this.numerador < 0 && this.denominador > 0) { // Asegurar que el numerador sea positivo
            this.numerador *= -1;
            negativo = -1;
        }

        for (int i = 1; (i <= this.numerador && i <= this.denominador) || (this.numerador % i == 0 && this.denominador % i == 0); i++) {

            int a = i;
            while(this.numerador % a == 0 && this.denominador % a == 0) {
                this.numerador = this.numerador / i;
                this.denominador = this.denominador / i;
                a++;
            }
        }
        this.numerador = this.numerador * negativo;
    }

    public String toString() {
        return numerador + " / " + denominador;
    }

    public float val() {
        return (float) this.numerador / this.denominador;
    }     
}