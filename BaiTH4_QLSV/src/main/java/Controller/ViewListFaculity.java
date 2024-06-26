package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BEAN.Faculity;
import Model.BO.FaculityBO;

/**
 * Servlet implementation class ViewListFaculity
 */
@WebServlet("/ViewListFaculity")
public class ViewListFaculity extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FaculityBO faculityBO = new FaculityBO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewListFaculity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Faculity> listFaculity = faculityBO.getAllFaculity();
			
			request.setAttribute("listFaculity", listFaculity);
			
			String destination = "/Admin/homepage.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
