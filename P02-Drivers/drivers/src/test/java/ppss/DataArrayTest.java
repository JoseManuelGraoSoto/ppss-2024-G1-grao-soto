package ppss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DataArrayTest {

    DataArray darray;
    int[] coleccion;
    int numElem;
    int elemBorrar;
    int[] coleccionEsperada;
    int numElemEsperado;

    @BeforeEach
    public void setup() {
        darray = null;
    }

    @Test
    void C1_delete_should_return_arrayWith3Elem_and3AsTupla_test() {
        //Preparamos los datos
        coleccion = new int[]{1,3,5,7};
        numElem = 4;
        elemBorrar = 5;
        darray = new DataArray(coleccion);
        coleccionEsperada = new int[]{1,3,7};
        numElemEsperado = 3;

        //Primero nos aseguramos que no se lance excepcion con el assertDoesNotThrow
        assertDoesNotThrow(()->darray.delete(elemBorrar));

        // Verificar los resultados
        assertAll(
                ()->assertEquals(numElemEsperado, darray.size()),
                ()->assertArrayEquals(coleccionEsperada, darray.getColeccion())
        );
    }
}