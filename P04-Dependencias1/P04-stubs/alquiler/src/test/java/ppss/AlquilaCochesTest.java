package ppss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void C2_calculaPrecio_should_return_62_when_7dias_f2trueDTest() {

        //Preparamos los datos
        tipo = TipoCoche.CARAVANA;
        date = LocalDate.of(2024,06,19);
        resE = 62.5f;
        dias = 7;
        servSt.setPrecio(ticketPriceBase);

        //Le aportamos los valores a los dobles como necesitemos en el test
        calSt.setDias(
                new ArrayList<LocalDate>(
                        Arrays.asList(LocalDate.of(2024,06,20),
                                LocalDate.of(2024,06,24))
                ),
                new ArrayList<LocalDate>(){}
        );
        alqCochesT.setPrecio(servSt);
        alqCochesT.setCalendario(calSt);

        // Llamar al método que actualiza los asientos
        resObtenido= assertDoesNotThrow(() -> alqCochesT.calculaPrecio(tipo, date, dias));

        // Verificamos el resultado
        assertEquals(resE, resObtenido.getPrecio_final());

    }

    @Test
    void C3_calculaPrecio_should_return_exception_when_8dias_falseAll_3exceptionDTest() {

        //Preparamos los datos
        tipo = TipoCoche.TURISMO;
        date = LocalDate.of(2024,04,17);
        dias = 8;
        servSt.setPrecio(ticketPriceBase);

        //Le aportamos los valores a los dobles como necesitemos en el test
        calSt.setDias(
                new ArrayList<LocalDate>(){},
                new ArrayList<LocalDate>(
                        Arrays.asList(LocalDate.of(2024,04,18),
                                LocalDate.of(2024,04,21),
                                LocalDate.of(2024,04,22))
                )

        );
        alqCochesT.setPrecio(servSt);
        alqCochesT.setCalendario(calSt);

        // Llamar al método que actualiza los asientos
        MensajeException excepcion;
        excepcion = assertThrows(MensajeException.class, ()->alqCochesT.calculaPrecio(tipo,date,dias));

        // Verificamos el resultado
        assertEquals("Error en dia: 2024-04-18; Error en dia: 2024-04-21; Error en dia: 2024-04-22; ", excepcion.getMessage());
    }
}
