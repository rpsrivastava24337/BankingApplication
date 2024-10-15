package accountclose;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnection;
import newAccount.AccountBean;

public class AccounCloseDAO {

	public AccountBean doClose(AccountBean ab) throws SQLException {

		AccountBean ab2 = null;
		Connection con = DBConnection.getCon();
		PreparedStatement ps = con.prepareStatement("select * from rpsbank where accno=?");
		ps.setString(1, ab.getAccNo());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			ab2 = new AccountBean();

			ab2.setAccNo(rs.getString(1));
			ab2.setUname(rs.getString(2));

			ab2.setPwd(rs.getString(3));
			ab2.setAmt(rs.getInt(4));

			ab2.setAddr(rs.getString(5));
			ab2.setPhone(rs.getString(6));

			PreparedStatement ps2 = con.prepareStatement("delete from rpsbank where accno =?");
			ps2.setString(1, ab.getAccNo());
			int k = ps2.executeUpdate();
			if (k > 0) {
				return ab2;
			} else {
				return null;
			}

		} else {
			return null;
		}

	}

	
}
