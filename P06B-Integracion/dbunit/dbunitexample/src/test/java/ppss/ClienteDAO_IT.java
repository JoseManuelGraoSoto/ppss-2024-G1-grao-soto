package ppss;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;

import org.junit.jupiter.api.*;

import java.sql.SQLException;

/* IMPORTANTE:
    Dado que prácticamente todos los métodos de dBUnit lanzan una excepción,
    vamos a usar "throws Esception" en los métodos, para que el código quede más
    legible sin necesidad de usar un try..catch o envolver cada sentencia dbUnit 
    con un assertDoesNotThrow()
    Es decir, que vamos a primar la legibilidad de los tests.
    Si la SUT puede lanza una excepción, SIEMPRE usaremos assertDoesNotThrow para
    invocar a la sut cuando no esperemos que se lance dicha excepción (independientemente de que hayamos propagado las excepciones provocadas por dbunit).
*/
public class ClienteDAO_IT {
  
  private ClienteDAO clienteDAO; //SUT
  private IDatabaseTester databaseTester;
  private IDatabaseConnection connection;

  @BeforeEach
  public void setUp() throws Exception {

    String cadena_conexionDB = "jdbc:mysql://localhost:3306/DBUNIT?useSSL=false";
    databaseTester = new JdbcDatabaseTester("com.mysql.cj.jdbc.Driver",
            cadena_conexionDB, "root", "josee711");
    connection = databaseTester.getConnection();

    clienteDAO = new ClienteDAO();
  }

  @Test
  public void D1_insert_should_add_John_to_cliente_when_John_does_not_exist() throws Exception {
    Cliente cliente = new Cliente(1,"John", "Smith");
    cliente.setDireccion("1 Main Street");
    cliente.setCiudad("Anycity");

    //inicializamos la BD
    IDataSet dataSet = new FlatXmlDataFileLoader().load("/sql/cliente-init.xml");
    databaseTester.setDataSet(dataSet);
    databaseTester.onSetup();
    
     //invocamos a la sut
    Assertions.assertDoesNotThrow(()->clienteDAO.insert(cliente));

    //recuperamos los datos de la BD después de invocar al SUT
    IDataSet databaseDataSet = connection.createDataSet();
    ITable actualTable = databaseDataSet.getTable("cliente"); 

    //creamos el dataset con el resultado esperado
    IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/sql/cliente-esperado.xml");
    ITable expectedTable = expectedDataSet.getTable("cliente");

    Assertion.assertEquals(expectedTable, actualTable);

   }



  @Test
  public void D2_delete_should_remove_John_from_cliente_when_John_is_in_table() throws Exception {
    Cliente cliente =  new Cliente(1,"John", "Smith");
    cliente.setDireccion("1 Main Street");
    cliente.setCiudad("Anycity");

    //inicializamos la BD
    IDataSet dataSet = new FlatXmlDataFileLoader().load("/sql/cliente-esperado.xml");
    databaseTester.setDataSet(dataSet);
    databaseTester.onSetup();

    //invocamos a la SUT
    Assertions.assertDoesNotThrow(()->clienteDAO.delete(cliente));

    //recuperamos los datos de la BD después de invocar al SUT
    IDataSet databaseDataSet = connection.createDataSet();
    ITable actualTable = databaseDataSet.getTable("cliente");
    
    //creamos el dataset con el resultado esperado
    IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/sql/cliente-init.xml");
    ITable expectedTable = expectedDataSet.getTable("cliente");

    Assertion.assertEquals(expectedTable, actualTable);
  }

