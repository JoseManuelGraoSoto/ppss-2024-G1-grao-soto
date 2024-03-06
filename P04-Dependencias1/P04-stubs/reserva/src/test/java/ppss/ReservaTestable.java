package ppss;

public class ReservaTestable extends Reserva{

    boolean permiso;

    public void setPermiso(boolean permisoP){
        this.permiso = permisoP;
    }

    @Override
    public boolean compruebaPermisos(String login, String password, Usuario tipoUsu) {

        return permiso;

    }
}
