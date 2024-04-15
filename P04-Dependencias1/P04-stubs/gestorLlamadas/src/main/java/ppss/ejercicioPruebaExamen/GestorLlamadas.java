package ppss.ejercicioPruebaExamen;

public class GestorLlamadas {
    private static final double TARIFA_NOCTURNA=10.5;
    private static final double TARIFA_DIURNA=20.8;
    private Calendario calendario;
    public void setCalendario(Calendario cal){
        this.calendario = cal;
    }
    public double calculaConsumo(int minutos) {
        //Tendremos que refactorizar
        //Calendario c = new Calendario();
        //MEDIANTE SETTER
        Calendario c = calendario;
        int hora = c.getHoraActual();
        if(hora < 8 || hora > 20) {
            return minutos * TARIFA_NOCTURNA;
        } else {
            return minutos * TARIFA_DIURNA;
        }
    }
}




