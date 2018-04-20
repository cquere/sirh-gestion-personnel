package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.commons.lang3.math.NumberUtils;

import dev.sgp.entite.Collaborateur;
import dev.sgp.util.Constantes;

public class NouveauCollaborateurController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// A ajouter
		req.getRequestDispatcher("/views/collab/nouveauCollaborateurs.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String adresse = req.getParameter("adresse");
		String numSecuSocial = req.getParameter("numSecuSocial");
		LocalDate dateNaissance = null;
		boolean err = false;

		try {
			dateNaissance = LocalDate.parse(req.getParameter("dateNaissance"),
					DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		} catch (DateTimeParseException e) {
			req.setAttribute("erreurDate", "Le nouveau collaborateur doit être majeur.");
			err = true;
			dateNaissance = null;
		}

		if (nom == null || nom.equals("")) {
			req.setAttribute("erreurNom", "Vous devez spécifier un nom.");
			err = true;
		}
		if (prenom == null || prenom.equals("")) {
			req.setAttribute("erreurPrenom", "Vous devez spécifier un prénom.");
			err = true;
		}
		if (adresse == null || adresse.equals("")) {
			req.setAttribute("erreurAdresse", "Vous devez spécifier une adresse.");
			err = true;
		}
		if (numSecuSocial.length() != 15 || !NumberUtils.isNumber(numSecuSocial)) {
			req.setAttribute("erreurSecu", "Le numéro de sécurité doit être composé de 15 chiffres.");
			err = true;
		}
		if (dateNaissance == null || dateNaissance.plusYears(18).isAfter(LocalDate.now())) {
			req.setAttribute("erreurDate", "Le nouveau collaborateur doit être majeur.");
			err = true;
		}
		if (err) {
			req.getRequestDispatcher("/views/collab/nouveauCollaborateurs.jsp").forward(req, resp);

		} else {
			Constantes.COLLAB_SERVICE
					.sauvegarderCollaborateur(new Collaborateur(nom, prenom, dateNaissance, adresse, numSecuSocial));
			req.getSession().setAttribute("listeCollab", Constantes.COLLAB_SERVICE.listerCollaborateurs());
			req.getRequestDispatcher("/views/collab/listerCollaborateurs.jsp").forward(req, resp);
		}

	}
}
