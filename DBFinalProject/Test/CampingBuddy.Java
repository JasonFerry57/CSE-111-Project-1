// STEP: Import required packages
import java.sql.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.lang.invoke.SwitchPoint;
import java.io.File;

public class Lab_7 {
    private Connection c = null;
    private String dbName;
    private boolean isConnected = false;

    private void openConnection(String _dbName) {
        dbName = _dbName;

        if (false == isConnected) {
            System.out.println("++++++++++++++++++++++++++++++++++");
            System.out.println("Open database: " + _dbName);

            try {
                String connStr = new String("jdbc:sqlite:");
                connStr = connStr + _dbName;

                // STEP: Register JDBC driver
                Class.forName("org.sqlite.JDBC");

                // STEP: Open a connection
                c = DriverManager.getConnection(connStr);

                // STEP: Diable auto transactions
                c.setAutoCommit(false);

                isConnected = true;
                System.out.println("success");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }

            System.out.println("++++++++++++++++++++++++++++++++++");
        }
    }

    private void closeConnection() {
        if (true == isConnected) {
            System.out.println("++++++++++++++++++++++++++++++++++");
            System.out.println("Close database: " + dbName);

            try {
                // STEP: Close connection
                c.close();

                isConnected = false;
                dbName = "";
                System.out.println("success");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }

            System.out.println("++++++++++++++++++++++++++++++++++");
        }
    }

    private void createTable() {
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("Create table");

        try {
            Statement stmt = c.createStatement();

            String sql = "CREATE TABLE warehouse (" +
                "w_warehousekey DECIMAL(9,0) NOT NULL," +
                "w_name CHAR(100) NOT NULL," +
                "w_capacity DECIMAL(6,0) NOT NULL," +
                "w_suppkey DECIMAL(9,0) NOT NULL," +
                "w_nationkey DECIMAL(2,0) NOT NULL)";
            stmt.executeUpdate(sql);

            c.commit();

            stmt.close();
            System.out.println("success");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            try{
                c.rollback();
            } catch (Exception e1) {
                System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
            }
        }

        System.out.println("++++++++++++++++++++++++++++++++++");
    }

