package data;

import com.github.javafaker.Faker;
import model.Horse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.lang.*;

public class
HorseDao {

    private static HorseDao instance;
    private static List<Horse> horseDatabase;
    String url = "jdbc:postgresql://localhost:5432/HorseProject";
    private HorseDao() {
        horseDatabase = new ArrayList<>();
    }

    public static HorseDao getInstance() {
        if(instance == null) {
            instance = new HorseDao();
        }

        return instance;
    }

    public void generateHorses()  {







        //props.setProperty("user", "postgres");
        //props.setProperty("password", "password");


        //put statement in another method, pass connection to another method

        //props.setProperty("user", "postgres");
        //props.setProperty("password", "password");

        //Statement stmt = conn.createStatement();
        //stmt.execute("end;");
        //stmt.execute("set search_path to 'ExpressRailway'");
        //stmt.execute("begin;");
        //stmt.execute("set constraints all deferred;");
            for (int i = 0; i < 25; i++) {

                Faker faker = new Faker();

                String horseName = faker.name().firstName();
                String countryOfOrigin = faker.country().name();
                String horseBreed = (ThreadLocalRandom.current().nextInt(0, 2) == 0) ? "Standardbred" : "Thoroughbred";
                String sex = (ThreadLocalRandom.current().nextInt(0, 2) == 0) ? "Male" : "Female";
                String gait = (ThreadLocalRandom.current().nextInt(0, 2) == 0) ? "Trotter" : "Pacer";
                String raceType = (ThreadLocalRandom.current().nextInt(0, 2) == 0) ? "Time Trial" : "Qualifier";
                String comment = "";
                String sireName = "";
                String damName = "";

                int yearOfBirth = ThreadLocalRandom.current().nextInt(1950, 2019);

                horseDatabase.add(new Horse(String.valueOf(i), horseName, horseBreed, yearOfBirth, countryOfOrigin, sex, gait, raceType, comment, sireName, damName));
            }


    }
        //feature Id like to implent here is a trie structure of the horses. we can use this to update the columns in the search function
    public List<Horse> getHorseDatabase() {
        List<Horse> toAdd = new ArrayList<Horse>();
        try{
            // We could take this and just add it to SQL Statements or like a config but needs some sort of hashing
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url,"postgres","DJcoco12%");
            //to here
            Statement stmt = conn.createStatement();
            stmt.execute("set search_path to 'HorseProject'");
            ResultSet horses = stmt.executeQuery(SQLStatements.SELECT_ALL_HORSES());
            while(horses.next()){
                toAdd.add(new Horse(horses.getString("horseid"),
                        horses.getString("name"),
                        horses.getString("breed"),
                        horses.getInt("yob"),
                        horses.getString("coo"),
                        horses.getString("sex"),
                        horses.getString("gait"),
                        "nta",
                        horses.getString("comment"),
                        "hello",
                        "hello"));
                // need to add sql queries to find dependencies but also might consider adding tables for dam names and such as finding father and mother will be costly
            }
            conn.close();
        }
        catch(Exception E){
            E.printStackTrace();
        }
        return toAdd;
    }

}
