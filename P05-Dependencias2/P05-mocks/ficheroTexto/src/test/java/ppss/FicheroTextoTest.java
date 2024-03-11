package ppss;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileReader;

public class FicheroTextoTest {

    FicheroTexto ficheroTexto;

    FileReader file;
    IMocksControl ctrl;
    String nombreF;

    @BeforeEach
    public void setUp(){
        ctrl = EasyMock.createStrictControl();
        ficheroTexto = EasyMock.partialMockBuilder(FicheroTexto.class).addMockedMethod("getFichero").mock(ctrl);
        file = ctrl.mock(FileReader.class);
    }
}