  @Test
  public void D3_insert_should_add_John_to_cliente_when_John_does_not_exist() throws Exception {
    Cliente cliente =  new Cliente(1,"Jose", "Grao");
    cliente.setDireccion("Orihuela");
    cliente.setCiudad("Alicante");

    //inicializamos la BD
    IDataSet dataSet = new FlatXmlDataFileLoader().load("/sql/clienteAdded3.xml");
    databaseTester.setDataSet(dataSet);
    databaseTester.onSetup();

    //invocamos a la SUT
    Assertions.assertThrows(SQLException.class, ()->clienteDAO.delete(cliente), "Duplicate entry");

    //recuperamos los datos de la BD después de invocar al SUT
    IDataSet databaseDataSet = connection.createDataSet();
    ITable actualTable = databaseDataSet.getTable("cliente");

    //creamos el dataset con el resultado esperado
    IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/sql/clienteAdded3.xml");
    ITable expectedTable = expectedDataSet.getTable("cliente");

    Assertion.assertEquals(expectedTable, actualTable);
  }

  @Test
  public void D4_delete_should_remove_Julia_from_cliente_when_Julia_is_non_in_table() throws Exception {
    Cliente cliente =  new Cliente(5,"Julia", "hehe");
    cliente.setDireccion("Warsaw");
    cliente.setCiudad("Warsaw");

    //inicializamos la BD
    IDataSet dataSet = new FlatXmlDataFileLoader().load("/sql/clienteAdded3.xml");
    databaseTester.setDataSet(dataSet);
    databaseTester.onSetup();

    //invocamos a la SUT
    Assertions.assertThrows(SQLException.class, ()->clienteDAO.delete(cliente), "Delete failed");

    //recuperamos los datos de la BD después de invocar al SUT
    IDataSet databaseDataSet = connection.createDataSet();
    ITable actualTable = databaseDataSet.getTable("cliente");

    //creamos el dataset con el resultado esperado
    IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/sql/clienteAdded3.xml");
    ITable expectedTable = expectedDataSet.getTable("cliente");

    Assertion.assertEquals(expectedTable, actualTable);
  }

  @Test
  public void D5_update_should_update_jose_from_cliente_to_Pedro_when_id_1_in_table() throws Exception {
    Cliente cliente =  new Cliente(2,"Pedro", "Grao");
    cliente.setDireccion("Warsaw");
    cliente.setCiudad("Warsaw");

    //inicializamos la BD
    IDataSet dataSet = new FlatXmlDataFileLoader().load("/sql/clienteAdded3.xml");
    databaseTester.setDataSet(dataSet);
    databaseTester.onSetup();

    //invocamos a la SUT
    Assertions.assertDoesNotThrow(()->clienteDAO.update(cliente));

    //recuperamos los datos de la BD después de invocar al SUT
    IDataSet databaseDataSet = connection.createDataSet();
    ITable actualTable = databaseDataSet.getTable("cliente");

    //creamos el dataset con el resultado esperado
    IDataSet expectedDataSet = new FlatXmlDataFileLoader().load("/sql/clienteResultAdded3Update.xml");
    ITable expectedTable = expectedDataSet.getTable("cliente");

    Assertion.assertEquals(expectedTable, actualTable);
  }

  @Test
  public void D6_retrieve() throws Exception {
    int id = 1;
    Cliente clienteEsperado = new Cliente(1,"John", "Smith");
    clienteEsperado.setDireccion("1 Main Street");
    clienteEsperado.setCiudad("Anycity");

    //inicializamos la BD
    IDataSet dataSet = new FlatXmlDataFileLoader().load("/sql/cliente-esperado.xml");
    databaseTester.setDataSet(dataSet);
    databaseTester.onSetup();

    //invocamos a la SUT
    Cliente client = Assertions.assertDoesNotThrow(()->clienteDAO.retrieve(id));

    Assertions.assertAll("Comprobación Cliente",
            ()->Assertions.assertEquals(clienteEsperado.getId(),client.getId()),
            ()->Assertions.assertEquals(clienteEsperado.getNombre(),client.getNombre()),
            ()->Assertions.assertEquals(clienteEsperado.getApellido(),client.getApellido()),
            ()->Assertions.assertEquals(clienteEsperado.getCiudad(),client.getCiudad()),
            ()->Assertions.assertEquals(clienteEsperado.getDireccion(),client.getDireccion())
    );
  }

}
