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
    void C1_delete_should_beDeletedProperly_when_elemIsThere_test() {
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

    @Test
    void C2_delete_should_delete1instanceOf2_when_elemIsThere_test() {
        //Preparamos los datos
        coleccion = new int[]{1,3,3,5,7};
        numElem = 5;
        elemBorrar = 3;
        darray = new DataArray(coleccion);
        coleccionEsperada = new int[]{1,3,5,7};
        numElemEsperado = 4;

        //Primero nos aseguramos que no se lance excepcion con el assertDoesNotThrow
        assertDoesNotThrow(()->darray.delete(elemBorrar));

        // Verificar los resultados
        assertAll(
                ()->assertEquals(numElemEsperado, darray.size()),
                ()->assertArrayEquals(coleccionEsperada, darray.getColeccion())
        );
    }

    @Test
    void C3_delete_should_deleteIfListComplete_when_elemIsThere_test() {
        //Preparamos los datos
        coleccion = new int[]{1,2,3,4,5,6,7,8,9,10};
        numElem = 10;
        elemBorrar = 4;
        darray = new DataArray(coleccion);
        coleccionEsperada = new int[]{1,2,3,5,6,7,8,9,10};
        numElemEsperado = 9;

        //Primero nos aseguramos que no se lance excepcion con el assertDoesNotThrow
        assertDoesNotThrow(()->darray.delete(elemBorrar));

        // Verificar los resultados
        assertAll(
                ()->assertEquals(numElemEsperado, darray.size()),
                ()->assertArrayEquals(coleccionEsperada, darray.getColeccion())
        );
    }

    @Test
    void C4_delete_should_throwDataExceptionM1_when_noElems_test() {
        //Preparamos los datos
        coleccion = new int[]{};
        numElem = 0;
        elemBorrar = 8;
        darray = new DataArray(coleccion);

        // Llamar al método que actualiza los asientos
        DataException exception = assertThrows(DataException.class, () ->darray.delete(elemBorrar));

        // Verificamos el resultado
        assertEquals("No hay elementos en la colección", exception.getMessage());

    }

    @Test
    void C5_delete_should_throwDataExceptionM2_when_elemBorrarMenor0_test() {
        //Preparamos los datos
        coleccion = new int[]{1,3,5,7};
        numElem = 4;
        elemBorrar = -5;
        darray = new DataArray(coleccion);

        // Llamar al método que actualiza los asientos
        DataException exception = assertThrows(DataException.class, () ->darray.delete(elemBorrar));

        // Verificamos el resultado
        assertEquals("El valor a borrar debe ser > 0", exception.getMessage());

    }

    @Test
    void C6_delete_should_throwDataExceptionM3_when_coleccionVaciaYcero_test() {
        //Preparamos los datos
        coleccion = new int[]{};
        numElem = 0;
        elemBorrar = 0;
        darray = new DataArray(coleccion);

        // Llamar al método que actualiza los asientos
        DataException exception = assertThrows(DataException.class, () ->darray.delete(elemBorrar));

        // Verificamos el resultado
        assertEquals("Colección vacía. Y el valor a borrar debe ser > 0", exception.getMessage());

    }

    @Test
    void C7_delete_should_throwDataExceptionM4_when_elemNoThere_test() {
        //Preparamos los datos
        coleccion = new int[]{1,3,5,7};
        numElem = 4;
        elemBorrar = 8;
        darray = new DataArray(coleccion);

        // Llamar al método que actualiza los asientos
        DataException exception = assertThrows(DataException.class, () ->darray.delete(elemBorrar));

        // Verificamos el resultado
        assertEquals("Elemento no encontrado", exception.getMessage());

    }
}