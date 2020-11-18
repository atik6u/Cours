package fr.polytech.nancy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Jstldemo
 */
@WebServlet("/Jstldemo")
public class Jstldemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Jstldemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nom = request.getParameter("nom");
		request.setAttribute("nom", nom);
		String prenom = request.getParameter("prenom");
		request.setAttribute("prenom", prenom);
		
		Etudiant etudiant = new Etudiant(1, "ATIK", "Mohammed");
		request.setAttribute("etudiant", etudiant);
		
		int a = Integer.parseInt(request.getParameter("a"));
		request.setAttribute("a", a);
		int b = Integer.parseInt(request.getParameter("b"));
		request.setAttribute("b", b);
		
		int result = somme(a, b);
		request.setAttribute("result", result);
		
		ArrayList<Etudiant> listeEtudiants = new ArrayList<Etudiant>();
		listeEtudiants.add(new Etudiant(2, "atik2", "bbb"));
		listeEtudiants.add(new Etudiant(3, "atik3", "ccc"));
		listeEtudiants.add(new Etudiant(4, "atik4", "ddd"));
		request.setAttribute("listeEtudiants", listeEtudiants);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/JspJstl.jsp").forward(request, response);
	}

	private static int somme(int a, int b) {
		return a + b;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String login = request.getParameter("login");
//		request.setAttribute("login", login);
//		
//		String pass = request.getParameter("pass");
//		request.setAttribute("pass", pass);
		
		Authentification authentification = new Authentification();
		authentification.acces(request);
		request.setAttribute("authentification", authentification);
		

		doGet(request, response);
	}

}
