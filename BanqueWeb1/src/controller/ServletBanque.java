package controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Compte;
import metier.CompteServiceLocal;

/**
 * Servlet implementation class ServletBanque
 */
@WebServlet("/ServletBanque")
public class ServletBanque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
	CompteServiceLocal csl;
	
    public ServletBanque() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         List <Compte> comptes = csl.getAllComptes();
		 
		 request.setAttribute("comptes", comptes);
		 
		 request.getRequestDispatcher("VueBanque.jsp").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long code = Long.parseLong(request.getParameter("code"));
		double mnt = Double.parseDouble(request.getParameter("mnt"));
		String action = request.getParameter("action");
		
		if (action.equals("Verser"))
			csl.verser(code, mnt);
		else
			csl.retirer(code, mnt);
		
		doGet(request, response);
		
	}

}
