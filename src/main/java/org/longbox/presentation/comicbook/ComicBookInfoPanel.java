package org.longbox.presentation.comicbook;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import org.longbox.domainobjects.dto.ComicBookDTO;

import javax.swing.JButton;

public class ComicBookInfoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final String PANEL_LABEL = "Search Result";
	private static final String VIEW_COMMENTS = "View Comments";
	private JButton commentsButton;
	private ComicBookDTO comicBookDTO;
	
	//text labels
	private JLabel comicSeries;
	private JLabel author;
	private JLabel artist;
	private JLabel genre;
	private JLabel description;
	private JLabel numberOfIssues;
	private JLabel publisher;
	private JLabel yearPublished;
	private JLabel dateAdded;
	
	
	/**
	 * Create the panel.
	 */
//	public ComicBookInfoPanel() {
//		initComicBookInfoPage();
//	}
	
	public ComicBookInfoPanel(ComicBookDTO comicBookDTO) {
		this.comicBookDTO = comicBookDTO;
		initComicBookInfoPage();
	}

	private void initComicBookInfoPage() {
		setBounds(10, 47, 1164, 803);
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
	    JLabel comicCollectionTitle = new JLabel(PANEL_LABEL);
		comicCollectionTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		comicCollectionTitle.setHorizontalAlignment(SwingConstants.CENTER);
		comicCollectionTitle.setBounds(182, 25, 800, 43);
		panel.add(comicCollectionTitle);
		
		add(panel, BorderLayout.CENTER);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(7, 100, 1150, 1);
		panel.add(separator);
		
		JSeparator midSeparator = new JSeparator();
		midSeparator.setOrientation(SwingConstants.VERTICAL);
		midSeparator.setBackground(new Color(0, 0, 0));
		midSeparator.setForeground(new Color(0, 0, 0));
		midSeparator.setBounds(567, 100, 30, 618);
		panel.add(midSeparator);
		
		commentsButton = new JButton(VIEW_COMMENTS);
		commentsButton.setBounds(517, 758, 130, 34);
		panel.add(commentsButton);
		
		JLabel ComicTitleLabel = new JLabel("Series Title:");
		ComicTitleLabel.setBounds(53, 240, 80, 16);
		panel.add(ComicTitleLabel);
		
		JLabel AuthorLabel = new JLabel("Author:");
		AuthorLabel.setBounds(53, 268, 80, 16);
		panel.add(AuthorLabel);
		
		JLabel ArtistLabel = new JLabel("Artist:");
		ArtistLabel.setBounds(53, 296, 80, 16);
		panel.add(ArtistLabel);
		
		JLabel GenreLabel = new JLabel("Genre:");
		GenreLabel.setBounds(53, 324, 80, 16);
		panel.add(GenreLabel);
		
		JLabel DescriptionLabel = new JLabel("Description: ");
		DescriptionLabel.setBounds(53, 372, 94, 16);
		panel.add(DescriptionLabel);
		
		JLabel IssuesLabel = new JLabel("Number of Issues:");
		IssuesLabel.setBounds(53, 400, 115, 16);
		panel.add(IssuesLabel);
		
		JLabel PublisherLabel = new JLabel("Publisher:");
		PublisherLabel.setBounds(53, 428, 80, 16);
		panel.add(PublisherLabel);
		
		JLabel YearPublishedLabel = new JLabel("Year Published: ");
		YearPublishedLabel.setBounds(53, 456, 115, 16);
		panel.add(YearPublishedLabel);
		
		JLabel DateAddedLabel = new JLabel("Date Added:");
		DateAddedLabel.setBounds(53, 484, 94, 16);
		panel.add(DateAddedLabel);
		
		comicSeries = new JLabel("");
		comicSeries.setBounds(182, 240, 373, 16);
		panel.add(comicSeries);
		
		author = new JLabel("");
		author.setBounds(182, 268, 373, 16);
		panel.add(author);
		
		artist = new JLabel("");
		artist.setBounds(182, 296, 373, 16);
		panel.add(artist);
		
		genre = new JLabel("");
		genre.setBounds(182, 324, 373, 36);
		panel.add(genre);
		
		description = new JLabel("");
		description.setBounds(182, 372, 373, 16);
		panel.add(description);
		
		numberOfIssues = new JLabel("");
		numberOfIssues.setBounds(182, 400, 373, 16);
		panel.add(numberOfIssues);
		
		publisher = new JLabel("");
		publisher.setBounds(182, 428, 373, 16);
		panel.add(publisher);
		
		yearPublished = new JLabel("");
		yearPublished.setBounds(182, 456, 373, 16);
		panel.add(yearPublished);
		
		dateAdded = new JLabel("");
		dateAdded.setBounds(182, 484, 373, 16);
		panel.add(dateAdded);
		
		setFields();
	}

//	public JTextPane getComicBookInfoTextPane() {
//		return comicBookInfoTextPane;
//	}
//
//	public void setComicBookInfoTextPane(JTextPane comicBookInfoTextPane) {
//		this.comicBookInfoTextPane = comicBookInfoTextPane;
//	}

	public void setFields() {
		comicSeries.setText(comicBookDTO.getSeriesTitle());
		author.setText(comicBookDTO.getAuthor());
		artist.setText(comicBookDTO.getArtist());
		genre.setText("<html>" + comicBookDTO.genreListToString(comicBookDTO.getGenres()) + "</html>");
		description.setText(comicBookDTO.getDescription());
		numberOfIssues.setText("" + comicBookDTO.getNumberOfIssues());
		publisher.setText(comicBookDTO.getPublisher());
		yearPublished.setText("" + comicBookDTO.getYearPublished());
		dateAdded.setText("" + comicBookDTO.getDateAdded());
	}

	public JButton getCommentsButton() {
		return commentsButton;
	}

	public void setCommentsButton(JButton commentsButton) {
		this.commentsButton = commentsButton;
	}
}
