package org.longbox.businesslogic.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.longbox.businesslogic.UserSession;
import org.longbox.businesslogic.service.RecommendationService;
import org.longbox.businesslogic.service.UserService;
import org.longbox.businesslogic.utils.ComicBookSearchUtils;
import org.longbox.config.HibernateUtils;
import org.longbox.domainobjects.dto.ComicBookDto;
import org.longbox.persistence.dao.ComicBookDao;
import org.longbox.persistence.dao.ComicBookDaoImpl;
import org.longbox.presentation.profile.RecommendationsPanel;

public class RecommendationsController implements MouseListener {
	
	private ComicBookDaoImpl comicBookDaoImpl = new ComicBookDaoImpl(HibernateUtils.getSessionFactory());
	private RecommendationsPanel recommentationsPanel;
	private UserSession userSession;
    private UserService userService;

	public RecommendationsController(RecommendationsPanel recommentationsPanel) {
		this.recommentationsPanel = recommentationsPanel;
		this.userSession = recommentationsPanel.getUserSession();
		loadListeners();
	}
	
	private void loadListeners() {
		this.recommentationsPanel.getRecommendationsTable().addMouseListener(this);		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = this.recommentationsPanel.getRecommendationsTable().rowAtPoint(e.getPoint());
		int col = this.recommentationsPanel.getRecommendationsTable().columnAtPoint(e.getPoint());
		if (col == 0 && e.getClickCount() == 2) {
			ComicBookDto comicBook = org.longbox.businesslogic.utils.ComicBookSearchUtils.searchComicBook(comicBookDaoImpl.getAllComicBooks(), this.recommentationsPanel.getRecommendationsTable().getValueAt(row, col).toString());
			ComicBookSearchUtils.loadComicBookPage(comicBook, userSession);
		}
		System.out.println("Worked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
