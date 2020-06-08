package sr.unasat.jdbc.crud.repositories;

import sr.unasat.jdbc.crud.entities.Medicijnen;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicijnenRepository {
    private Connection connection;

    public MedicijnenRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("De driver is geregistreerd!");

            String URL = "jdbc:mysql://localhost/apotheek_administratie";
            String USER = "root";
            String PASS = "";
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println(connection);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Medicijnen> findAllRecords() {
        List<Medicijnen> medicijnenList = new ArrayList<Medicijnen>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select * from Medicijnen";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int medicijn_id = rs.getInt("Medicijn_id");
                String medicijn_naam = rs.getString("Medicijn_naam");
                int medicijn_aantal = rs.getInt("Medicijn_aantal");
                //Display values
                //System.out.print("ID: " + Medicijn_id);
                //System.out.print(", Age: " + Medicijn_naam);
                medicijnenList.add(new Medicijnen(medicijn_id, medicijn_naam, medicijn_aantal));
                //  persoonList.add(new Persoon(rs.getInt("id"), rs.getString("naam")));
            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return medicijnenList;
    }

    public int insertOneRecord(Medicijnen medicijnen) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "insert into Medicijnen (medicijn_naam, medicijn_aantal) values(?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, medicijnen.getMedicijn_naam());
            stmt.setInt(2, medicijnen.getMedicijn_aantal());
            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);

            if (result > 0) {
                System.out.println("Insert was successful!");
            } else {
                System.out.println("Error while inserting record");
            }

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int deleteOneRecord(Medicijnen medicijnen) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "delete from Medicijnen where Medicijn_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, medicijnen.getMedicijn_id());
            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);
            if (result > 0) {
                System.out.println("Delete was successful!");
                System.out.println("deleted medicine with id: " + medicijnen.getMedicijn_id());
            } else {
                System.out.println("Error while deleting record");
            }

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }


    public Medicijnen findOneRecord(int id) {
        Medicijnen medicijnen = null;
        PreparedStatement stmt = null;
        try {
            String sql = "Select * from Medicijnen" +
                    " where Medicijn_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            System.out.println("resultset: " + rs);
            //STEP 5: Extract data from result set
            if (rs.next()) {
                //Retrieve by column name
                int medicijn_id = rs.getInt("Medicijn_id");
                String medicijn_naam = rs.getString("Medicijn_naam");
                int medicijn_aantal = rs.getInt("Medicijn_aantal");

                medicijnen = new Medicijnen(medicijn_id, medicijn_naam, medicijn_aantal);
            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return medicijnen;
    }


    public List<Medicijnen> controle() {
        List<Medicijnen> medicijnenList = new ArrayList<Medicijnen>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select * from Medicijnen where Medicijn_aantal < 2000";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);
            System.out.println("Deze medicijnen dienen zo snel mogelijk besteld te worden!!!");
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int medicijn_id = rs.getInt("Medicijn_id");
                String medicijn_naam = rs.getString("Medicijn_naam");
                int medicijn_aantal = rs.getInt("Medicijn_aantal");
                //Display values
                //System.out.println(medicijn_id + "," + medicijn_naam + "," + medicijn_aantal);
                //System.out.print(", Age: " + Medicijn_naam);
                medicijnenList.add(new Medicijnen(medicijn_id, medicijn_naam, medicijn_aantal));
                //  persoonList.add(new Persoon(rs.getInt("id"), rs.getString("naam")));
            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return medicijnenList;
    }

    public int updateOneRecordVerkoop(Medicijnen medicijnen, int hoeveelheid) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "update Medicijnen set Medicijn_aantal = Medicijn_aantal - ? where Medicijn_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, hoeveelheid);
            stmt.setInt(2, medicijnen.getMedicijn_id());
            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);
            if (result > 0) {
                System.out.println("Your update was successful!");
            } else {
                System.out.println("Error while updating record");
            }

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int updateOneRecordBestellingMedicijnen(Medicijnen medicijnen, int hoeveelheid) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "update Medicijnen set Medicijn_aantal = Medicijn_aantal + ? where Medicijn_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, hoeveelheid);
            stmt.setInt(2, medicijnen.getMedicijn_id());
            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);
            if (result > 0) {
                System.out.println("Your update was successful!");
            } else {
                System.out.println("Error while updating record");
            }

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }


}
