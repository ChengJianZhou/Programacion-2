/** 
 * Autor: ChengJian Zhou 
 * 
*/

public class Castillos {
    public static void main(String[] args) {
        Frac castillo;
        castillo = new Frac(3, 5);
        castillo.res(new Frac(1, 4));
        castillo.sum(new Frac(1, 10));
        castillo.mul(new Frac(3, 2));
        castillo.res(new Frac(1, 5));
        Frac divisor;
        divisor = new Frac(2, 6);
        divisor.sum(new Frac(1, 3));
        divisor.res(new Frac(6, 4));
        divisor.div(new Frac(2, 3));
        divisor.sum(new Frac(1, 6));
        castillo.div(divisor);
        System.out.println(castillo);
        castillo.sim();
        System.out.println(castillo);
        Frac entero =  new Frac(-42);
        System.out.println(entero);
        castillo.equals(entero);
        System.out.println(castillo.val());
    }
}