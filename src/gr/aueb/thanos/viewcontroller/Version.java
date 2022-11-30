package gr.aueb.thanos.viewcontroller;

//import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JSeparator;

public class Version extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public Version() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/resources/aueb.jpg")));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 459, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel version_lbl = new JLabel("Version 0.1");
        version_lbl.setBounds(39, 34, 350, 103);
        version_lbl.setForeground(new Color(153, 0, 0));
        version_lbl.setFont(new Font("Tahoma", Font.BOLD, 30));
        version_lbl.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(version_lbl);

        JButton close_btn = new JButton("Close");
        close_btn.setForeground(new Color(0, 0, 204));
        close_btn.setBounds(247, 189, 158, 51);
        close_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TeachersApp.mainFrame.setEnabled(true);
                TeachersApp.version.setVisible(false);

            }
        });
        close_btn.setFont(new Font("Tahoma", Font.PLAIN, 17));
        contentPane.add(close_btn);

        JSeparator separator = new JSeparator();
        separator.setBounds(25, 158, 380, 1);
        contentPane.add(separator);
        setTitle("Version");
    }
}

