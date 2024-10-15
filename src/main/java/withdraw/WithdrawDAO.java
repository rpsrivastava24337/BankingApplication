package withdraw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import balance.BalanceDAO;
import db.DBConnection;
import newAccount.AccountBean;
import oracle.jdbc.proxy.annotation.Pre;

public class WithdrawDAO {

	public AccountBean doWithdraw(AccountBean ab) throws SQLException {

		AccountBean ab2 = null;
		AccountBean ab3 = null;
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

			if (ab.getAmt() <= ab2.getAmt()) {

				PreparedStatement ps2 = con.prepareStatement("update rpsbank set amt = ? where accno=? and uname = ?");
				ps2.setInt(1, (ab2.getAmt() - ab.getAmt()));
				System.out.println("ab2 - ab = " + (ab2.getAmt() - ab.getAmt()));

				ps2.setString(2, ab.getAccNo());
				ps2.setString(3, ab.getUname());
				int k = ps2.executeUpdate();
				if (k > 0) {
					PreparedStatement ps3 = con.prepareStatement("select * from rpsbank where accno =?");
					ps3.setString(1, ab2.getAccNo());
					ResultSet rs2 = ps3.executeQuery();
					if (rs2.next()) {
						ab3 = new AccountBean();

						ab3.setAccNo(rs2.getString(1));
						ab3.setUname(rs2.getString(2));

						ab3.setPwd(rs2.getString(3));
						ab3.setAmt(rs2.getInt(4));
						System.out.println("ab3 = " + ab3.getAmt());

						ab3.setAddr(rs2.getString(5));
						ab3.setPhone(rs2.getString(6));

					}
				}
			} else {
				return null;
			}
		}
		return ab3;

	}

}
