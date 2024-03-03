package ppss.ejercicio2;



import java.util.Calendar;

public class GestorLlamadasTestable extends GestorLlamadas{

        CalendarioStub cal;

        @Override
        public Calendario getCalendario() {
                return cal;
        }

        public void setCalendario(int hora){
                cal = new CalendarioStub();
                cal.setHora(hora);
        }
}
