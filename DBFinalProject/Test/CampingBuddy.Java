
// STEP: Import required packages
import java.sql.*;
// import java.io.FileWriter;
// import java.io.FileReader;
// import java.io.BufferedReader;
// import java.io.PrintWriter;
// import java.lang.invoke.SwitchPoint;
// import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class campingBuddy {

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

                // STEP: Disable auto transactions
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

    // private void Q5() {
    // System.out.println("++++++++++++++++++++++++++++++++++");
    // System.out.println("Q5");

    // try {
    // File fn = new File("input/5.in");
    // FileReader reader = new FileReader(fn);
    // BufferedReader in = new BufferedReader(reader);
    // String nation = in.readLine();
    // in.close();

    // FileWriter writer = new FileWriter("output/5.out", false);
    // PrintWriter printer = new PrintWriter(writer);

    // printer.printf("%-20s %20s\n", "region", "capacity");

    // String sql = "SELECT r_name, sum(w_capacity) " +
    // "FROM warehouse, nation nat1, nation nat2, supplier, region " +
    // "WHERE w_suppkey = s_suppkey AND " +
    // "w_nationkey = nat2.n_nationkey AND " +
    // "nat1.n_nationkey = s_nationkey AND " +
    // "nat2.n_regionkey = r_regionkey AND " +
    // "nat1.n_name = 'UNITED STATES' " +
    // "GROUP BY r_name";

    // PreparedStatement stmt = c.prepareStatement(sql);
    // ResultSet rs = stmt.executeQuery();

    // while(rs.next()){
    // String region = rs.getString(1);
    // int capacity = rs.getInt(2);
    // printer.printf("%-20s %20s\n", region, capacity);
    // }

    // rs.close();
    // stmt.close();
    // printer.close();
    // writer.close();
    // } catch (Exception e) {
    // System.err.println(e.getClass().getName() + ": " + e.getMessage());
    // }

    // System.out.println("++++++++++++++++++++++++++++++++++");
    // }

    public void Trails(String park) {
        // scanner initialization
        Scanner sd = new Scanner(System.in);

        // default option
        System.out.println("Above you selected Trails, what would you like to "
                + "know? (Select the number adjacent to the info)");

        // a list containing all options for campsite queries
        List<String> options = Arrays.asList("1. QQQQQQQ QUESTION1", "2. QQQQQQQ QUESTION2", "3. QQQQQQQ QUESTION3",
                "0. I'm good, show me the info!");

        // prints the list
        for (String k : options) {
            System.out.println("\t" + k);
        }

        // Array list creation. infoCamps is a COPY of the questions list.
        ArrayList<String> infoAll = new ArrayList<String>();
        infoAll.addAll(options);
        // infoSelected is a list containing the string version of the
        // choices made.
        ArrayList<String> infoSelected = new ArrayList<String>();
        // infoNumbers is a list containing the integer versions of the
        // choices made.
        ArrayList<Integer> infoNumbers = new ArrayList<Integer>();

        // user chooses an option
        int userInfoChoice = sd.nextInt();

        // until the user selects the 0 option, the lists change.
        while (userInfoChoice != 0) {

            // inputs index that's 1 lower than the user choice, i.e. user 1 = programmer 0
            infoNumbers.add(userInfoChoice);
            // inputs string of the user choice.
            infoSelected.add(infoAll.get(userInfoChoice - 1));

            // prints the selected options so far
            System.out.print("You've selected: ");
            for (String j : infoSelected) {
                System.out.print("\t" + j + "\n");
            }

            // prmpt the user to stop or continue
            System.out.println(
                    "What other information would you like to " + "know? (Select the number adjacent to the info)");

            // presents the options again.
            for (String m : infoAll) {
                System.out.println("\t" + m);
            }

            // next choice of user, 0 exits the while loop
            userInfoChoice = sd.nextInt();
        }

        // for loop to know which info selections were made
        for (int j : infoNumbers) {
            // switch case for each query of camps
            switch (j) {
                case 1: // QUESTION1
                    System.out.println("QQQQQQQANSWER STATEMENT");
                    try {
                        String sql = "QQQQQQQ SQL STATEMENT";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;

                case 2: // QUESTION2
                    System.out.println("QQQQQQQANSWER STATEMENT");
                    try {
                        String sql = "QQQQQQQ SQL STATEMENT";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;

                case 3: // QUESTION3
                    System.out.println("QQQQQQQANSWER STATEMENT");
                    try {
                        String sql = "QQQQQQQ SQL STATEMENT";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;
            }
        }
    }

    public void Species(String park) {
        // scanner initialization
        Scanner sd = new Scanner(System.in);

        // default option
        System.out.println("Above you selected QQQQQQQ TOPIC, what would you like to "
                + "know? (Select the number adjacent to the info)");

        // a list containing all options for campsite queries
        List<String> options = Arrays.asList("1. QQQQQQQ QUESTION1", "2. QQQQQQQ QUESTION2", "3. QQQQQQQ QUESTION3",
                "0. I'm good, show me the info!");

        // prints the list
        for (String k : options) {
            System.out.println("\t" + k);
        }

        // Array list creation. infoCamps is a COPY of the questions list.
        ArrayList<String> infoAll = new ArrayList<String>();
        infoAll.addAll(options);
        // infoSelected is a list containing the string version of the
        // choices made.
        ArrayList<String> infoSelected = new ArrayList<String>();
        // infoNumbers is a list containing the integer versions of the
        // choices made.
        ArrayList<Integer> infoNumbers = new ArrayList<Integer>();

        // user chooses an option
        int userInfoChoice = sd.nextInt();

        // until the user selects the 0 option, the lists change.
        while (userInfoChoice != 0) {

            // inputs index that's 1 lower than the user choice, i.e. user 1 = programmer 0
            infoNumbers.add(userInfoChoice);
            // inputs string of the user choice.
            infoSelected.add(infoAll.get(userInfoChoice - 1));

            // prints the selected options so far
            System.out.print("You've selected: ");
            for (String j : infoSelected) {
                System.out.print("\t" + j + "\n");
            }

            // prmpt the user to stop or continue
            System.out.println(
                    "What other information would you like to " + "know? (Select the number adjacent to the info)");

            // presents the options again.
            for (String m : infoAll) {
                System.out.println("\t" + m);
            }

            // next choice of user, 0 exits the while loop
            userInfoChoice = sd.nextInt();
        }

        // for loop to know which info selections were made
        for (int j : infoNumbers) {
            // switch case for each query of camps
            switch (j) {
                case 1: // QUESTION1
                    System.out.println("QQQQQQQANSWER STATEMENT");
                    try {
                        String sql = "QQQQQQQ SQL STATEMENT";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;

                case 2: // QUESTION2
                    System.out.println("QQQQQQQANSWER STATEMENT");
                    try {
                        String sql = "QQQQQQQ SQL STATEMENT";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;

                case 3: // QUESTION3
                    System.out.println("QQQQQQQANSWER STATEMENT");
                    try {
                        String sql = "QQQQQQQ SQL STATEMENT";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;
            }
        }
    }

    public void Plants(String park) {
        // scanner initialization
        Scanner sd = new Scanner(System.in);

        // default option
        System.out.println("Above you selected QQQQQQQ TOPIC, what would you like to "
                + "know? (Select the number adjacent to the info)");

        // a list containing all options for campsite queries
        List<String> options = Arrays.asList("1. QQQQQQQ QUESTION1", "2. QQQQQQQ QUESTION2", "3. QQQQQQQ QUESTION3",
                "0. I'm good, show me the info!");

        // prints the list
        for (String k : options) {
            System.out.println("\t" + k);
        }

        // Array list creation. infoCamps is a COPY of the questions list.
        ArrayList<String> infoAll = new ArrayList<String>();
        infoAll.addAll(options);
        // infoSelected is a list containing the string version of the
        // choices made.
        ArrayList<String> infoSelected = new ArrayList<String>();
        // infoNumbers is a list containing the integer versions of the
        // choices made.
        ArrayList<Integer> infoNumbers = new ArrayList<Integer>();

        // user chooses an option
        int userInfoChoice = sd.nextInt();

        // until the user selects the 0 option, the lists change.
        while (userInfoChoice != 0) {

            // inputs index that's 1 lower than the user choice, i.e. user 1 = programmer 0
            infoNumbers.add(userInfoChoice);
            // inputs string of the user choice.
            infoSelected.add(infoAll.get(userInfoChoice - 1));

            // prints the selected options so far
            System.out.print("You've selected: ");
            for (String j : infoSelected) {
                System.out.print("\t" + j + "\n");
            }

            // prmpt the user to stop or continue
            System.out.println(
                    "What other information would you like to " + "know? (Select the number adjacent to the info)");

            // presents the options again.
            for (String m : infoAll) {
                System.out.println("\t" + m);
            }

            // next choice of user, 0 exits the while loop
            userInfoChoice = sd.nextInt();
        }

        // for loop to know which info selections were made
        for (int j : infoNumbers) {
            // switch case for each query of camps
            switch (j) {
                case 1: // QUESTION1
                    System.out.println("QQQQQQQANSWER STATEMENT");
                    try {
                        String sql = "QQQQQQQ SQL STATEMENT";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;

                case 2: // QUESTION2
                    System.out.println("QQQQQQQANSWER STATEMENT");
                    try {
                        String sql = "QQQQQQQ SQL STATEMENT";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;

                case 3: // QUESTION3
                    System.out.println("QQQQQQQANSWER STATEMENT");
                    try {
                        String sql = "QQQQQQQ SQL STATEMENT";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;
            }
        }
    }

    public void Park_Temps(String park) {
        // scanner initialization
        Scanner sd = new Scanner(System.in);

        // default option
        System.out.println("Above you selected Monthly Average Temperature, what would you like to "
                + "know? (Select the number adjacent to the info)");

        // a list containing all options for campsite queries
        List<String> options = Arrays.asList("1. What are the month of ... average highs and lows", "2. What are the month of ... average highs and lows",
                 "3. What are the month of ... average highs and lows", "0. I'm good, show me the info!");

        // prints the list
        for (String k : options) {
            System.out.println("\t" + k);
        }

        // Array list creation. infoCamps is a COPY of the questions list.
        ArrayList<String> infoAll = new ArrayList<String>();
        infoAll.addAll(options);
        // infoSelected is a list containing the string version of the
        // choices made.
        ArrayList<String> infoSelected = new ArrayList<String>();
        // infoNumbers is a list containing the integer versions of the
        // choices made.
        ArrayList<Integer> infoNumbers = new ArrayList<Integer>();

        // user chooses an option
        int userInfoChoice = sd.nextInt();

        // until the user selects the 0 option, the lists change.
        while (userInfoChoice != 0) {

            // inputs index that's 1 lower than the user choice, i.e. user 1 = programmer 0
            infoNumbers.add(userInfoChoice);
            // inputs string of the user choice.
            infoSelected.add(infoAll.get(userInfoChoice - 1));

            // prints the selected options so far
            System.out.print("You've selected: ");
            for (String j : infoSelected) {
                System.out.print("\t" + j + "\n");
            }

            // prmpt the user to stop or continue
            System.out.println(
                    "What other information would you like to " + "know? (Select the number adjacent to the info)");

            // presents the options again.
            for (String m : infoAll) {
                System.out.println("\t" + m);
            }

            // next choice of user, 0 exits the while loop
            userInfoChoice = sd.nextInt();
        }

        // for loop to know which info selections were made
        for (int j : infoNumbers) {
            // switch case for each query of camps
            switch (j) {
                case 1: // QUESTION1
                    System.out.println("QQQQQQQANSWER STATEMENT");
                    try {
                        String sql = "QQQQQQQ SQL STATEMENT";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;

                case 2: // QUESTION2
                    System.out.println("QQQQQQQANSWER STATEMENT");
                    try {
                        String sql = "QQQQQQQ SQL STATEMENT";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;

                case 3: // QUESTION3
                    System.out.println("QQQQQQQANSWER STATEMENT");
                    try {
                        String sql = "QQQQQQQ SQL STATEMENT";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;
            }
        }
    }

    public void Park_Precipitation(String park) {

        // scanner initialization
        Scanner sd = new Scanner(System.in);

        // default option
        System.out.println("Above you selected monthly precipitation, what would you like to "
                + "know? (Select the number adjacent to the info)");

        // a list containing all options for campsite queries
        List<String> options = Arrays.asList("1. What is they yearly rainfall?",
                "2. Which park gets the most annual precipitation?",
                "3. Which park gets the least annual precipitation?", "0. I'm good, show me the info!");

        // prints the list
        for (String k : options) {
            System.out.println("\t" + k);
        }

        // Array list creation. infoCamps is a COPY of the questions list.
        ArrayList<String> infoAll = new ArrayList<String>();
        infoAll.addAll(options);
        // infoSelected is a list containing the string version of the
        // choices made.
        ArrayList<String> infoSelected = new ArrayList<String>();
        // infoNumbers is a list containing the integer versions of the
        // choices made.
        ArrayList<Integer> infoNumbers = new ArrayList<Integer>();

        // user chooses an option
        int userInfoChoice = sd.nextInt();

        // until the user selects the 0 option, the lists change.
        while (userInfoChoice != 0) {

            // inputs index that's 1 lower than the user choice, i.e. user 1 = programmer 0
            infoNumbers.add(userInfoChoice);
            // inputs string of the user choice.
            infoSelected.add(infoAll.get(userInfoChoice - 1));

            // prints the selected options so far
            System.out.print("You've selected: ");
            for (String j : infoSelected) {
                System.out.print("\t" + j + "\n");
            }

            // prmpt the user to stop or continue
            System.out.println(
                    "What other information would you like to " + "know? (Select the number adjacent to the info)");

            // presents the options again.
            for (String m : infoAll) {
                System.out.println("\t" + m);
            }

            // next choice of user, 0 exits the while loop
            userInfoChoice = sd.nextInt();
        }

        // for loop to know which info selections were made
        for (int j : infoNumbers) {
            // switch case for each query of camps
            switch (j) {
                case 1: // Total precipitation?
                    System.out.println("At " + park + " the total annual precipitation (inches) is: ");
                    try {
                        String sql = "SELECT (pp_Jan_Precipitation + pp_Feb_Precipitation + pp_Mar_Precipitation + "
                                + "pp_Apr_Precipitation + pp_May_Precipitation + pp_Jun_Precipitation + "
                                + "pp_Jul_Precipitation + pp_Aug_Precipitation + pp_Sep_Precipitation + "
                                + "pp_Oct_Precipitation + pp_Nov_Precipitation + pp_Dec_Precipitation) AS total "
                                + "FROM Park_Precipitation " + "WHERE pp_Park_Name =  '" + park + "' ";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;

                case 2: // Which park gets the most annual rain?
                    System.out.println("The park with the most annual precipitation (inches) is: ");
                    try {
                        String sql = "SELECT precipAmount.pp_Park_Name, max(precipAmount.total) "
                                + "FROM (SELECT DISTINCT pp_Park_Name, (pp_Jan_Precipitation + pp_Feb_Precipitation + pp_Mar_Precipitation + "
                                + "pp_Apr_Precipitation + pp_May_Precipitation + pp_Jun_Precipitation + "
                                + "pp_Jul_Precipitation + pp_Aug_Precipitation + pp_Sep_Precipitation + "
                                + "pp_Oct_Precipitation + pp_Nov_Precipitation + pp_Dec_Precipitation) AS total "
                                + "FROM Park_Precipitation) precipAmount; ";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;

                case 3: // Which park gets the least annual precipitation
                    System.out.println("The park with the least annual precipitation (inches) is: ");
                    try {
                        String sql = "SELECT precipAmount.pp_Park_Name, min(precipAmount.total) "
                                + "FROM (SELECT DISTINCT pp_Park_Name, (pp_Jan_Precipitation + pp_Feb_Precipitation + pp_Mar_Precipitation + "
                                + "pp_Apr_Precipitation + pp_May_Precipitation + pp_Jun_Precipitation + "
                                + "pp_Jul_Precipitation + pp_Aug_Precipitation + pp_Sep_Precipitation + "
                                + "pp_Oct_Precipitation + pp_Nov_Precipitation + pp_Dec_Precipitation) AS total "
                                + "FROM Park_Precipitation) precipAmount; ";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;
            }
        }
    }

    public void Park_Locations(String park) {

        // scanner initialization
        Scanner sd = new Scanner(System.in);

        // default option
        System.out.println("Above you selected Geo Location, what would you like to "
                + "know? (Select the number adjacent to the info)");

        // a list containing all options for campsite queries
        List<String> options = Arrays.asList("1. What is the latitude and longitude of the Park?",
                "2. How many acres is the park?", "3. Do any parks also extend into other states?",
                "0. I'm good, show me the info!");

        // prints the list
        for (String k : options) {
            System.out.println("\t" + k);
        }

        // Array list creation. infoCamps is a COPY of the questions list.
        ArrayList<String> infoAll = new ArrayList<String>();
        infoAll.addAll(options);
        // infoSelected is a list containing the string version of the
        // choices made.
        ArrayList<String> infoSelected = new ArrayList<String>();
        // infoNumbers is a list containing the integer versions of the
        // choices made.
        ArrayList<Integer> infoNumbers = new ArrayList<Integer>();

        // user chooses an option
        int userInfoChoice = sd.nextInt();

        // until the user selects the 0 option, the lists change.
        while (userInfoChoice != 0) {

            // inputs index that's 1 lower than the user choice, i.e. user 1 = programmer 0
            infoNumbers.add(userInfoChoice);
            // inputs string of the user choice.
            infoSelected.add(infoAll.get(userInfoChoice - 1));

            // prints the selected options so far
            System.out.print("You've selected: ");
            for (String j : infoSelected) {
                System.out.print("\t" + j + "\n");
            }

            // prmpt the user to stop or continue
            System.out.println(
                    "What other information would you like to " + "know? (Select the number adjacent to the info)");

            // presents the options again.
            for (String m : infoAll) {
                System.out.println("\t" + m);
            }

            // next choice of user, 0 exits the while loop
            userInfoChoice = sd.nextInt();
        }

        // for loop to know which info selections were made
        for (int j : infoNumbers) {
            // switch case for each query of camps
            switch (j) {
                case 1: // What is the latitude and longitude of the Park?
                    System.out.println("The latitude/longitude of " + park + " is: ");
                    try {

                        String sql = "SELECT p_Latitude, p_Longitude " + "FROM Park_Locations "
                                + "WHERE p_Park_Name = '" + park + "' ";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            String var2 = rs.getString(2);
                            System.out.println("\t" + var1 + "/" + var2);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;

                case 2: // How many acres is the park?
                    System.out.println("At " + park + " there are: ");
                    try {

                        String sql = "SELECT p_Acres " + "FROM Park_Locations " + "WHERE p_Park_Name = '" + park + "' ";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            System.out.print("\t" + var1);
                            System.out.print(" acres.\n");
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;

                case 3: // Do any parks also extend into other states?
                    System.out.println("The park(s) that extend into another state are: ");
                    try {

                        String sql = "SELECT p_Park_Name, p_State " + "FROM Park_Locations "
                                + "WHERE p_State LIKE '%,%';";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            String var2 = rs.getString(2);
                            System.out.println("\t" + var1 + "(" + var2 + ")");
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;
            }
        }
    }

    public void Campsites(String park) {

        // scanner initialization
        Scanner sd = new Scanner(System.in);

        // default option
        System.out.println("Above you selected Campsites, what would you like to "
                + "know? (Select the number adjacent to the info)");

        // a list containing all options for campsite queries
        List<String> options = Arrays.asList("1. What types of Campsites are there?",
                "2. How many campsites are available?", "3. How many facilites are there?",
                "0. I'm good, show me the info!");

        // prints the list
        for (String k : options) {
            System.out.println("\t" + k);
        }

        // Array list creation. infoCamps is a COPY of the questions list.
        ArrayList<String> infoCamps = new ArrayList<String>();
        infoCamps.addAll(options);
        // infoSelected is a list containing the string version of the
        // choices made.
        ArrayList<String> infoSelected = new ArrayList<String>();
        // infoNumbers is a list containing the integer versions of the
        // choices made.
        ArrayList<Integer> infoNumbers = new ArrayList<Integer>();

        // user chooses an option
        int campInfoChoice = sd.nextInt();

        // until the user selects the 0 option, the lists change.
        while (campInfoChoice != 0) {

            // inputs index that's 1 lower than the user choice, i.e. user 1 = programmer 0
            infoNumbers.add(campInfoChoice);
            // inputs string of the user choice.
            infoSelected.add(infoCamps.get(campInfoChoice - 1));

            // prints the selected options so far
            System.out.print("You've selected: ");
            for (String j : infoSelected) {
                System.out.print("\t" + j + "\n");
            }

            // prmpt the user to stop or continue
            System.out.println(
                    "What other information would you like to " + "know? (Select the number adjacent to the info)");

            // presents the options again.
            for (String m : infoCamps) {
                System.out.println("\t" + m);
            }

            // next choice of user, 0 exits the while loop
            campInfoChoice = sd.nextInt();
        }

        // for loop to know which info selections were made
        for (int j : infoNumbers) {
            // switch case for each query of camps
            switch (j) {
                case 1: // What type of campsites in this park are there?
                    System.out.println("These are the types of campsites available at " + park + ": ");
                    try {

                        String sql = "SELECT c_Campsite_Type " + "FROM Campsites " + "WHERE c_Park_Name = '" + park
                                + "' " + "GROUP BY c_Campsite_Type; ";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            String var1 = rs.getString(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;

                case 2: // How many campsites are available?
                    System.out.println("The number of campsites at " + park + " is: ");
                    try {

                        String sql = "SELECT count(*) " + "FROM Campsites " + "WHERE c_Park_Name = '" + park + "' ";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            int var1 = rs.getInt(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;

                case 3: // How many facilites are there?
                    System.out.println("The number of facilities at " + park + " are: ");
                    try {

                        String sql = "SELECT count(DISTINCT c_Facility_name) " + "FROM Campsites "
                                + "WHERE c_Park_Name = '" + park + "' ";

                        PreparedStatement stmt = c.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                            int var1 = rs.getInt(1);
                            System.out.println("\t" + var1);
                        }

                        rs.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    }
                    break;
            }
        }
    }

    public ArrayList<Integer> parkInfo() {

        Scanner sd = new Scanner(System.in);

        System.out.println("What information would you like to know? " + "(Select the number adjacent to the info)");

        List<String> options = Arrays.asList("1 Campsites", "2 Geo Location", "3 Monthly Precipitation",
                "4 Monthly Average Temperature", "5 Plant Species", "6 Animal Species", "7 Trails",
                "0 I'm good, I don't need any more information!");

        for (String k : options) {
            System.out.println("\t" + k);
        }

        ArrayList<String> infoParks = new ArrayList<String>();
        infoParks.addAll(options);
        ArrayList<String> infoSelected = new ArrayList<String>();
        ArrayList<Integer> infoNumbers = new ArrayList<Integer>();

        int parkInfoChoice = sd.nextInt();

        while (parkInfoChoice != 0) {

            infoSelected.add(infoParks.get(parkInfoChoice - 1));
            infoNumbers.add(parkInfoChoice);
            // infoParks.remove(parkInfoChoice - 1);
            System.out.print("You've selected: ");

            for (String j : infoSelected) {
                System.out.print(j + "\n");
            }

            System.out.println(
                    "What other information would you like to " + "know? (Select the number adjacent to the info)");

            for (String m : infoParks) {
                System.out.println("\t" + m);
            }

            parkInfoChoice = sd.nextInt();
        }

        return infoNumbers;
    }

    public String parkNames(int parkChosen) {
        int i = 0;
        String[] parkNamesArray = { "", "", "", "", "", "", "", "" };
        try {
            String sql = "SELECT p_Park_Name FROM Park_Locations";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String campsite = rs.getString(1);
                // System.out.println(campsite);
                parkNamesArray[i] = campsite;
                // System.out.println(parkNamesArray[i]);
                i++;
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return parkNamesArray[parkChosen - 1];
    }

    public int Introduction() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hi and welcome to Camping Buddy!  I\u2019m an app that "
                + "can get you the information you seek about California National Parks!  :)\n");
        System.out.println("First, Let\u2019s get some information from you.\n");
        System.out.println("Please select one of the following options:");
        System.out.println("1. Would you like to dive and see all available info?");
        System.out.println("\tOR");
        System.out.println("2. Look at some of our most popular queries");

        int initialChoice = sc.nextInt();
        if (initialChoice == 1) { // All info
            System.out.println("What park would you like to visit?  (Select the number adjacent to the park)");
            System.out.println("\t1. Channel Islands National Park");
            System.out.println("\t2. Joshua Tree National Park");
            System.out.println("\t3. Lassen Volcanic National Park");
            System.out.println("\t4. Pinnacles National Park");
            System.out.println("\t5. Redwood National Park");
            System.out.println("\t6. Sequoia and Kings Canyon National Parks");
            System.out.println("\t7. Yosemite National Park");
            System.out.println("\t8. Death Valley National Park");
            System.out.println("\t0. I'm good, I don't need any information!\n");

            int parkChoice = sc.nextInt();
            // sc.close();
            return parkChoice;
        }

        else if (initialChoice == 2) { // Popular
            return 8;

        }

        else if (initialChoice == 6789) { // Admin privileges
            return 9;
        }

        else {// Mistake
            System.out.println("You have to select 1 or 2 only!");
        }

        return initialChoice;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        campingBuddy sj = new campingBuddy();

        // sj.openConnection("data/tpch.sqlite");
        sj.openConnection("DBFinalProject/Data/CAPark.sqlite");
        int firstChoice = sj.Introduction();
        String parkChoice = "default";
        if (firstChoice < 8) {
            parkChoice = sj.parkNames(firstChoice);
            System.out.println(parkChoice + ", great choice!\n");
            ArrayList<Integer> infoNumsChosen = new ArrayList<Integer>();
            infoNumsChosen = sj.parkInfo();
            Collections.sort(infoNumsChosen);
            for (int j : infoNumsChosen) {
                switch (j) {
                    case 1:
                        sj.Campsites(parkChoice);
                        System.out.println("OK, next up is...");
                        break;
                    case 2:
                        sj.Park_Locations(parkChoice);
                        System.out.println("OK, next up is...");
                        break;
                    case 3:
                        sj.Park_Precipitation(parkChoice);
                        System.out.println("OK, next up is...");
                        break;
                    case 4:
                        sj.Park_Temps(parkChoice);
                        System.out.println("OK, next up is...");
                        break;
                    case 5:
                        sj.Plants(parkChoice);
                        System.out.println("OK, next up is...");
                        break;
                    case 6:
                        sj.Species(parkChoice);
                        System.out.println("OK, next up is...");
                        break;
                    case 7:
                        sj.Trails(parkChoice);
                        System.out.println("OK, next up is...");
                        break;
                    case 8: // Premade suggested queries
                        break;
                    case 9: // Admin stuff
                        break;
                    default:
                        // code block
                }
            }
        }

        else if (firstChoice == 8) {
            ArrayList<Integer> infoNumsChosen = new ArrayList<Integer>();
            infoNumsChosen.add(8);
        }

        else if (firstChoice == 9) {
            ArrayList<Integer> infoNumsChosen = new ArrayList<Integer>();
            infoNumsChosen.add(9);
        }

        else {
            ArrayList<Integer> infoNumsChosen = new ArrayList<Integer>();
            infoNumsChosen.add(10);
        }

        System.out.println("Nothing! Mission complete! Have a good day!");

        sj.closeConnection();
        // sc.close();
    }
}