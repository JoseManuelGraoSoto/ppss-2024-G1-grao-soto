package ppss;

import ppss.excepciones.IsbnInvalidoException;
import ppss.excepciones.JDBCException;
import ppss.excepciones.SocioInvalidoException;

import java.util.ArrayList;

public class OperacionStub implements IOperacionBO {

    ArrayList<Integer> exceptions;

    public void setOperacionReserva(ArrayList<Integer> exceptions)
    {
        this.exceptions = exceptions;
    }
    @Override
    public void operacionReserva(String socio, String isbn) throws IsbnInvalidoException, JDBCException, SocioInvalidoException {
        if(exceptions.size() == 0)
            return;

        int tipo = exceptions.remove(0);
        switch (tipo) {
            case 0:
                break;
            case 1:
                throw new IsbnInvalidoException();
            case 2:
                throw new JDBCException();
            case 3:
                throw new SocioInvalidoException();

        }
    }
}
