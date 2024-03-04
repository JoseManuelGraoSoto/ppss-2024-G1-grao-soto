package ppss;

public class ServicioStub implements IService{

    float precioTipo;

    @Override
    public float consultaPrecio(TipoCoche coche) {
        return precioTipo;
    }

    public void setPrecio(float precioModelo){
        precioTipo = precioModelo;
    }
}
