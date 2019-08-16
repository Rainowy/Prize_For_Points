package Services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbService {

    private static String dbUrl;
    //private static String dbName = "prize_for_points";
    private static String dbUser = "root";
    private static String dbPass = "sabaka";

    public static void initParams (String dbName){
        dbUrl = "jdbc:mysql://192.168.1.108/" + dbName + "?useSSL=false&characterEncoding=utf8&useLegacyDatetimeCode=false&serverTimezone=UTC&useOldAliasMetadataBehavior=true";

    }

    public static Connection getConnection(String dbName) throws SQLException {

        initParams(dbName);

        return DriverManager.getConnection(dbUrl,dbUser,dbPass);
    }

    public static void executeQuery(String query, String[] params,String dbName) throws SQLException{

        Connection conn = getConnection(dbName);

        PreparedStatement st = conn.prepareStatement(query);

        setParams(params, st);

        st.executeUpdate();

    }

    public static int executeInsert(String query, String[] params, String dbName) throws Exception{

        Connection conn = getConnection(dbName);

        String[] generatedKeys = {"ID"};

        PreparedStatement st = conn.prepareStatement(query,generatedKeys);

        setParams(params, st);

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if(rs.next()){
            int newId = rs.getInt(1);
            return newId;
        }
        else {
            throw new Exception("No new Id");
        }
    }

    public static List<String[]> getData (String query, String[] params, String dbName)throws SQLException{

        Connection conn = getConnection(dbName);

        PreparedStatement st = conn.prepareStatement(query);

        setParams(params, st);

        ResultSet rs = st.executeQuery();

        ResultSetMetaData metaData = rs.getMetaData();

        List<String[]> result = new ArrayList<>();

        while(rs.next()){
            String[] row = new String[metaData.getColumnCount()];
            for (int i = 1; i <=metaData.getColumnCount() ; i++) {   //iterujemy przez ilość kolumn
                String columnName = metaData.getColumnName(i);      //pobieramy nazwę konkretnej kolumny
                row[i-1] = rs.getString(columnName);                //wstawiamy do tablicy wartość pobraną z konkretnej kolumny na podstawie jej nazwy
            }
            result.add(row);
        }
        return result;
    }

    private static void setParams(String[] params, PreparedStatement st) throws SQLException {
        if(params != null){
            int paramNumber =1;
            for(String param : params){
                st.setString(paramNumber,param);
                paramNumber++;
            }
        }
    }
}
