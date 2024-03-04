package ppss;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarioStub extends Calendario{

    ArrayList<LocalDate> diasVerdadero;
    ArrayList<LocalDate> diasExcepcion;

    public void setDias(ArrayList<LocalDate> dV, ArrayList<LocalDate> dE){
        diasExcepcion = dE;
        diasVerdadero = dV;
    }

    @Override
    public boolean es_festivo(LocalDate date) throws CalendarioException{

        if(diasVerdadero.contains(date))
            return true;
        if(diasExcepcion.contains(date))
            throw new CalendarioException();
        return false;
    }
}