    private void populateTable() {
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("Populate table");

        try{
        String sql = "INSERT INTO warehouse VALUES(?, ?, ?, ?, ?)";
        PreparedStatement stmt = c.prepareStatement(sql);

        int wKey = 1;
        int sKey = 1;
        int wCap = 0;
        String wName8 = "Supplier#00000000"; // suppKey < 10
        String wName7 =	"Supplier#0000000"; // 10 < suppKey < 100
        String wName6 =	"Supplier#000000"; // suppKey >= 100
            
        ///////////////////////////////////////////////////////
        wCap = 2044; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "EGYPT"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "ROMANIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 19); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1876; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "VIETNAM"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 21); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "SAUDI ARABIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 20); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2006; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "ALGERIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 0); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "JAPAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 12); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2246; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "IRAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1730; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "EGYPT");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1732; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "IRAN"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "CANADA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();
        sKey++;        
        //////////////////////////////////////////////////////
        wCap = 1894; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "ROMANIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 19); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2088; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "EGYPT");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1794; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "EGYPT"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName8 + sKey + "___" + "IRAQ");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 11); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1928; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "GERMANY"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 7); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1840; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ROMANIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 19); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1618; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "SAUDI ARABIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 20); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "INDONESIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 9); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1872; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "MOZAMBIQUE");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 16); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2130; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2256; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "SAUDI ARABIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 20); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1972; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "SAUDI ARABIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 20); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1740; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "INDONESIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 9); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ROMANIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 19); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2046; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ROMANIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 19); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2436; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ROMANIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 19); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1908; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "UNITED STATES");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 24); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1924; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2174; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "KENYA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 14); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "VIETNAM");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 21); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1726; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1788; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "INDONESIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 9); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ALGERIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 0); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1882; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ALGERIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 0); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1768; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "VIETNAM");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 21); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1864; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2274; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "MOZAMBIQUE"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 16); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "INDONESIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 9); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1538; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "JAPAN"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 12); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "INDONESIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 9); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2108; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1600; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ALGERIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 0); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1942; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "INDIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 8); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1578; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "JAPAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 12); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1698; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ALGERIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 0); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "MOZAMBIQUE");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 16); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1932; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ROMANIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 19); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1504; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ALGERIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 0); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2046; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2200; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "JAPAN"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 12); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ROMANIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 19); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1978; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "SAUDI ARABIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 20); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1922; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "INDONESIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 9); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2088; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ALGERIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 0); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1770; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "UNITED KINGDOM");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 23); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1992; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2090; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "MOZAMBIQUE"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 16); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1932; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2334; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "MOZAMBIQUE"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 16); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1748; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "SAUDI ARABIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 20); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "INDONESIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 9); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2272; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "JAPAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 12); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2020; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "UNITED KINGDOM");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 23); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2070; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "SAUDI ARABIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 20); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "GERMANY");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 7); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2764; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "SAUDI ARABIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 20); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2018; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1894; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "JAPAN"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 12); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1892; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "SAUDI ARABIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 20); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2018; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "UNITED KINGDOM"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 23); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAQ");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 11); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2076; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "MOROCCO"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 15); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1692; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "GERMANY");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 7); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1746; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ALGERIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 0); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2008; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1868; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "GERMANY");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 7); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1930; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1866; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "INDONESIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 9); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1852; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "MOZAMBIQUE");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 16); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2184; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1646; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2330; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1680; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "UNITED KINGDOM");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 23); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2108; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ETHIOPIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 5); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1770; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1780; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "INDONESIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 9); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ROMANIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 19); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2178; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ALGERIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 0); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1832; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2588; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "JAPAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 12); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1668; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2100; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "SAUDI ARABIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 20); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1850; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2134; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "KENYA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 14); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1964; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1964; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ARGENTINA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 1); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1700; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1776; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ALGERIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 0); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "JAPAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 12); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2008; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2016; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1980; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "MOROCCO");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 15); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1756; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "JORDAN"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 13); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "UNITED KINGDOM");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 23); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1926; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "MOROCCO");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 15); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2114; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "SAUDI ARABIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 20); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1752; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ALGERIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 0); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "VIETNAM");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 21); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1936; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ALGERIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 0); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1858; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "MOROCCO");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 15); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1696; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ALGERIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 0); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "KENYA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 14); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1694; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "JAPAN"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 12); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "ALGERIA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 0); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1680; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "JORDAN"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 13); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "MOROCCO");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 15); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1980; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1686; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "EGYPT"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 4); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2054; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "MOROCCO"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 15); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1978; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "JAPAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 12); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1872; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "CANADA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 3); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "IRAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 2454; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "INDONESIA"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 9); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName7 + sKey + "___" + "BRAZIL");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 2); //change
        stmt.addBatch();
        sKey++;
        //////////////////////////////////////////////////////
        wCap = 1874; //change
        stmt.setInt(1, wKey++);
        stmt.setString(2, wName6 + sKey + "___" + "IRAN"); //change
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 10); //change
        stmt.addBatch();

        stmt.setInt(1, wKey++);
        stmt.setString(2, wName6 + sKey + "___" + "JAPAN");
        stmt.setInt(3, wCap);
        stmt.setInt(4, sKey);
        stmt.setInt(5, 12); //change
        stmt.addBatch();
        sKey++;

        stmt.executeBatch();

        c.commit();
        stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            try{
                c.rollback();
            } catch (Exception e1) {
                System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
            }
        }
        
        System.out.println("++++++++++++++++++++++++++++++++++");
    }

    private void dropTable() {
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("Drop table");

        try {
            Statement stmt = c.createStatement();

            String sql = "DROP TABLE IF EXISTS warehouse";
            stmt.executeUpdate(sql);

            c.commit();

            stmt.close();
            System.out.println("success");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            try{
                c.rollback();
            } catch (Exception e1) {
                System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
            }
        }

        System.out.println("++++++++++++++++++++++++++++++++++");
    }

    private void Q1() {
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("Q1");

        try {
            FileWriter writer = new FileWriter("output/1.out", false);
            PrintWriter printer = new PrintWriter(writer);

            String sql = "SELECT w_warehousekey, w_name, w_capacity, w_suppkey, w_nationkey " +
            "FROM warehouse " +
            "ORDER BY w_warehousekey";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            printer.printf("%10s %-40s %10s %10s %10s\n", "wId", "wName", "wCap", "sId", "nId");

            while(rs.next()){
                int wId = rs.getInt(1);
                String wName = rs.getString(2);
                int wCap = rs.getInt(3);
                int sId = rs.getInt(4);
                int nId = rs.getInt(5);
                printer.printf("%10s %-40s %10s %10s %10s\n", wId, wName, wCap, sId, nId);
            }
            rs.close();
            stmt.close();
            printer.close();
            writer.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        System.out.println("++++++++++++++++++++++++++++++++++");
    }

    private void Q2() {
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("Q2");

        try {
            FileWriter writer = new FileWriter("output/2.out", false);
            PrintWriter printer = new PrintWriter(writer);

            printer.printf("%-40s %10s %10s\n", "nation", "numW", "totCap");

            String sql = "SELECT n_name, count(w_nationkey), sum(w_capacity) " +
            "FROM nation, warehouse " +
            "WHERE n_nationkey = w_nationkey " +
            "GROUP BY n_name " +
            "ORDER BY count(w_nationkey) DESC, sum(w_capacity) DESC";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String nation = rs.getString(1);
                int numW = rs.getInt(2);
                int totCap = rs.getInt(3);
                printer.printf("%-40s %10s %10s\n", nation, numW, totCap);
            }

            rs.close();
            stmt.close();
            printer.close();
            writer.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }


        System.out.println("++++++++++++++++++++++++++++++++++");
    }

    private void Q3() {
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("Q3");

        try {
            File fn = new File("input/3.in");
            FileReader reader = new FileReader(fn);
            BufferedReader in = new BufferedReader(reader);
            String nation = in.readLine();
            in.close();

            FileWriter writer = new FileWriter("output/3.out", false);
            PrintWriter printer = new PrintWriter(writer);

            printer.printf("%-20s %-20s %-40s\n", "supplier", "nation", "warehouse");

            String sql = "SELECT s_name, n_name, w_name " +
            "FROM warehouse, nation, supplier " +
            "WHERE w_name LIKE '%JAPAN' AND " +
            "s_suppkey = w_suppkey AND " +
            "s_nationkey = n_nationkey " +
            "GROUP BY s_name";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String supplier = rs.getString(1);
                String nations = rs.getString(2);
                String warehouse = rs.getString(3);
                printer.printf("%-20s %-20s %-40s\n", supplier, nations, warehouse);
            }

            rs.close();
            stmt.close();
            printer.close();
            writer.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        System.out.println("++++++++++++++++++++++++++++++++++");
    }

    private void Q4() {
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("Q4");

        try {
            File fn = new File("input/4.in");
            FileReader reader = new FileReader(fn);
            BufferedReader in = new BufferedReader(reader);
            String region = in.readLine();
            int cap = Integer.parseInt(in.readLine());
            in.close();

            FileWriter writer = new FileWriter("output/4.out", false);
            PrintWriter printer = new PrintWriter(writer);

            printer.printf("%-40s %10s\n", "warehouse", "capacity");

            String sql = "SELECT w_name, w_capacity " +
            "FROM warehouse, region, nation " +
            "WHERE w_nationkey = n_nationkey AND " +
            "n_regionkey = r_regionkey AND " +
            "r_name = 'ASIA' AND " +
            "w_capacity > 2000 " +
            "ORDER BY w_capacity DESC";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String warehouse = rs.getString(1);
                int capacity = rs.getInt(2);
                printer.printf("%-40s %10s\n", warehouse, capacity);
            }

            rs.close();
            stmt.close();
            printer.close();
            writer.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        System.out.println("++++++++++++++++++++++++++++++++++");
    }

    private void Q5() {
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("Q5");

        try {
            File fn = new File("input/5.in");
            FileReader reader = new FileReader(fn);
            BufferedReader in = new BufferedReader(reader);
            String nation = in.readLine();
            in.close();

            FileWriter writer = new FileWriter("output/5.out", false);
            PrintWriter printer = new PrintWriter(writer);

            printer.printf("%-20s %20s\n", "region", "capacity");

            String sql = "SELECT r_name, sum(w_capacity) " +
                "FROM warehouse, nation nat1, nation nat2, supplier, region " +
                "WHERE w_suppkey = s_suppkey AND " +
                "w_nationkey = nat2.n_nationkey AND " +
                "nat1.n_nationkey = s_nationkey AND " +
                "nat2.n_regionkey = r_regionkey AND " +
                "nat1.n_name = 'UNITED STATES' " +
                "GROUP BY r_name";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String region = rs.getString(1);
                int capacity = rs.getInt(2);
                printer.printf("%-20s %20s\n", region, capacity);
            }

            rs.close();
            stmt.close();
            printer.close();
            writer.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        System.out.println("++++++++++++++++++++++++++++++++++");
    }


    public static void main(String args[]) {
        Lab_7 sj = new Lab_7();
        
        sj.openConnection("data/tpch.sqlite");

        sj.dropTable();
        sj.createTable();
        sj.populateTable();

        sj.Q1();
        sj.Q2();
        sj.Q3();
        sj.Q4();
        sj.Q5(); // I couldn't figure out ASIA

        sj.closeConnection();
    }
}
