import java.sql.*;
import java.util.List;

import static java.sql.DriverManager.getConnection;

/**
 * Created by User on 30.10.2017.
 */
 class MyContacts {
    private int id;

    private String surname;
    private String name;

    private String cellphone;
    private String viber;
    private String skype;
    private String email;

    public MyContacts(int id, String surname, String name, String cellphone, String viber, String skype, String email) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.cellphone = cellphone;
        this.viber = viber;
        this.skype = skype;
        this.email = email;
    }

    public MyContacts() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getViber() {
        return viber;
    }

    public void setViber(String viber) {
        this.viber = viber;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void createContact(List<MyContacts> list, String url, String name, String password) throws SQLException {

        String SQL = "INSERT INTO test.mytable(id,surname,name,cellphone,viber,skype,email) "
                + "VALUES((select max(t.id) from test.mytable t)+1,?,?,?,?,?,?)";
        try (
                Connection conn = getConnection(url, name, password);
                PreparedStatement statement = conn.prepareStatement(SQL);) {
            int count = 0;

            for (MyContacts contacts : list) {
                //statement.setInt(0,contacts.getId());
                statement.setString(1, contacts.getSurname());
                statement.setString(2, contacts.getName());
                statement.setString(3, contacts.getCellphone());
                statement.setString(4, contacts.getViber());
                statement.setString(5, contacts.getSkype());
                statement.setString(6, contacts.getEmail());

                statement.addBatch();
                count++;
                // execute every 100 rows or less
                if (count % 100 == 0 || count == list.size()) {
                    statement.executeBatch();
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void selectContact(String url, String name, String password) throws SQLException {

        String SQL = "Select * from test.mytable";
        try (
                Connection conn = getConnection(url, name, password);
                Statement statement = conn.createStatement();) {
            int count = 0;
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                //statement.setInt(0,contacts.getId());

                System.out.print("ID = " + rs.getString("id") + "  ");
                System.out.print("NAME = " + rs.getString("name") + "  ");
                System.out.print("SURNAME = " + rs.getString("surname") + "  ");
                System.out.print("CELLPHONE = " + rs.getString("cellphone") + "  ");
                System.out.print("VIBER = " + rs.getString("viber") + "  ");
                System.out.print("SKYPE = " + rs.getString("skype") + "  ");
                System.out.print("EMAIL = " + rs.getString("email") + "  ");
                System.out.println();
                // statement.getResultSet().next();


                count++;
                // execute every 100 rows or less
               /* if (count % 100 == 0 || count == list.size()) {
                    statement.executeBatch();
                }*/
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteContact(String url, String name, String password) {
        int id = 6;
        String SQL = "Delete from test.mytable t where t.id=" + id;
        try (
                Connection conn = getConnection(url, name, password);
                Statement statement = conn.createStatement();) {
            int count = 0;
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                count++;
                // execute every 100 rows or less
               /* if (count % 100 == 0 || count == list.size()) {
                    statement.executeBatch();
                }*/
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
