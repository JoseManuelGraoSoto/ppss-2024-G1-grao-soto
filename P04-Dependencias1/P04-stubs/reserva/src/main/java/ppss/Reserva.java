package ppss;

import ppss.excepciones.IsbnInvalidoException;
import ppss.excepciones.JDBCException;
import ppss.excepciones.ReservaException;
import ppss.excepciones.SocioInvalidoException;

import java.util.ArrayList;

public class Reserva {
    public boolean compruebaPermisos(String login, String password, Usuario tipoUsu) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public void realizaReserva(String login, String password,
                               String socio, String [] isbns) throws ReservaException {
        ArrayList<String> errores = new ArrayList<>(); //Dep.externa pero que no se tiene en cuenta ya que es de JAVA
        if(!compruebaPermisos(login, password, Usuario.BIBLIOTECARIO)) { //Dep.externa
            errores.add("ERROR de permisos");
        } else {
            //IOperacionBO io = new Operacion(); -> Esta linea es sustituida por:
            IOperacionBO io = Factoria.create();
            try {
                for(String isbn: isbns) {
                    try {
                        io.operacionReserva(socio, isbn);
                    } catch (IsbnInvalidoException iie) {
                        errores.add("ISBN invalido" + ":" + isbn);
                    }
                }
            } catch (SocioInvalidoException sie) {
                errores.add("SOCIO invalido");
            } catch (JDBCException je) {
                errores.add("CONEXION invalida");
            }
        }
        if (errores.size() > 0) {
            String mensajeError = "";
            for(String error: errores) {
                mensajeError += error + "; ";
            }
            throw new ReservaException(mensajeError);
        }
    }
}