import java.util.Calendar;

public class Fecha {
    private int dia;
    private int mes;
    private int año;

    // Constructor que recibe dia, mes y año como parámetros
    public Fecha(int dia, int mes, int año) {
        if (esCorrecta(dia, mes, año)) {
            this.dia = dia;
            this.mes = mes;
            this.año = año;
        } else {
            throw new IllegalArgumentException("Fecha no válida");
        }
    }

    // Constructor que recibe una cadena en formato de fecha (dd/mm/aaaa) como parámetro
    public Fecha(String fecha) {
        String[] partes = fecha.split("/");
        if (partes.length != 3) {
            throw new IllegalArgumentException("Formato de fecha incorrecto");
        }
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int año = Integer.parseInt(partes[2]);
        if (esCorrecta(dia, mes, año)) {
            this.dia = dia;
            this.mes = mes;
            this.año = año;
        } else {
            throw new IllegalArgumentException("Fecha no válida");
        }
    }

    // Método para verificar si una fecha es válida
    private boolean esCorrecta(int dia, int mes, int año) {
        return mes >= 1 && mes <= 12 && dia >= 1 && dia <= diasDelMes(mes, año);
    }

    // Método para obtener el número de días de un mes en un año dado
    private int diasDelMes(int mes, int año) {
        switch (mes) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return esBisiesto(año) ? 29 : 28;
            default:
                return 31;
        }
    }

    // Método para verificar si un año es bisiesto
    private boolean esBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }

    // Método para obtener la representación en cadena de la fecha (dd/mm/aaaa)
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, año);
    }

    // Método para verificar si dos fechas son iguales
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fecha) {
            Fecha otra = (Fecha) obj;
            return dia == otra.dia && mes == otra.mes && año == otra.año;
        }
        return false;
    }

    // Método para verificar si una fecha es menor que otra fecha
    public boolean esMenor(Fecha otra) {
        if (año < otra.año) {
            return true;
        } else if (año == otra.año && mes < otra.mes) {
            return true;
        } else if (año == otra.año && mes == otra.mes && dia < otra.dia) {
            return true;
        }
        return false;
    }

    // Método para obtener la fecha siguiente
    public Fecha siguiente() {
        int nuevoDia = dia + 1;
        int nuevoMes = mes;
        int nuevoAño = año;

        if (nuevoDia > diasDelMes(nuevoMes, nuevoAño)) {
            nuevoDia = 1;
            nuevoMes++;
            if (nuevoMes > 12) {
                nuevoMes = 1;
                nuevoAño++;
            }
        }

        return new Fecha(nuevoDia, nuevoMes, nuevoAño);
    }

    // Método para sumar una cantidad de días a la fecha actual
    public Fecha suma(int dias) {
        Fecha nuevaFecha = this;
        for (int i = 0; i < dias; i++) {
            nuevaFecha = nuevaFecha.siguiente();
        }
        return nuevaFecha;
    }

    public int aDias() {
        int totalDias = 0;
        
        // Suma los días totales de los años completos
        for (int i = 1; i < año; i++) {
            totalDias += esBisiesto(i) ? 366 : 365;
        }
        
        // Suma los días de los meses completos del año actual
        for (int i = 1; i < mes; i++) {
            totalDias += diasDelMes(i, año);
        }
        
        // Suma los días del mes actual
        totalDias += dia;
        
        return totalDias;
    }
    
    // Método estático que devuelve la fecha actual del sistema
    public static Fecha ahora() {
        Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1; // Los meses en Calendar van de 0 a 11, por lo que se suma 1
        int año = calendario.get(Calendar.YEAR);
        return new Fecha(dia, mes, año);
    }

    // Método para obtener la diferencia en días entre dos fechas
    public int diferencia(Fecha otra) {
        int diasFechaActual = this.aDias();
        int diasOtraFecha = otra.aDias();
        return Math.abs(diasFechaActual - diasOtraFecha);
    }
    
}