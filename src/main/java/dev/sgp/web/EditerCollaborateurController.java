package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		if (matricule == null) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Un matricule est attendu");
		} else {
			resp.getWriter().write("Matricule : " + matricule);
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matricule = req.getParameter("matricule");
		String titre = req.getParameter("titre");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");

		if (matricule == null || titre == null || nom == null || prenom == null) {
			String response = "Les paramètres suivants sont incorrects :";
			if (matricule == null)
				response += " matricule";
			if (titre == null)
				response += " titre";
			if (nom == null)
				response += " nom";
			if (prenom == null)
				response += " prenom";
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, response);
		} else {
			resp.setStatus(HttpServletResponse.SC_CREATED);

			resp.getWriter().write(String.format("Creation d’un collaborateur avec les informations suivantes : \n matricule=%s, titre=%s, nom=%s, prenom=%s ", matricule, titre, nom, prenom) );
		}

	}
}
