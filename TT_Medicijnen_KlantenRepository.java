package sr.unasat.jdbc.crud.repositories;

import sr.unasat.jdbc.crud.entities.Klanten;
import sr.unasat.jdbc.crud.entities.Medicijnen;
import sr.unasat.jdbc.crud.entities.TT_Medicijnen_Klanten;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TT_Medicijnen_KlantenRepository {
    private Connection connection;

    public TT_Medicijnen_KlantenRepository() {
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


    public List<TT_Medicijnen_Klanten> findAllRecords() {
        List<TT_Medicijnen_Klanten> med_klaList = new ArrayList<TT_Medicijnen_Klanten>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select m.Medicijn_id, m.Medicijn_naam, m.Medicijn_aantal, t.Aantal_verkocht, k.Klant_id, k.Voornaam, k.Achternaam, k.Contactnummer, k.Adress" +
                    " from TT_Medicijnen_Klanten t" +
                    " join Klanten k on k.Klant_id = t.Klant_id" +
                    " join Medicijnen m on m.Medicijn_id = t.Medicijn_id";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int medicijn_id = rs.getInt("Medicijn_id");
                String medicijn_naam = rs.getString("Medicijn_naam");
                int medicijn_aantal = rs.getInt("Medicijn_aantal");

                int aantal_verkocht = rs.getInt("Aantal_verkocht");

                int klant_id = rs.getInt("Klant_id");
                String voornaam = rs.getString("Voornaam");
                String achternaam = rs.getString("Achternaam");
                int contactnummer = rs.getInt("Contactnummer");
                String adress = rs.getString("Adress");

                Medicijnen medicijnen = new Medicijnen(medicijn_id, medicijn_naam, medicijn_aantal);
                Klanten klanten = new Klanten(klant_id, voornaam, achternaam, contactnummer, adress);
                //Display values
                //System.out.print("ID: " + Medicijn_id);
                //System.out.print(", Age: " + Medicijn_naam);
                med_klaList.add(new TT_Medicijnen_Klanten(medicijnen, klanten, aantal_verkocht));
                //  persoonList.add(new Persoon(rs.getInt("id"), rs.getString("naam")));
            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return med_klaList;
    }

    public int insertOneRecord(TT_Medicijnen_Klanten tt_medicijnen_klanten) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "insert into TT_Medicijnen_Klanten (Medicijn_id, Klant_id, Aantal_verkocht) values(?, ?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, tt_medicijnen_klanten.getMedicijnen().getMedicijn_id());
            stmt.setInt(2, tt_medicijnen_klanten.getKlanten().getKlant_id());
            stmt.setInt(3, tt_medicijnen_klanten.getAantal_verkocht());
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

    public int deleteOneRecord(TT_Medicijnen_Klanten tt_medicijnen_klanten) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "delete from TT_Medicijnen_Klanten where Medicijn_id = ? and Klant_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, tt_medicijnen_klanten.getMedicijnen().getMedicijn_id());
            stmt.setInt(2, tt_medicijnen_klanten.getKlanten().getKlant_id());
            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);
            if (result > 0) {
                System.out.println("Delete was successful!");
                System.out.println("deleted row with Medicijn_id: " + tt_medicijnen_klanten.getMedicijnen().getMedicijn_id() +
                        " and Klant_id: " + tt_medicijnen_klanten.getKlanten().getKlant_id());
            } else {
                System.out.println("Error while deleting record");
            }

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int updateOneRecordVerkoop(TT_Medicijnen_Klanten tt_medicijnen_klanten, int hoeveelheid) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "update TT_Medicijnen_Klanten set Aantal_verkocht = Aantal_verkocht + ? where Medicijn_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, hoeveelheid);
            stmt.setInt(2, tt_medicijnen_klanten.getMedicijnen().getMedicijn_id());
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

    public int updateOneRecordMedicijn_id(Medicijnen medicijnen1, Medicijnen medicijnen2) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "update TT_Medicijnen_Klanten set Medicijn_id = ? where Medicijn_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, medicijnen1.getMedicijn_id());
            stmt.setInt(2, medicijnen2.getMedicijn_id());
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

    public int updateOneRecordKlant_id(Klanten klanten1, Klanten klanten2) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "update TT_Medicijnen_Klanten set Klant_id = ? where Klant_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, klanten1.getKlant_id());
            stmt.setInt(2, klanten2.getKlant_id());
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
