package ppss.ejercicio1;

import java.util.Calendar;

public class GestorLlamadasTestable extends GestorLlamadas{

        int hora;
        @Override
        public int getHoraActual() {
                return this.hora;
        }

        public void setHora(int horaT){
                this.hora = horaT;
        }
}
