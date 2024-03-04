package ppss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

public class AlquilaCochesTest {

        AlquilaCochesTestable alqCochesT;
        ServicioStub servSt;
        CalendarioStub calSt;
        TipoCoche tipo;
        LocalDate date;
        int dias;
        float resE;
        Ticket resObtenido;
        ArrayList<LocalDate> diasVerdadero;
        ArrayList<LocalDate> diasExcepcion;
        float ticketPriceBase = 10.0f;


        @BeforeEach
        public void setup() {
            alqCochesT= new AlquilaCochesTestable();
            servSt = new ServicioStub();
            calSt = new CalendarioStub();
        }

        @Test
        void C1_calculaPrecio_should_return_75_when_10dias_Turismo_falseDTest() {

            //Preparamos los datos
            tipo = TipoCoche.TURISMO;
            date = LocalDate.of(2024,05,18);
            resE = 75;
            dias = 10;
            servSt.setPrecio(ticketPriceBase);

            //Le aportamos los valores a los dobles como necesitemos en el test
            calSt.setDias(new ArrayList<LocalDate>(){}, new ArrayList<LocalDate>(){});
            alqCochesT.setPrecio(servSt);
            alqCochesT.setCalendario(calSt);

            // Llamar al método que actualiza los asientos
            resObtenido= assertDoesNotThrow(() -> alqCochesT.calculaPrecio(tipo, date, dias));

            // Verificamos el resultado
            assertEquals(resE, resObtenido.getPrecio_final());

        }
}
