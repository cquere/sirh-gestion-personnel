package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.util.Constantes;

// TODO: Auto-generated Javadoc
/**
 * The Class EditerCollaborateurController.
 */
public class EditerCollaborateurController extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String matricule = req.getParameter("matricule");
		List<Collaborateur> collabs = Constantes.COLLAB_SERVICE.listerCollaborateurs();
		Optional<Collaborateur> collab = collabs.stream().filter(c -> c.getMatricule().equals(matricule)).findFirst();
		
		if (collab.isPresent()){
			req.setAttribute("collab", collab.get());
		}
		req.getRequestDispatcher("/views/collab/editerCollaborateur.jsp").forward(req, resp);		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
