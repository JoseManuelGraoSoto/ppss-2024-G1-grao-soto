package ppss;

import java.time.LocalDate;

public class AlquilaCoches {

    protected Calendario calendario = new Calendario(); //SEAM para la segunda dependencia

    /*Pra refactorizar este metodo utilizaremos el metodo 4, el cual se basa en aplicar una Factoria Local
    dentro de la clase, por lo que estaremos cumpliendo las restricciones de : "si necesitas refactorizar
    no puedes añadir ningún atributo en la clase que contiene nuestra SUT, ni tampoco alterar en
    modo alguno la forma de invocar a nuestra sut desde otras unidades, así como tampoco puedes
    añadir ninguna clase adicional en producción ( esto ultimo se refiere que no puedes crear nuevas clases
    en src/main/java/ppss, por lo que si que nos permite añadir clases en src/main/test.
     */

    public IService getPrecio(){
        return new Servicio();
    }
    public Ticket calculaPrecio(TipoCoche tipo, LocalDate inicio, int ndias)
            throws MensajeException {

        Ticket ticket = new Ticket();
        float precioDia, precioTotal = 0.0f;
        float porcentaje = 0.25f;
        String observaciones = "";

        IService servicio = this.getPrecio(); //Inyeccion SEAM
        precioDia = servicio.consultaPrecio(tipo); //Dependencia Externa
        for (int i = 0; i < ndias; i++) {
            LocalDate otroDia = inicio.plusDays((long) i); //No es dep.ex ya que es de Java lang
            try {
                if (calendario.es_festivo(otroDia)) {   //Dependencia Externa
                    precioTotal += (1 + porcentaje) * precioDia;
                } else {
                    precioTotal += (1 - porcentaje) * precioDia;
                }
            } catch (CalendarioException ex) {
                observaciones += "Error en dia: " + otroDia + "; ";
            }
        }
        if (observaciones.length() > 0) {
            throw new MensajeException(observaciones);
        }
        ticket.setPrecio_final(precioTotal);
        return ticket;
    }
}
