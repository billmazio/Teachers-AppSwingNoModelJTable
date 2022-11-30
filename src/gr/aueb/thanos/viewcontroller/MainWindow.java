package gr.aueb.thanos.viewcontroller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1;
    static Connection conn;

    public MainWindow() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/resources/aueb.jpg")));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 420, 300);
        this.setTitle("Quality in Education");

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                String url = "jdbc:mysql://localhost:3306/teachers?serverTimezone=UTC&useSSL=false";
                String username = "root";
                String password = "ww321278?";

                try {
                    conn = DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 248, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenu appMenuInFileMenu = new JMenu("App");
        fileMenu.add(appMenuInFileMenu);

        JMenuItem itemCloseInAppMenu = new JMenuItem("Close");
        itemCloseInAppMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        appMenuInFileMenu.add(itemCloseInAppMenu);

        JButton buttonEkpaid = new JButton("");
        buttonEkpaid.setBounds(25, 110, 33, 27);

        buttonEkpaid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TeachersApp.ekpaidSearchFrame.setVisible(true);
                TeachersApp.mainFrame.setEnabled(false);
            }
        });

        JLabel lbl_ekpaid = new JLabel("Teachers");
        lbl_ekpaid.setBounds(70, 110, 95, 27);
        lbl_ekpaid.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_ekpaid.setForeground(new Color(153, 0, 0));
        lbl_ekpaid.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lbl_qualityGreen = new JLabel("Quality in Education");
        lbl_qualityGreen.setBounds(6, 23, 387, 47);
        lbl_qualityGreen.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl_qualityGreen.setForeground(new Color(0, 100, 0));
        lbl_qualityGreen.setFont(new Font("Tahoma", Font.PLAIN, 30));
        contentPane.add(lbl_qualityGreen);

        JLabel lbl_qualityGray = new JLabel("Quality in Education");
        lbl_qualityGray.setBounds(9, 25, 387, 47);
        lbl_qualityGray.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl_qualityGray.setForeground(Color.GRAY);
        lbl_qualityGray.setFont(new Font("Tahoma", Font.PLAIN, 30));
        contentPane.add(lbl_qualityGray);

        JSeparator separator = new JSeparator();
        separator.setBounds(25, 84, 373, 1);
        contentPane.add(separator);
        contentPane.add(buttonEkpaid);

        JButton btnVerion = new JButton("");
        btnVerion.setBounds(25, 150, 33, 27);

        btnVerion.addActionListener((e) -> {
            TeachersApp.mainFrame.setEnabled(false);
            TeachersApp.version.setVisible(true);
        });

        contentPane.add(btnVerion);
        contentPane.add(lbl_ekpaid);

        JLabel lbl_version = new JLabel("Version");
        lbl_version.setBounds(70, 150, 62, 27);
        lbl_version.setForeground(new Color(153, 0, 0));
        lbl_version.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.add(lbl_version);
    }
}
