package ppss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CineTest {

    boolean [] asientos;
    boolean [] asientosEsperados;
    int solicitados;
    boolean salidaEsperada;
    boolean salidaObtenida;
    Cine cin;

    @BeforeEach
    public void setup() {
        cin= new Cine();
    }

    @Test
    void C1_reservaButacas_should_return_Exception_when_fila_empty_and_want_3test() {
        //Preparamos los datos
        solicitados = 3;
        asientos = new boolean[]{};

        // Llamar al método que actualiza los asientos
        ButacasException exception = assertThrows(ButacasException.class, () ->cin.reservaButacas(asientos, solicitados));

        // Verificamos el resultado
        assertEquals("No se puede procesar la solicitud", exception.getMessage());
    }

    @Test
    void C2_reservaButacas_should_return_false_when_fila_empty_and_want_zerotest() {
        //Preparamos los datos
        solicitados = 0;
        asientos = new boolean[]{};

        // Llamar al método que actualiza los asientos
        salidaObtenida= assertDoesNotThrow(() -> cin.reservaButacas(asientos, solicitados), "Desafortunadamente se lanzo Excepcion");

        // Verificamos el resultado
        salidaEsperada = false;
        assertEquals(salidaEsperada, salidaObtenida);

        // Verificar que el vector se actualizó correctamente
        asientosEsperados = new boolean[]{};
        assertArrayEquals(asientosEsperados, asientos);
    }

    @Test
    void C3_reservaButacas_should_return_true_when_fila_has_3_seats_free_and_want_2test() {
        //Preparamos los datos
        solicitados = 2;
        asientos = new boolean[]{false, false, false, true, true};

        //Primero nos aseguramos que no se lance excepcion con el assertDoesNotThrow
        salidaObtenida = assertDoesNotThrow(() -> cin.reservaButacas(asientos, solicitados), "Desafortunadamente se lanzo Excepcion");

        // Verificamos el resultado
        salidaEsperada = true;
        assertEquals(salidaEsperada, salidaObtenida);

        // Verificar que el vector se actualizó correctamente
        asientosEsperados = new boolean[]{true, true, false, true, true};
        assertArrayEquals(asientosEsperados, asientos);
    }

    @Test
    void C4_reservaButacas_should_return_false_when_no_free_seats_and_want_1test() {
        //Preparamos los datos
        solicitados = 1;
        asientos = new boolean[]{true, true, true};

        //Primero nos aseguramos que no se lance excepcion
        salidaObtenida = assertDoesNotThrow(() -> cin.reservaButacas(asientos, solicitados), "Desafortunadamente se lanzo Excepcion");

        // Verificamos el resultado
        salidaEsperada = false;
        assertEquals(salidaEsperada, salidaObtenida);

        // Verificar que el vector se actualizó correctamente
        asientosEsperados = new boolean[]{true, true, true};
        assertArrayEquals(asientosEsperados, asientos);
    }

    /*Ejemplo con AssertAll, esto la ventaja que nos da es que en caso de errores nos proporciona mas informacion
      ya que si ponemos dos aserciones una detras de otra el test terminara cuando se lance una de ellas y no sabremos
      cual es.Por lo que si las agrupamos en un assertAll se ejecutaran todas y si alguna falla saltará MultipleFailuresError
     */


    //IMITACION TEST C2
    @Test
    void C6_reservaButacas_should_return_false_when_fila_empty_and_want_zeroAllTest() {
        //Preparamos los datos
        solicitados = 0;
        asientos = new boolean[]{};

        //Primero nos aseguramos que no se lance excepcion con el assertDoesNotThrow
        salidaObtenida = assertDoesNotThrow(() -> cin.reservaButacas(asientos, solicitados), "Desafortunadamente se lanzo Excepcion");

        // Verificamos el resultado
        salidaEsperada = false;
        asientosEsperados = new boolean[]{};

        //Verificacion de Resultados
        assertAll("GrupoTest",
                ()->assertEquals(salidaEsperada, salidaObtenida),
                ()->assertArrayEquals(asientosEsperados, asientos)
        );
    }


    //IMITACION TEST C3
    @Test
    void C7_reservaButacas_should_return_true_when_fila_has_3_seats_free_and_want_2AllTest() {
        //Preparamos los datos
        solicitados = 2;
        asientos = new boolean[]{false, false, false, true, true};

        //Primero nos aseguramos que no se lance excepcion con el assertDoesNotThrow
        salidaObtenida = assertDoesNotThrow(() -> cin.reservaButacas(asientos, solicitados), "Desafortunadamente se lanzo Excepcion");

        // Resultados Esperados
        salidaEsperada = true;
        asientosEsperados = new boolean[]{true, true, false, true, true};

        //Verificacion de Resultados
        assertAll("GrupoTest",
                ()->assertEquals(salidaEsperada, salidaObtenida),
                ()->assertArrayEquals(asientosEsperados, asientos)
        );
    }

    //IMITACION TEST C4
    @Test
    void C8_reservaButacas_should_return_false_when_no_free_seats_and_want_1AllTest() {
        //Preparamos los datos
        solicitados = 1;
        asientos = new boolean[]{true, true, true};

        //Primero nos aseguramos que no se lance excepcion
        salidaObtenida = assertDoesNotThrow(() -> cin.reservaButacas(asientos, solicitados), "Desafortunadamente se lanzo Excepcion");

        //Resultados Esperados
        salidaEsperada = false;
        asientosEsperados = new boolean[]{true, true, true};

        //Verificacion de Resultados
        assertAll("GrupoTest",
                ()->assertEquals(salidaEsperada, salidaObtenida),
                ()->assertArrayEquals(asientosEsperados, asientos)
        );
    }

    /*
    Implementacion de test parametrizados
     */

    private static Stream<Arguments> casoDePrueba(){
        return Stream.of(
                Arguments.of(false,new boolean[]{},0,new boolean[]{}),
                Arguments.of(true, new boolean[]{true, true, false, true, true}, 2, new boolean[]{false, false, false, true, true}),
                Arguments.of(false, new boolean[]{true, true, true}, 1, new boolean[]{true, true, true})
        );
    }
    @ParameterizedTest(name="holatest {1} y {2} y {3} y {4}")
    @MethodSource("casoDePrueba")
    void testParametriza (boolean salidaEsperadaP, boolean [] asientosEsperadosP, int solicitadosP, boolean [] asientosP) {

        //Primero nos aseguramos que no se lance excepcion
        salidaObtenida = assertDoesNotThrow(() -> cin.reservaButacas(asientosP, solicitadosP), "Desafortunadamente se lanzo Excepcion");

        //Verificacion de Resultados
        assertAll(
                ()->assertEquals(salidaEsperadaP, salidaObtenida),
                ()->assertArrayEquals(asientosEsperadosP, asientosP)
        );
    }



}