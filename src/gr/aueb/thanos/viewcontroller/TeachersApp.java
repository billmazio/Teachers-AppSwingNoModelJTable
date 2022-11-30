package gr.aueb.thanos.viewcontroller;

import java.awt.EventQueue;

public class TeachersApp {
    public static MainWindow mainFrame;
    public static FrmEkpaideytesInsert ekpaidInsertFrame;
    public static FrmEkpaideytesUpdate ekpaidUpdateFrame;
    public static SearchForm ekpaidSearchFrame;
    public static Version version;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainFrame = new MainWindow();
                    mainFrame.setLocationRelativeTo(null);
                    mainFrame.setVisible(true);

                    ekpaidInsertFrame = new FrmEkpaideytesInsert();
                    ekpaidInsertFrame.setLocationRelativeTo(null);
                    ekpaidInsertFrame.setVisible(false);

                    ekpaidUpdateFrame = new FrmEkpaideytesUpdate();
                    ekpaidUpdateFrame.setLocationRelativeTo(null);
                    ekpaidUpdateFrame.setVisible(false);

                    ekpaidSearchFrame = new SearchForm();
                    ekpaidSearchFrame.setLocationRelativeTo(null);
                    ekpaidSearchFrame.setVisible(false);

                    version = new Version();
                    version.setLocationRelativeTo(null);
                    version.setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }}

