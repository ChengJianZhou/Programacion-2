public class TestSim {
    public static void main(String[] ags) {
        Sim lucia = new Sim("Lucía");
        assert lucia.haciendo() == Sim.Actividad.DORMIR;
        lucia.simular(1);
        assert lucia.haciendo() == Sim.Actividad.DORMIR;
        assert "Lucía".equals(lucia.nombre());
        lucia.simular(8);
        
        Sim marga = new Sim("Margarita");
        lucia.hacerAmigo(marga);
        assert "Margarita".equals(marga.nombre());
        assert lucia.amigo().nombre().equals("Margarita");
        System.out.println(lucia.haciendo());

        Sim s = new Sim("Luis");
        assert s.haciendo() == Sim.Actividad.DORMIR;
        s.simular(8);
        /* System.out.println(s.estadistica(Sim.Actividad.JUGAR)); */
        assert s.haciendo() == Sim.Actividad.COMER;
        s.simular(2);
        assert s.haciendo() == Sim.Actividad.ESTUDIAR;
        s.simular(6);
        assert s.haciendo() == Sim.Actividad.JUGAR;    
        s.simular(8);
        assert s.horas() == 24;
        
        // ¿Cuántas horas ha estado comiendo?

        assert s.estadistica(Sim.Actividad.DORMIR) == 8;
        assert s.estadistica(Sim.Actividad.COMER) == 2;
        assert s.estadistica(Sim.Actividad.ESTUDIAR) == 6;
        assert s.estadistica(Sim.Actividad.JUGAR) == 8;
    }
}
