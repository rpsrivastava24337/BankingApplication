package balance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnection;
import newAccount.AccountBean;

public class BalanceDAO {
	AccountBean ab2 = null;

	public AccountBean getBalance(AccountBean ab) throws SQLException {
		Connection con = DBConnection.getCon();

		PreparedStatement ps = con.prepareStatement("select * from rpsbank where accno=? and uname =? and pwd=?");
		ps.setString(1, ab.getAccNo());
		ps.setString(2, ab.getUname());
		ps.setString(3, ab.getPwd());
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			ab2 = new AccountBean();

			ab2.setAccNo(rs.getString(1));
			ab2.setUname(rs.getString(2));

			ab2.setPwd(rs.getString(3));
			ab2.setAmt(rs.getInt(4));

			ab2.setAddr(rs.getString(5));
			ab2.setPhone(rs.getString(6));

		}
		return ab2;

	}

}
