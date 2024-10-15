package accountclose;

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
@WebServlet("/closeacc")
public class AccountCloseServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AccountBean ab = null;
		AccountBean ab2 = null;
		try {
			ab2 = new AccountBean();
			ab2.setAccNo(req.getParameter("accno"));
			ab2.setUname(req.getParameter("uname"));
			ab2.setPwd(req.getParameter("pwd"));

			ab = new AccounCloseDAO().doClose(ab2);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (ab == null) {

			req.setAttribute("msg", "Account Close fail");
			req.getRequestDispatcher("closeaccfail.jsp").forward(req, res);
		}

		else {

			ServletContext sct = req.getServletContext();
			sct.setAttribute("abean", ab);
			req.getRequestDispatcher("closeaccsuccess.jsp").forward(req, res);
		}

	}

}
