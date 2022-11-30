package gr.aueb.thanos.viewcontroller;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;

import java.awt.*;

//import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
//import javax.swing.border.BevelBorder;

//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
//import javax.swing.UIManager;
//import java.awt.FlowLayout;
//import java.awt.BorderLayout;


@SuppressWarnings("serial")
public class SearchForm extends JFrame {
    //static String searchEpwnymoVar;
    JPanel contentPane;
    JTextField frm_SearchEpwnymo;
    JButton btnSearch;
    JButton btnClose;

    public SearchForm() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/resources/aueb.jpg")));
        setTitle("Teachers Menu");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 489, 381);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(224, 255, 255));
        contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
        setContentPane(contentPane);
        contentPane.setLayout(null);

		/*JLabel lbl_epwnymo = new JLabel("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF");
		lbl_epwnymo.setForeground(new Color(178, 34, 34));
		lbl_epwnymo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_epwnymo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbl_epwnymo.setBounds(166, 30, 118, 45);
		contentPane.add(lbl_epwnymo);
		*/
		/*frm_SearchEpwnymo = new JTextField();
		frm_SearchEpwnymo.setBounds(125, 77, 200, 22);
		contentPane.add(frm_SearchEpwnymo);
		frm_SearchEpwnymo.setColumns(10);
		*/



			/*	new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchForm.searchEpwnymoVar = frm_SearchEpwnymo.getText();
				TeachersApp.ekpaidSearchFrame.setEnabled(false);
				TeachersApp.ekpaidUpdateFrame.setVisible(true);
			}
		});*/

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBounds(68, 13, 324, 151);
        //panel_1.add(btnSearch);

        contentPane.add(panel_1);
        panel_1.setLayout(null);
        btnSearch = new JButton("Search");
        btnSearch.setBounds(96, 57, 133, 45);
        panel_1.add(btnSearch);
        btnSearch.setForeground(new Color(0, 0, 255));

        // handler for Anazhthsh button
        btnSearch.addActionListener(e ->{
            TeachersApp.ekpaidSearchFrame.setEnabled(false);
            TeachersApp.ekpaidUpdateFrame.setVisible(true);
        });
        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));

        btnClose = new JButton("Close");
        btnClose.setForeground(new Color(0, 0, 205));
        btnClose.setFont(new Font("Tahoma", Font.PLAIN, 15));

        // handler for close button
        btnClose.addActionListener(e -> {
            TeachersApp.mainFrame.setEnabled(true); //enables previous form
            TeachersApp.ekpaidSearchFrame.setVisible(false); // non-visible current form
        });

				/*new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersApp.mainFrame.setEnabled(true); //enables previous form
				TeachersApp.ekpaidSearchFrame.setVisible(false); // non-visible current form
			}
		});*/
        btnClose.setBounds(295, 296, 97, 25);
        contentPane.add(btnClose);

        JButton btnInsert = new JButton("Introduction");
        btnInsert.addActionListener(e ->{
            TeachersApp.ekpaidSearchFrame.setEnabled(false);
            TeachersApp.ekpaidInsertFrame.setVisible(true);
        });

				/*new ActionListener() {
			//handler for insert
			public void actionPerformed(ActionEvent e) {
				TeachersApp.ekpaidSearchFrame.setEnabled(false);
				TeachersApp.ekpaidInsertFrame.setVisible(true);
			}
		});*/
        btnInsert.setForeground(Color.BLUE);
        btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnInsert.setBounds(166, 200, 133, 45);
        contentPane.add(btnInsert);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_2.setBounds(68, 177, 324, 93);
        contentPane.add(panel_2);
    }
}

