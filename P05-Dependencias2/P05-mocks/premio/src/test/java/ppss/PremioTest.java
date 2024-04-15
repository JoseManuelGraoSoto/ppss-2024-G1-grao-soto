package ppss;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.partialMockBuilder;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PremioTest {

    IMocksControl ctrl;
    Premio premioT;
    ClienteWebService serviceT;
    float numA;
    String premioS;
    String resObtenido;
    String resE;


    @BeforeEach
    public void setup() {
        ctrl = EasyMock.createStrictControl();
        premioT = partialMockBuilder(Premio.class).addMockedMethod("generaNumero").mock(ctrl);
        serviceT = ctrl.mock(ClienteWebService.class);
        premioT.cliente = serviceT; //Por que se le añade esta linea??
    }


    @Test
    void C1_compruebaPremioTest(){
        /*
            El número aleatorio generado es de 0,07, el servicio de consulta del premio (método
            obtenerPremio) devuelve “entrada final Champions”, y el resultado esperado es “Premiado con
            entrada final Champions”
         */
        numA = 0.07F;
        premioS = "entrada final Champions";
        resE = "Premiado con entrada final Champions";
        expect(premioT.generaNumero()).andStubReturn(numA);
        assertDoesNotThrow(()->
                expect(serviceT.obtenerPremio()).andStubReturn(premioS)
        );
        ctrl.replay();
        resObtenido = premioT.compruebaPremio();
        Assertions.assertEquals(resE, resObtenido);
        ctrl.verify();

    }

    @Test
    void C2_compruebaPremioTest(){
        /*
            el número aleatorio generado es de 0,03, el servicio de consulta del premio (método
            obtenerPremio) devuelve una excepción de tipo ClientWebServiceException, y el resultado
            esperado es “No se ha podido obtener el premio”
         */
        numA = 0.03F;
        resE = "No se ha podido obtener el premio";
        expect(premioT.generaNumero()).andStubReturn(numA);
        assertDoesNotThrow(
                ()-> EasyMock.expect(serviceT.obtenerPremio()).andThrow(new ClienteWebServiceException())
        );
        /*
        Esto se hace asi, ya que si pongo un asserThrows, no podría hacer nada mas.
        Si quieres que devuelva la excepcion seria assertDoesNotThrow ().expectlastCall.andthrows...
         */
        ctrl.replay();
        resObtenido = premioT.compruebaPremio();
        Assertions.assertEquals(resE, resObtenido);
        ctrl.verify();

    }

    @Test
    void C3_compruebaPremioTest(){
        /*
            el número aleatorio generado es de 0,3 y el resultado esperado es: "Sin premio"
         */
        numA = 0.3F;
        resE = "Sin premio";
        expect(premioT.generaNumero()).andStubReturn(numA);
        assertDoesNotThrow(()->
                expect(serviceT.obtenerPremio()).andStubReturn(premioS)
        );
        ctrl.replay();
        resObtenido = premioT.compruebaPremio();
        Assertions.assertEquals(resE, resObtenido);
        ctrl.verify();

    }
}
