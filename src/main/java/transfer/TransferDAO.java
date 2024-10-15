package transfer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnection;
import newAccount.AccountBean;

public class TransferDAO {
	AccountBean acc1 = null;
	AccountBean acc2 = null;

	public AccountBean doTransfer(AccountBean ab, AccountBean ab2) throws SQLException {
		Connection con = DBConnection.getCon();
		PreparedStatement ps = con.prepareStatement("select * from rpsbank where uname =? and pwd=?");
		ps.setString(1, ab.getUname());
		ps.setString(2, ab.getPwd());
		ResultSet rs = ps.executeQuery();

		PreparedStatement ps2 = con.prepareStatement("select * from rpsbank where accno=?");
		ps2.setString(1, ab2.getAccNo());
		ResultSet rs2 = ps2.executeQuery();

		if (rs.next() && rs2.next()) {

			acc1 = new AccountBean();

			acc1.setAccNo(rs.getString(1));
			acc1.setUname(rs.getString(2));

			acc1.setPwd(rs.getString(3));
			acc1.setAmt(rs.getInt(4));

			acc1.setAddr(rs.getString(5));
			acc1.setPhone(rs.getString(6));
/////////////////////////////////////////////////////////////////////////////
			acc2 = new AccountBean();

			acc2.setAccNo(rs2.getString(1));
			acc2.setUname(rs2.getString(2));

			acc2.setPwd(rs2.getString(3));
			acc2.setAmt(rs2.getInt(4));

			acc2.setAddr(rs2.getString(5));
			acc2.setPhone(rs2.getString(6));

		}

		else
			return null;
		System.out.println(acc1.getAmt());
		System.out.println(acc2.getAmt());
		if (acc1.getAmt() >= ab.getAmt()) {

			acc1.setAmt(acc1.getAmt() - ab.getAmt());
			acc2.setAmt(acc2.getAmt() + ab.getAmt());
			System.out.println(acc1.getAmt());
			System.out.println(acc2.getAmt());

		} else
			return null;

		PreparedStatement ps3 = con.prepareStatement("update rpsbank set amt = ? where accno =?");
		ps3.setInt(1, acc1.getAmt());
		ps3.setString(2, acc1.getAccNo());
		int k = ps3.executeUpdate();

		PreparedStatement ps4 = con.prepareStatement("update rpsbank set amt = ? where accno =?");
		ps4.setInt(1, acc2.getAmt());
		ps4.setString(2, acc2.getAccNo());
		int k2 = ps4.executeUpdate();

		if (k > 0 && k2 > 0) {
			return acc1;
		}

		return null;
	}
}
