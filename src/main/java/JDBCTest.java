import sun.applet.Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.sql.DriverManager.getConnection;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        //URL к базе состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
        //String url = "jdbc:postgresql://127.0.0.1:5432/test";
        String url = "jdbc:firebirdsql://localhost:3050/E:/DB/DB.fdb";

        //Имя пользователя БД
        String name = "SYSDBA" ;//"postgres";
        //Пароль
        String password ="masterkey"; //"sqladmin";
        Main main = new Main();
       // ArrayList<MyContacts> contactsList =new ArrayList<>();
       // contactsList.add(new MyContacts(1,"Belya","Olena","063245308",
              //  "0631239578","dtres123","yuy67@tyre"));

       // MyContacts my = new MyContacts();

        ArrayList<Checks> checksList =new ArrayList<>();
       //  checksList.add(new Checks(1,1,2,5));
        //  "0631239578","dtres123","yuy67@tyre"));
        Checks my = new Checks();
        my.selectChecks(url,name,password);
        // my.deleteContact(url,n);

       // my.createContact(contactsList,url,name,password);
     // my.  (url,name,password);
       // my.deleteContact(url,name,password);
       try {
           //Загружаем драйвер
           Class.forName("org.firebirdsql.jdbc.FBDriver");
           System.out.println("Драйвер подключен");
           //Создаём соединение
           connection = getConnection(url, name, password);
           System.out.println("Соединение установлено");


           try (Statement statement = connection.createStatement()) {

               //Выполним запрос
               try (ResultSet result1 = statement.executeQuery("Select first 100 (d.*) from jor_checks_dt d")) {
                   //result это указатель на первую строку с выборки
                   //чтобы вывести данные мы будем использовать
                   //метод next() , с помощью которого переходим к следующему элементу
                   System.out.println("Выводим statement");
                   while (result1.next()) {
                       System.out.println("Номер в выборке #" + result1.getRow()
                               + "\t Номер в базе #" + result1.getString("ID")
                               + "\t" + result1.getString("HD_ID"));
                   }
               }
           }

       }
       catch(Exception ex){ Logger.getLogger(JDBCTest.class.getName()).log(Level.SEVERE, null, ex); }

       finally {
           if (connection != null) {
               try {
                   connection.close();

               } catch (SQLException ex) {
                   Logger.getLogger(JDBCTest.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }

    }
}
