package ppss.ejercicio2;



import java.util.Calendar;

public class GestorLlamadasTestable extends GestorLlamadas{

        private Calendario cal;

        @Override
        public Calendario getCalendario() {
                return cal;
        }

        public void setCalendario(Calendario cl){
                cal = cl;
        }
}
