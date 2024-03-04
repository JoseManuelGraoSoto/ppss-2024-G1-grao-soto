package ppss;

public class AlquilaCochesTestable extends AlquilaCoches{

    public void setCalendario(CalendarioStub calS){
        this.calendario = calS;
    }

    IService precio;

    @Override
    public IService getPrecio(){
        return precio;
    }

    public void setPrecio(IService inter){
        this.precio = inter;
    }
}
