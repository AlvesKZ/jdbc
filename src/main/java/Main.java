import db.DB;
import db.DbExcepition;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Main {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "INSERT INTO seller "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                    + "VALUES "
                    + "(?, ?, ?, ?, ?)"
            );

            st.setString(1, "Carl");
            st.setString(2, "test@email.com");
            st.setDate(3, new java.sql.Date(sdf.parse("01/05/2026").getTime()));
            st.setDouble(4, 3000.0);
            st.setInt(5, 4);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! rows affected: " + rowsAffected);

        }
        catch (SQLException | ParseException e) {
            throw new DbExcepition(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }

}
