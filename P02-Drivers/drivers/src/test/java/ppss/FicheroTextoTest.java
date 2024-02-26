package ppss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;


import static org.junit.jupiter.api.Assertions.*;

@Tag("etiqueta1")
public class FicheroTextoTest {

    String ficheroTxt;
    int salidaEsperada;
    int salidaObtenida;
    FicheroTexto txt;

    @BeforeEach
    public void setup(){ txt = new FicheroTexto(); }

    @Test
    @Tag("etiqueta2")
    void C1_contarCaracteres_should_return_Exception_when_file_does_not_exist(){
        //Preparamos los datos
        ficheroTxt = "ficheroC1.txt";

        // Llamar al método que actualiza los asientos
        FicheroException exception = assertThrows(FicheroException.class, () ->txt.contarCaracteres(ficheroTxt));

        // Verificamos el resultado
        assertEquals("ficheroC1.txt (No existe el archivo o el directorio)", exception.getMessage());

    }


    @Test
    void C2_contarCaracteres_should_return_3_when_file_has_3_chars(){

        //Preparamos los datos
        ficheroTxt = "src/test/resources/ficheroCorrecto.txt";

        // Llamar al método que actualiza los asientos
        salidaObtenida= assertDoesNotThrow(() -> txt.contarCaracteres(ficheroTxt), "Desafortunadamente se lanzo Excepcion");

        // Verificamos el resultado
        salidaEsperada = 3;
        assertEquals(salidaEsperada, salidaObtenida);
    }

    //@Test
   //void C3_contarCaracteres_should_return_Exception_when_file_cannot_be_read(){



    //}

    //@Test
    //void C4_contarCaracteres_should_return_Exception_when_file_cannot_be_closed(){



    //}

}