import db.DB;
import db.DbIntegrityExcepition;

import java.sql.*;


public class Main {

    public static void main(String[] args) {

       Connection conn = null;
       PreparedStatement st = null;
       try {
           conn = DB.getConnection();

           st = conn.prepareStatement(
                   "DELETE FROM department "
                   + "WHERE "
                   + "iD = ? "
           );

           st.setInt(1, 2);

           int rowsAffected = st.executeUpdate();

           System.out.println("Done! Rows affected: " + rowsAffected);

       } catch (SQLException e) {
           throw new DbIntegrityExcepition(e.getMessage());
       } finally {
           DB.closeStatement(st);
           DB.closeConnection();
       }

    }

}
