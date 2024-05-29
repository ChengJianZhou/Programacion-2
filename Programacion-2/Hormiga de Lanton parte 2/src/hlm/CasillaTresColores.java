package hlm;
import hl.Casilla;
import java.util.Random;

public class CasillaTresColores extends Casilla{
    static final Random r = new Random(31416);
    
    public CasillaTresColores(){
        int aleatorio = r.nextInt(100);
        if (aleatorio < 20) {
            this.color = 1;
        } else if (20 <= aleatorio && aleatorio <= 39){
            this.color = 2;
        } else {
            this.color = 0;
        }
    }
    @Override
    public void cambiarColor() {
        switch (this.color) {
            case 0:
                this.color = 1;
                break;
            case 1:
                this.color = 2;
                break;
            case 2:
                this.color = 0;
                break;
        }
    }
}