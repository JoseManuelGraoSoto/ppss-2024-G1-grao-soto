package ppss;



import org.easymock.IMocksControl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.easymock.EasyMock;


import java.util.stream.Stream;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GestorLlamadasTest {

    IMocksControl ctrl;

    int hora;
    int minutos;
    double resE;
    double resObtenido;
    GestorLlamadas gesT;
    Calendario calS;


    @BeforeEach
    public void setup() {
        ctrl = EasyMock.createStrictControl();
        gesT = partialMockBuilder(GestorLlamadas.class).addMockedMethod("getCalendario").mock(ctrl);
        calS = ctrl.mock(Calendario.class);
    }

    @Test
    void C1_calculaConsumo_should_return_457_when_min_hora_22_10Test() {

        minutos = 22;
        hora = 10;
        resE = 457.6;

        expect(gesT.getCalendario()).andStubReturn(calS);
        expect(calS.getHoraActual()).andStubReturn(hora);
        ctrl.replay();
        /*
        No se añade nada al reply ya que queremos verificar todos los creados o no se añade ya que tenemos
        un control y simplemente verifica el control, o no es necesario utilizar parametros si es un IMock??
         */
        resObtenido = gesT.calculaConsumo(minutos);
        assertEquals(resE, resObtenido);
        ctrl.verify();

    }

    @Test
    void C2_calculaConsumo_should_return_457_when_min_hora_13_10Test() {

        minutos = 13;
        hora = 21;
        resE = 136.5;

        expect(gesT.getCalendario()).andStubReturn(calS);
        expect(calS.getHoraActual()).andStubReturn(hora);
        ctrl.replay();
        /*
        No se añade nada al reply ya que queremos verificar todos los creados o no se añade ya que tenemos
        un control y simplemente verifica el control, o no es necesario utilizar parametros si es un IMock??
         */
        resObtenido = gesT.calculaConsumo(minutos);
        assertEquals(resE, resObtenido);
        ctrl.verify();

    }


}
