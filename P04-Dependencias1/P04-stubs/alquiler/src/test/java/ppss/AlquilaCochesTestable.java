package ppss;

public class AlquilaCochesTestable extends AlquilaCoches{
    IService servicio;

    @Override
    public IService getServicio(){
        return servicio;
    }

    public void setPrecio(IService servicio){
        this.servicio = servicio;
    }
}
