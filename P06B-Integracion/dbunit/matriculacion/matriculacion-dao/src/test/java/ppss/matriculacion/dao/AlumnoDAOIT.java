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

import static org.dbunit.Assertion.assertEquals;

public class AlumnoDAOIT{

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

        assertEquals(expectedTable, actualTable);
    }

    @Test
    void testA2() throws Exception{

        AlumnoTO alu = new AlumnoTO();
        alu.setNif("11111111A");
        alu.setNombre("Alfonso Ramirez Ruiz");
        alu.setDireccion("");
        alu.setEmail("");
        alu.setFechaNacimiento(LocalDate.of(1982, 02, 22));

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/tabla2.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //Invocamos a la SUT
        DAOException exp = Assertions.assertThrows(DAOException.class, ()->new FactoriaDAO().getAlumnoDAO().addAlumno(alu));

        // 3. Comparamos resultados
        Assertions.assertEquals("Error al conectar con BD",exp.getMessage());
    }

    @Test
    void testA3() throws Exception{

        AlumnoTO alu = new AlumnoTO();
        alu.setNif("44444444D");
        alu.setNombre(null);
        alu.setDireccion("");
        alu.setEmail("");
        alu.setFechaNacimiento(LocalDate.of(1982, 02, 22));

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/tabla2.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //Invocamos a la SUT
        DAOException exp = Assertions.assertThrows(DAOException.class, ()->new FactoriaDAO().getAlumnoDAO().addAlumno(alu));

        // 3. Comparamos resultados
        Assertions.assertEquals("Error al conectar con BD",exp.getMessage());
    }

    @Test
    void testA4() throws Exception{

        AlumnoTO alu = null;

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/tabla2.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //Invocamos a la SUT
        DAOException exp = Assertions.assertThrows(DAOException.class, ()->new FactoriaDAO().getAlumnoDAO().addAlumno(alu));

        // 3. Comparamos resultados
        Assertions.assertEquals("Alumno nulo",exp.getMessage());
    }

    @Test
    void testA5() throws Exception{

        AlumnoTO alu = new AlumnoTO();
        alu.setNif(null);
        alu.setNombre("Pedro Garcia Lopez");
        alu.setDireccion("");
        alu.setEmail("");
        alu.setFechaNacimiento(LocalDate.of(1982, 02, 22));

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/tabla2.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //Invocamos a la SUT
        DAOException exp = Assertions.assertThrows(DAOException.class, ()->new FactoriaDAO().getAlumnoDAO().addAlumno(alu));

        // 3. Comparamos resultados
        Assertions.assertEquals("Error al conectar con BD",exp.getMessage());
    }

    @Test
    void testB1() throws Exception{

        String delAluNif = "11111111A";

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/tabla2.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //Invocamos a la SUT
        Assertions.assertDoesNotThrow(()->new FactoriaDAO().getAlumnoDAO().delAlumno(delAluNif));

        //recuperamos los datos de la BD después de invocar al SUT
        IDataSet databaseDataSet = connection.createDataSet();
        ITable actualTable = databaseDataSet.getTable("alumnos");

        //creamos el dataset con el resultado esperado
        IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/tabla4.xml");
        ITable expectedTable = expectedDataSet.getTable("alumnos");

        assertEquals(expectedTable, actualTable);
    }

    @Test
    void testB2() throws Exception{

        String delAluNif = "33333333C";

        //inicializamos la BD
        IDataSet dataSet = new FlatXmlDataFileLoader().load("/tabla2.xml");
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();

        //Invocamos a la SUT
        DAOException exp = Assertions.assertThrows(DAOException.class, ()->new FactoriaDAO().getAlumnoDAO().delAlumno(delAluNif));

        // 3. Comparamos resultados
        Assertions.assertEquals("No se ha borrado ningun alumno",exp.getMessage());
    }
}
