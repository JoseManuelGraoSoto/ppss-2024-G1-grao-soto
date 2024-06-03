package ppss;

import org.easymock.bytebuddy.asm.MemberSubstitution;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


@Tag("etiqueta1")
public class DataArrayTest {

    DataArray darray;

    int[] coleccion;
    int elem;
    int numC;
    int[] coleccionE;
    int numElemEsperado;

    public void setUp(){
        darray = null;
    }

    @Test
    @Tag("etiqueta2")
    void c1_delete_shouldReturn_when_ (){

        coleccion = new int[]{1, 3, 5, 7};
        elem = 5;
        darray = new DataArray(coleccion);
        numElemEsperado = 3;
        coleccionE = new int[]{1, 3, 7};

        assertDoesNotThrow(
                ()-> darray.delete(elem)
        );

        assertAll(
                ()->assertArrayEquals(coleccionE, darray.getColeccion()),
                ()->assertEquals(numElemEsperado, darray.size())
        );
    }

    @Test
    @Tag("etiqueta3")
    void c2_delete_shouldReturn_when_ (){

        coleccion = new int[]{1, 3, 7};
        elem = 7;
        darray = new DataArray(coleccion);
        numElemEsperado = 2;
        coleccionE = new int[]{1, 3};

        assertDoesNotThrow(
                ()-> darray.delete(elem)
        );

        assertAll(
                ()->assertArrayEquals(coleccionE, darray.getColeccion()),
                ()->assertEquals(numElemEsperado, darray.size())
        );
    }

    @Test
    @Tag("etiqueta3")
    void c3_delete_shouldReturn_when_ (){

        coleccion = new int[]{1, 3, 7, 4};
        elem = 7;
        darray = new DataArray(coleccion);
        numElemEsperado = 3;
        coleccionE = new int[]{1, 3, 4};

        assertDoesNotThrow(
                ()-> darray.delete(elem)
        );

        assertAll(
                ()->assertArrayEquals(coleccionE, darray.getColeccion()),
                ()->assertEquals(numElemEsperado, darray.size())
        );
    }

    private static Stream<Arguments> casosDePrueba(){
        return Stream.of(
            Arguments.of(new int[]{1,2,4,7}, 7, new int[]{1,2, 4}, 3 ),
            Arguments.of(new int[]{1,2,4}, 1, new int[]{2,4}, 2 )
        );
    }

    @ParameterizedTest
    @MethodSource("casosDePrueba")
    @Tag("etiqueta4")
    void c3_delete_shouldReturn_when_ (int[] coleccionP, int elemP, int[] coleccionE, int lengthE){

        darray = new DataArray(coleccionP);

        assertDoesNotThrow(
                ()-> darray.delete(elemP)
        );

        assertAll(
                ()->assertArrayEquals(coleccionE, darray.getColeccion()),
                ()->assertEquals(lengthE, darray.size())
        );
    }

    private static Stream<Arguments> casosDePrueba2(){
        return Stream.of(
                Arguments.of(new int[]{}, -2, "Colección vacía. Y el valor a borrar debe ser > 0"),
                Arguments.of(new int[]{}, 5, "No hay elementos en la colección"),
                Arguments.of(new int[]{1,2,4}, 5, "Elemento no encontrado")
        );
    }

    @ParameterizedTest
    @MethodSource("casosDePrueba2")
    @Tag("etiqueta5")
    void c4_delete_shouldReturn_when_ (int[] coleccionP, int elemP, String mesgE){

        darray = new DataArray(coleccionP);

        DataException except = assertThrows(DataException.class, ()->darray.delete(elemP));

        assertEquals(mesgE, except.getMessage());

    }
}
