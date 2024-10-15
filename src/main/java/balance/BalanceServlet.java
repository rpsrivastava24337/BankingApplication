package balance;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import newAccount.AccountBean;

@SuppressWarnings("serial")
@WebServlet("/balance")
public class BalanceServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		AccountBean ab = new AccountBean();
		ab.setAccNo(req.getParameter("accno"));
		ab.setUname(req.getParameter("uname"));
		ab.setPwd(req.getParameter("pwd"));
		AccountBean ab2 = null;
		try {

			ab2 = new BalanceDAO().getBalance(ab);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (ab2 == null) {
			req.setAttribute("msg", "Please check your username and password");
			req.getRequestDispatcher("balancefail.jsp").forward(req, res);
		}

		else {

			ServletContext sct = req.getServletContext();
			sct.setAttribute("abean", ab2);
			req.getRequestDispatcher("balancesuccess.jsp").forward(req, res);

		}
	}

}
