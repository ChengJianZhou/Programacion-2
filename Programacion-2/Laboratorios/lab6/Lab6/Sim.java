public class Sim {
    public static enum Actividad {
        DORMIR, COMER, ESTUDIAR, JUGAR
    }

    private String nombre;
    private Actividad haciendo;
    private int horas;
    private int horasDORMIR;
    private int horasCOMER;
    private int horasESTUDIAR;
    private int horasJUGAR;
    private Sim amigo;

    public int horas(){
        return horas;
    }
    

    public Sim(String nombre) {
        this.nombre = nombre;
        haciendo = Actividad.DORMIR;
        horas = 0;
        horasDORMIR = 0;
        horasCOMER = 0;
        horasESTUDIAR = 0;
        horasJUGAR = 0;
        amigo = null;
    }

    public void simular(int tiempoHoras) {
        Actividad siguiente = null;

        horas += tiempoHoras;
        if (tiempoHoras > 24) {
            
            int dias = horas / 24;  
            horasDORMIR += dias * 8;
            horasCOMER += dias * 2;
            horasESTUDIAR += dias * 6;
            horasJUGAR += dias * 8;
            int horas2 = horas;
            horas = horas - (horas % 24);
            simular(horas2 % 24);
        } else {
            
            switch (haciendo) {
                case DORMIR:
                    if (horas % 24 < 8) {
                        horasDORMIR += tiempoHoras;
                        siguiente = Actividad.DORMIR;
                    } else {
                        horasDORMIR += 8;
                        siguiente = Actividad.COMER;
                    }
                    break;
                case COMER:
                    if (horas % 24 >= 8 && horas % 24 < 10) {
                        horasCOMER += (horas - 8);
                        siguiente =Actividad.COMER;
                    } else if (horas % 24 >= 10) {
                        horasCOMER += 2;
                        siguiente = Actividad.ESTUDIAR;
                    } else {
                        horasCOMER += 0;
                        siguiente = Actividad.COMER;
                    }
                    break;
                case ESTUDIAR:
                    if (horas % 24 >= 10 && horas % 24 < 16) {
                        siguiente = Actividad.ESTUDIAR;
                        horasESTUDIAR += (tiempoHoras - 10);
                    } else if (horas >= 16) {
                        siguiente = Actividad.JUGAR;
                        horasESTUDIAR += 6;
                    } else {
                        siguiente = Actividad.JUGAR;
                        horasESTUDIAR += 0;
                    }
                    break;
                case JUGAR:
                    if (horas % 24 >= 16 && horas % 24 < 24) {
                        siguiente = Actividad.JUGAR;
                        horasJUGAR += (tiempoHoras - 16);
                    } else if (horas >= 24) {
                        siguiente = Actividad.JUGAR;
                        horasJUGAR += 8;
                    } else {
                        siguiente = Actividad.DORMIR;
                        horasJUGAR += 0;
                    }
                    break;

                default:
                    break;
            }
        }
        haciendo = siguiente;

    }

    public void hacerAmigo(Sim amigo) {
        this.amigo = amigo;
    }

    public String nombre() {
        return this.nombre;
    }

    public Actividad haciendo() {
        return this.haciendo;
    }

    public int estadistica(Actividad a) {
        switch (a) {
            case COMER:
                return horasCOMER;
            case DORMIR:
                return horasDORMIR;
            case ESTUDIAR:
                return horasESTUDIAR;
            case JUGAR:
                return horasJUGAR;
            default:
                return 0;
        }

    }

    public Sim amigo() {
        return this.amigo;
    }
}