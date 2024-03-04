package ppss.ejercicio1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;



public class GestorLlamadasTest {

    GestorLlamadasTestable gestL;
    int hora;
    int minutos;
    double resE;
    double resObtenido;


    @BeforeEach
    public void setup() {
        gestL= new GestorLlamadasTestable();
    }

    @Test
    void C1_calculaConsumo_should_return_208_when_min_hora_10_15Test() {

        //Preparamos los datos
        minutos = 10;
        hora = 15;
        resE = 208;
        gestL.setHora(hora);

        // Llamar al método que actualiza los asientos
        resObtenido= assertDoesNotThrow(() -> gestL.calculaConsumo(minutos));

        // Verificamos el resultado
        assertEquals(resE, resObtenido);

    }

    @Test
    void C2_calculaConsumo_should_return_105_when_min_hora_10_22Test() {

        //Preparamos los datos
        minutos = 10;
        hora = 22;
        resE = 105;
        gestL.setHora(hora);

        // Llamar al método que actualiza los asientos
        resObtenido= assertDoesNotThrow(() -> gestL.calculaConsumo(minutos));

        // Verificamos el resultado
        assertEquals(resE, resObtenido);

    }

}