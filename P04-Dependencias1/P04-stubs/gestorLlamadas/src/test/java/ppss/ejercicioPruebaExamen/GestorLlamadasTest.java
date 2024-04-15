package ppss.ejercicioPruebaExamen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class GestorLlamadasTest {

    GestorLlamadas gs;
    CalendarioStub stub;
    int hora;
    int minutos;
    double resE;
    double resObtenido;


    @BeforeEach
    public void setup() {
        gs= new GestorLlamadas();
        stub = new CalendarioStub();
    }

    @Test
    void C1_calculaConsumo_should_return_208_when_min_hora_10_15Test() {

        //Preparamos los datos
        minutos = 10;
        hora = 15;
        resE = 208;
        stub.setHora(hora);
        gs.setCalendario(stub);

        // Llamar al método que actualiza los asientos
        resObtenido= gs.calculaConsumo(minutos);

        // Verificamos el resultado
        assertEquals(resE, resObtenido);

    }

}