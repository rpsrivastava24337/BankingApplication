package deposit;

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
@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AccountBean ab = null;
		try {
			AccountBean ab2 = new AccountBean();
			ab2.setAccNo(req.getParameter("accno"));
			ab2.setUname(req.getParameter("uname"));
			ab2.setPwd(req.getParameter("pwd"));
			ab2.setAmt(Integer.parseInt(req.getParameter("amt")));

			ab = new DepositDAO().doDeposit(ab2);
		
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (ab == null) {

			req.setAttribute("msg", "Deposit fail try again");
			req.getRequestDispatcher("depositfail.jsp").forward(req, res);
		}

		else {

			ServletContext sct = req.getServletContext();
			sct.setAttribute("abean", ab);
			req.getRequestDispatcher("depositsuccess.jsp").forward(req, res);
		}

	}

}
