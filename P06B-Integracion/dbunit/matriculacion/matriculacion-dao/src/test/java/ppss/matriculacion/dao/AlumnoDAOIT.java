package ppss.matriculacion.dao;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ppss.matriculacion.to.AlumnoTO;
import java.time.LocalDate;

import java.util.List;

public class AlumnoDAOIT{

    private AlumnoTO alumnoDAO; //SUT
    private IDatabaseTester databaseTester; //Acceder a la BD
    private IDatabaseConnection connection; //Para la conexion

    @BeforeEach
    public void setUp() throws Exception {

        String cadenaconexionDB = "jdbc:mysql://localhost:3306/matriculacion?useSSL=false";
        databaseTester = new JdbcDatabaseTester("com.mysql.cj.jdbc.Driver",
                cadenaconexionDB, "root", "josee711");
        connection = databaseTester.getConnection();

    }
    @Test
    void testA1() throws Exception{

        AlumnoTO alu = new AlumnoTO();
        alu.setNif("33333333C");
        alu.setNombre("Elena Aguirre Juarez");
        alu.setDireccion("");
        alu.setEmail("");
        alu.setFechaNacimiento(LocalDate.of(1985, 02, 22));

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/tabla2.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //Invocamos a la SUT
        Assertions.assertDoesNotThrow(()->new FactoriaDAO().getAlumnoDAO().addAlumno(alu));

        //recuperamos los datos de la BD después de invocar al SUT
        IDataSet databaseDataSet = connection.createDataSet();
        ITable actualTable = databaseDataSet.getTable("alumnos");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/tabla3.xml");
        ITable expectedTable = expectedDataSet.getTable("alumnos");

        Assertion.assertEquals(expectedTable, actualTable);
    }
}
