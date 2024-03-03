package ppss.ejercicio2;

public class CalendarioStub extends Calendario{

    int hora;
    @Override
    public int getHoraActual() {
        return this.hora;
    }
    public void setHora(int horaT){
        this.hora = horaT;
    }

}
