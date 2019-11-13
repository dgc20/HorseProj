package data;

public class SQLStatements {
    public static String SELECT_ALL_HORSES(){
        return "SELECT * FROM horses as h join encodings e on e.horseid=h.horseid ";
    }
}
