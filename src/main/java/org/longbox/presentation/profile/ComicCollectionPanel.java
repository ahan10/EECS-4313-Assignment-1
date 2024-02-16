package org.longbox.presentation.profile;

import org.longbox.businesslogic.utils.ComicBookSearch;
import org.longbox.domainobjects.dto.ComicBookDTO;
import org.longbox.persistence.stubdatabase.ComicBookStubDB;
import org.longbox.presentation.comicbook.ComicBookFrame;

import lombok.Getter;
import lombok.Setter;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.html.HTMLEditorKit;

@Getter
@Setter
public class ComicCollectionPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel comicCollectionTitle;
	private JLabel lblNewLabel_1;
	private JSeparator separator;
	private JComboBox<String> comboBox;
	private JScrollPane scrollPane;
	private String currentItem;
	private JTable comicBookTable;
	private JTextField textField;
	private ComicBookTableModel comicBookTableModel;
	TableRowSorter<TableModel> sorter;
	ComicBookStubDB comicBookStubDB;

	public ComicCollectionPanel() {
		initComicCollectionPage();
	}

	private void initComicCollectionPage() {

		setBounds(10, 47, 1164, 803);
		setLayout(new BorderLayout());
		
		panel = new JPanel();
	    panel.setLayout(null);
		
		comicCollectionTitle = new JLabel("Comic Collection");
		comicCollectionTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		comicCollectionTitle.setHorizontalAlignment(SwingConstants.CENTER);
		comicCollectionTitle.setBounds(396, 11, 372, 43);
		panel.add(comicCollectionTitle);

		separator = new JSeparator();
		separator.setBounds(10, 92, 1144, 14);
		panel.add(separator);

		add(panel, BorderLayout.CENTER);

		comicBookStubDB = new ComicBookStubDB();
		comicBookStubDB.loadComicBooks();

		comicBookTableModel = new ComicBookTableModel(comicBookStubDB.getComicBookStubData());

		comicBookTable = new JTable(comicBookTableModel);
		sorter = new TableRowSorter<TableModel>(comicBookTable.getModel());
		comicBookTable.setRowSorter(sorter);

		scrollPane = new JScrollPane(comicBookTable);
		scrollPane.setViewportBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 110, 1144, 683);
		panel.add(scrollPane);
		
		textField = new JTextField();
		textField.setBounds(116, 62, 213, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("Search Collection:");
		lblNewLabel.setBounds(10, 66, 120, 13);
		panel.add(lblNewLabel);
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
		if (e.getSource() == textField) {
			System.out.println("Search for: " + textField.getText());
			ComicBookDTO comicBook = ComicBookSearch.searchComicBook(comicBookStubDB.getComicBookStubData(), textField.getText());
			if (comicBook.getSeriesTitle() != null) {
				ComicBookFrame comicBookFrame = new ComicBookFrame();
				comicBookFrame.setVisible(true);
				HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
				comicBookFrame.getComicBookInfoPane().getComicBookInfoTextPane().setEditorKit(htmlEditorKit);
				comicBookFrame.getComicBookInfoPane().getComicBookInfoTextPane().setText(ComicBookSearch.generateComicBookHTML(comicBook));
			} else {
                JOptionPane.showMessageDialog(panel, "No search results found.", "Search Results Not Found", JOptionPane.INFORMATION_MESSAGE);
            }
		}
    }
}
