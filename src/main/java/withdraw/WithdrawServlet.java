package withdraw;

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
@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AccountBean ab = null;
		AccountBean ab2 =null;
		try {
		    ab2 = new AccountBean();
			ab2.setAccNo(req.getParameter("accno"));
			ab2.setUname(req.getParameter("uname"));
			ab2.setPwd(req.getParameter("pwd"));
			ab2.setAmt(Integer.parseInt(req.getParameter("amt")));

			ab = new WithdrawDAO().doWithdraw(ab2);
			System.out.println(ab.getAccNo());
			System.out.println(ab.getUname());
			System.out.println(ab.getPwd());
			System.out.println(ab.getAmt());
			System.out.println(ab.getAddr());
			System.out.println(ab.getPhone());
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (ab == null) {

			req.setAttribute("msg", "Withdraw fail , Insufficent Balance");
			req.getRequestDispatcher("withdrawfail.jsp").forward(req, res);
		}

		else {

			ServletContext sct = req.getServletContext();
			sct.setAttribute("abean", ab);
			sct.setAttribute("abean2", ab2);
			req.getRequestDispatcher("withdrawsuccess.jsp").forward(req, res);
		}

	}

}
