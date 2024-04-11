import java.util.ArrayList;
import java.util.List;

public class Comunidad {
    private List<Localidad> ldloc;

    public Comunidad() {
        ldloc = new ArrayList<>();
    }

    public void add(Localidad loc) {
        ldloc.add(loc);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Localidad loc : ldloc) {
            sb.append(loc.toString()).append("\n");
        }
        return sb.toString();
    }

    public String nombresLocalidades() {
        StringBuilder nombres = new StringBuilder();
        for (Localidad loc : ldloc) {
            nombres.append(loc.Nombre()).append("\n");
        }
        return nombres.toString();
    }

    public int posicion(String nombre) {
        for (int i = 0; i < ldloc.size(); i++) {
            if (ldloc.get(i).Nombre().equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public int poblacion(String nombre) {
        for (Localidad loc : ldloc) {
            if (loc.Nombre().equals(nombre)) {
                return loc.poblacion();
            }
        }
        return -1;
    }

    public int poblacionConjunta(List<String> locs) {
        int poblacionTotal = 0;
        for (String nombre : locs) {
            for (Localidad loc : ldloc) {
                if (loc.Nombre().equals(nombre)) {
                    poblacionTotal += loc.poblacion();
                    break;
                }
            }
        }
        return poblacionTotal;
    }
}
