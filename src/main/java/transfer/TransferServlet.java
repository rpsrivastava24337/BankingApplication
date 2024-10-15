package transfer;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import newAccount.AccountBean;
import withdraw.WithdrawDAO;

@SuppressWarnings("serial")
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AccountBean ab = null;
		AccountBean ab2 = null;
		AccountBean ab3 = null;
		try {
			ab2 = new AccountBean();
			ab2.setAccNo(req.getParameter("accno1"));
			ab2.setUname(req.getParameter("uname1"));
			ab2.setPwd(req.getParameter("pwd1"));
			ab2.setAmt(Integer.parseInt(req.getParameter("amt")));

			ab3 = new AccountBean();
			ab3.setAccNo(req.getParameter("accno2"));

			ab = new TransferDAO().doTransfer(ab2, ab3);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (ab == null) {

			req.setAttribute("msg", "Transfer fail , Insufficent Balance");
			req.getRequestDispatcher("transferfail.jsp").forward(req, res);
		}

		else {

			ServletContext sct = req.getServletContext();
		
			sct.setAttribute("abean", ab3);
			sct.setAttribute("abean2", ab);
			sct.setAttribute("abean3", ab2);
			
			req.getRequestDispatcher("transfersuccess.jsp").forward(req, res);
			
		}

	}

}
