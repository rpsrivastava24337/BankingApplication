package newAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnection;

public class NewAccountDAO {

	public AccountBean addAccount(AccountBean ab) throws SQLException {
		int k = 0;
		Connection con = DBConnection.getCon();

		PreparedStatement ps = con.prepareStatement("insert into rpsbank values(sq1.nextval,?,?,?,?,?)");
		AccountBean ab2 = null;
		ps.setString(1, ab.getUname());
		ps.setString(2, ab.getPwd());
		ps.setInt(3, ab.getAmt());
		ps.setString(4, ab.getAddr());
		ps.setString(5, ab.getPhone());
		k = ps.executeUpdate();

		if (k > 0) {

			PreparedStatement ps2 = con.prepareStatement("select * from rpsbank where uname =? and pwd=?");
			ps2.setString(1, ab.getUname());
			ps2.setString(2, ab.getPwd());
			ResultSet rs = ps2.executeQuery();

			if (rs.next()) {

				ab2 = new AccountBean();

				ab2.setAccNo(rs.getString(1));
				ab2.setUname(rs.getString(2));

				ab2.setPwd(rs.getString(3));
				ab2.setAmt(rs.getInt(4));

				ab2.setAddr(rs.getString(5));
				ab2.setPhone(rs.getString(6));

			}

		}

		return ab2;

	}

}
