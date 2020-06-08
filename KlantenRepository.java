package sr.unasat.jdbc.crud.repositories;

import sr.unasat.jdbc.crud.entities.Klanten;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KlantenRepository {
    private Connection connection;

    public KlantenRepository() {
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


    public List<Klanten> findAllRecords() {
        List<Klanten> klantenList = new ArrayList<Klanten>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select * from Klanten";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int klant_id = rs.getInt("Klant_id");
                String voornaam = rs.getString("Voornaam");
                String achternaam = rs.getString("Achternaam");
                int contactnummer = rs.getInt("Contactnummer");
                String adress = rs.getString("Adress");
                //Display values
                //System.out.print("ID: " + Medicijn_id);
                //System.out.print(", Age: " + Medicijn_naam);
                klantenList.add(new Klanten(klant_id, voornaam, achternaam, contactnummer, adress));
                //  persoonList.add(new Persoon(rs.getInt("id"), rs.getString("naam")));
            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return klantenList;
    }

    public int insertOneRecord(Klanten klanten) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "insert into Klanten (Voornaam, Achternaam, Contactnummer, Adress) values(?, ?, ?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, klanten.getVoornaam());
            stmt.setString(2, klanten.getAchternaam());
            stmt.setInt(3, klanten.getContactnummer());
            stmt.setString(4, klanten.getAdress());
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

    public int deleteOneRecord(Klanten klanten) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "delete from Klanten where Klant_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, klanten.getKlant_id());
            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);
            if (result > 0) {
                System.out.println("Delete was successful!");
                System.out.println("deleted klant with id: " + klanten.getKlant_id());
            } else {
                System.out.println("Error while deleting record");
            }

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public Klanten findOneRecord(int id) {
        Klanten klanten = null;
        PreparedStatement stmt = null;
        try {
            String sql = "select * from Klanten where Klant_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            System.out.println("resultset: " + rs);
            System.out.println("Hierbij de gegevens van de door u gezochte klant " +
                    "met klant_id: " + id);
            //STEP 5: Extract data from result set
            if (rs.next()) {
                //Retrieve by column name
                int medicijn_id = rs.getInt("Klant_id");
                String voornaam = rs.getString("Voornaam");
                String achternaam = rs.getString("Achternaam");
                int contactnummer = rs.getInt("Contactnummer");
                String adress = rs.getString("Adress");

                klanten = new Klanten(medicijn_id, voornaam, achternaam, contactnummer, adress);
            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return klanten;
    }


}
