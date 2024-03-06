package ppss;

public class Factoria {
    private static IOperacionBO op = null;
    public static IOperacionBO create() {
        if(op != null)
            return op;
        return new Operacion();
    }

    public static void setOperacion(IOperacionBO opr){
        op = opr;
    }
}
