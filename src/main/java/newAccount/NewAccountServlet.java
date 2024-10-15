package newAccount;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/newaccount")
public class NewAccountServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AccountBean k = null;
		AccountBean ab = new AccountBean();

		ab.setUname(req.getParameter("uname"));
		ab.setPwd(req.getParameter("pwd"));
		ab.setAmt(Integer.parseInt(req.getParameter("amt")));
		ab.setAddr(req.getParameter("addr"));
		ab.setPhone(req.getParameter("phone"));

		try {
			k = new NewAccountDAO().addAccount(ab);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (k != null) {
			ServletContext sct = req.getServletContext();
			sct.setAttribute("abean", k);
			req.getRequestDispatcher("registersuccess.jsp").forward(req, res);
		} else {
			req.setAttribute("msg", "Registration Fail Try again");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}

	}

}
