public class Localidad {
    private String nombre;
    private int mujeres;
    private int hombres;

    public Localidad(String nombre, int mujeres, int hombres) {
        this.nombre = nombre;
        this.mujeres = mujeres;
        this.hombres = hombres;
    }

    public Localidad (String Localidad) {
        String[] items = Localidad.split(";");
        String sexo = items[0];
        String municipio = items[2];
        int total = Integer.parseInt(items[4]);

        this.nombre = municipio;
        this.hombres = sexo.equals("Hombres") ? total : 0;
        this.mujeres = sexo.equals("Mujeres") ? total : 0;       
      }

    public String toString() {
        return "Lugar: " + nombre + " Número de mujeres: " + mujeres + " Número de hombres: " + hombres;
    }

    public int poblacion() {
        return mujeres + hombres;
    }

    public String Nombre() {
        return nombre;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localidad h = (Localidad) o;
        return (nombre == h.nombre);
    }

    public static Localidad fusion(Localidad l1, Localidad l2) {
        int mujeres = (l1.mujeres != 0) ? l1.mujeres : l2.mujeres;
        int hombres = (l1.hombres != 0) ? l1.hombres : l2.hombres;
        return new Localidad(l1.nombre, mujeres, hombres);
    }
}
