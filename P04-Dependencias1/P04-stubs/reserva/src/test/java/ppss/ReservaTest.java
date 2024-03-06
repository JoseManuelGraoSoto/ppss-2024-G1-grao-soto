package ppss;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ppss.excepciones.ReservaException;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaTest {

    ReservaTestable resTable;
    OperacionStub opSt;
    Usuario tipo;
    Reserva res;
    String login;
    String pass;
    String socio;
    String[] isbns;
    String resE;



    @BeforeEach
    public void setup() {
        resTable = new ReservaTestable();
        opSt = new OperacionStub();

    }

    @AfterEach
    public void reset()
    {
        Factoria.setOperacion(null);
    }

    @Test
    void C1_reserva_should_return_ReservaException1_when_permisosFalse_Test() {

        //Preparamos los datos
        String login = "xxxx";
        String pass = "xxxx";
        String socio = "Luis";
        isbns = new String[]{"11111"};
        resE ="ERROR de permisos; ";

        //Le aportamos los valores a los dobles como necesitemos en el test
        resTable.setPermiso(false);
        opSt.setOperacionReserva(new ArrayList<Integer>(){});
        Factoria.setOperacion(opSt);

        ReservaException excepcion;
        excepcion = assertThrows(ReservaException.class, ()->resTable.realizaReserva(login, pass, socio, isbns));


        // Verificamos el resultado
        assertEquals(resE, excepcion.getMessage());

    }

    @Test
    void C2_reserva_should_return_NoExcep_when_permisosTrue_Test() {

        //Preparamos los datos
        login = "ppss";
        pass = "ppss";
        socio = "Luis";
        isbns = new String[]{"11111","22222"};

        //Le aportamos los valores a los dobles como necesitemos en el test
        resTable.setPermiso(true);
        opSt.setOperacionReserva(new ArrayList<Integer>(Arrays.asList(0,0)));
        Factoria.setOperacion(opSt);

        assertDoesNotThrow(
                ()->resTable.realizaReserva(login,pass,socio,isbns)
        );


    }



}
