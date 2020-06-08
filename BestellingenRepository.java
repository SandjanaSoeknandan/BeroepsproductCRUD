package sr.unasat.jdbc.crud.repositories;

import sr.unasat.jdbc.crud.entities.Bestellingen;
import sr.unasat.jdbc.crud.entities.Medicijnen;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BestellingenRepository {
    private Connection connection;

    public BestellingenRepository() {
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


    public List<Bestellingen> findAllRecords() {
        List<Bestellingen> bestellingenList = new ArrayList<Bestellingen>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "select m.Medicijn_id, m.Medicijn_naam, m.Medicijn_aantal, " +
                    "b.Bestelling_id, b.Datum, b.Aantal, b.Verantwoordelijke" +
                    " from Bestellingen b" +
                    " join Medicijnen m on m.medicijn_id = b.Medicijn_id";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int medicijn_id = rs.getInt("Medicijn_id");
                String medicijn_naam = rs.getString("Medicijn_naam");
                int medicijn_aantal = rs.getInt("Medicijn_aantal");
                int bestelling_id = rs.getInt("Bestelling_id");
                String datum = rs.getString("Datum");
                int aantal = rs.getInt("Aantal");
                String verantwoordelijke = rs.getString("Verantwoordelijke");

                Medicijnen medicijnen = new Medicijnen(medicijn_id, medicijn_naam, medicijn_aantal);
                //Display values
                //System.out.print("ID: " + Medicijn_id);
                //System.out.print(", Age: " + Medicijn_naam);
                bestellingenList.add(new Bestellingen(bestelling_id, datum, aantal, verantwoordelijke, medicijnen));
                //  persoonList.add(new Persoon(rs.getInt("id"), rs.getString("naam")));
            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return bestellingenList;
    }

    public int insertOneRecord(Bestellingen bestellingen, Medicijnen medicijnen) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "insert into Bestellingen (Datum, Aantal, Verantwoordelijke, Medicijn_id) values(?, ?, ?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, bestellingen.getDatum());
            stmt.setInt(2, bestellingen.getAantal());
            stmt.setString(3, bestellingen.getVerantwoordelijke());
            stmt.setInt(4, medicijnen.getMedicijn_id());
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

    public int deleteOneRecord(Bestellingen bestellingen) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "delete from Bestellingen where Bestelling_id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, bestellingen.getBestelling_id());
            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);
            if (result > 0) {
                System.out.println("Delete was successful!");
            } else {
                System.out.println("Error while deleting record");
            }
            System.out.println("deleted bestelling with id: " + bestellingen.getBestelling_id());

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }


}
