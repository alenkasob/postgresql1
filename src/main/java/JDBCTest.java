import sun.applet.Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        //URL к базе состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
        String url = "jdbc:postgresql://127.0.0.1:5432/test";
        //Имя пользователя БД
        String name = "postgres";
        //Пароль
        String password = "sqladmin";
        Main main = new Main();
        ArrayList<MyContacts> contactsList =new ArrayList<>();
        contactsList.add(new MyContacts(1,"Beliy","Oleg","0632012308",
                "0631239578","dtres123","yuy67@tyre"));
        MyContacts my = new MyContacts();

       
      //  my.createContact(contactsList,url,name,password);
        my.selectContact(url,name,password);
        my.deleteContact(url,name,password);
      /* try {
           //Загружаем драйвер
           Class.forName("org.postgresql.Driver");
           System.out.println("Драйвер подключен");
           //Создаём соединение
           connection = getConnection(url, name, password);
           System.out.println("Соединение установлено");


           Statement statement = connection.createStatement();

           //Выполним запрос
           ResultSet result1= statement.executeQuery("SELECT * FROM mytable" );
           //result это указатель на первую строку с выборки
           //чтобы вывести данные мы будем использовать
           //метод next() , с помощью которого переходим к следующему элементу
           System.out.println("Выводим statement");
           while (result1.next()) {
               System.out.println("Номер в выборке #" + result1.getRow()
                       + "\t Номер в базе #" + result1.getInt("id")
                       + "\t" + result1.getString("name"));


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
*/
    }
}
