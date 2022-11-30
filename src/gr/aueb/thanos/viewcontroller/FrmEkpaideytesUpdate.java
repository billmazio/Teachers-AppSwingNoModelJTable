package gr.aueb.thanos.viewcontroller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.Vector;



public class FrmEkpaideytesUpdate extends JFrame {
    private static final long serialVersionUID = 1;
    private final JTextField udfrm_sname;
    private final JTextField udfrm_fname;
    private final JTextField udfrm_id;
    private ResultSet rs;

    private final JTable table;
    private final JTextField txtSearchName;

    private final DefaultTableModel dataModel;

    public FrmEkpaideytesUpdate() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/resources/aueb.jpg")));
	    setBackground(SystemColor.activeCaption);
        setTitle("Teachers/ Update /Delete");

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 694, 454);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lastNameLbl = new JLabel("Surname");
        lastNameLbl.setForeground(new Color(153, 0, 0));
        lastNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lastNameLbl.setBounds(12, 29, 65, 16);
        contentPane.add(lastNameLbl);

        txtSearchName = new JTextField();
        txtSearchName.setColumns(10);
        txtSearchName.setBounds(68, 27, 189, 22);
        contentPane.add(txtSearchName);

        JButton btnSearchButton = new JButton("Search");
        btnSearchButton.setBounds(270, 26, 97, 25);
        btnSearchButton.addActionListener(e -> handleSearch());
        contentPane.add(btnSearchButton);

        JSeparator separator = new JSeparator();
        separator.setBounds(12, 64, 355, 1);
        contentPane.add(separator);

        JLabel label = new JLabel("Results");
        label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label.setBounds(12, 73, 128, 25);
        contentPane.add(label);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleTableSelection();
            }
        });

        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Code", "Surname", "Firstname"
                }
        ));
        table.setBorder(new LineBorder(new Color(0, 0, 0)));
        table.setBounds(12, 106, 355, 279);
        dataModel = (DefaultTableModel) table.getModel();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(12, 106, 355, 279);

        contentPane.add(scrollPane);

        JLabel lbl_ID = new JLabel("Code");
        lbl_ID.setForeground(new Color(153, 0, 0));
        lbl_ID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_ID.setBounds(406, 145, 52, 16);
        contentPane.add(lbl_ID);

        JLabel lbl_sname = new JLabel("Surname");
        lbl_sname.setForeground(new Color(153, 0, 0));
        lbl_sname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_sname.setBounds(406, 180, 65, 16);
        contentPane.add(lbl_sname);

        JLabel lbl_fname = new JLabel("Firstname");
        lbl_fname.setForeground(new Color(153, 0, 0));
        lbl_fname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_fname.setBounds(406, 215, 56, 16);
        contentPane.add(lbl_fname);

        udfrm_id = new JTextField();
        udfrm_id.setEditable(false);
        udfrm_id.setBounds(475, 145, 56, 22);
        contentPane.add(udfrm_id);
        udfrm_id.setColumns(10);

        udfrm_sname = new JTextField();
        udfrm_sname.setBounds(475, 180, 189, 22);
        contentPane.add(udfrm_sname);
        udfrm_sname.setColumns(10);

        udfrm_fname = new JTextField();
        udfrm_fname.setBounds(475, 213, 189, 22);
        contentPane.add(udfrm_fname);
        udfrm_fname.setColumns(10);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String query = "UPDATE teachers set sname = ?, fname = ? where id = ?";
                    PreparedStatement preparedStmt = MainWindow.conn.prepareStatement(query);
                    preparedStmt.setString(1, udfrm_sname.getText());
                    preparedStmt.setString(2, udfrm_fname.getText());
                    preparedStmt.setInt(3,(Integer.parseInt(udfrm_id.getText())));

                    int numberOfRowsAffected = preparedStmt.executeUpdate();

                    JOptionPane.showMessageDialog(null, numberOfRowsAffected + " rows affected", "UPDATE", JOptionPane.PLAIN_MESSAGE);
                    preparedStmt.close();
                    handleSearch();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try{
                    String query = "DELETE from teachers where id = ?";
                    PreparedStatement preparedStmt = MainWindow.conn.prepareStatement(query);
                   preparedStmt.setInt(1,Integer.parseInt(""));


                    // execute the prepared statement
                    int dialogButton;
                    dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure?",
                            "Warning", JOptionPane.YES_NO_OPTION);

                    if (dialogButton == JOptionPane.YES_OPTION){
                        int numberOfRowsAffected = preparedStmt.executeUpdate();
                        JOptionPane.showMessageDialog (null, numberOfRowsAffected + " rows deleted successfully",
                                "DELETE", JOptionPane.INFORMATION_MESSAGE);
                        handleSearch();
                    }
                }
                catch (SQLException e6)
                {
                    e6.printStackTrace();
                }
            }
        });

        btnDelete.setBounds(398, 286, 89, 25);
        contentPane.add(btnDelete);
        btnUpdate.setBounds(480, 286, 92, 25);
        contentPane.add(btnUpdate);

        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TeachersApp.ekpaidSearchFrame.setEnabled(true);
                TeachersApp.ekpaidUpdateFrame.setVisible(false);
            }
        });
        btnClose.setBounds(569, 286, 95, 25);
        contentPane.add(btnClose);

        JButton btnFirst = new JButton("");
        btnFirst.setIcon(new ImageIcon(FrmEkpaideytesUpdate.class.getResource("/resources/FirstRecord.png")));
        btnFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (rs.first()){
                        udfrm_id.setText(Integer.toString(rs.getInt("id")));
                        udfrm_sname.setText(rs.getString("sname"));
                        udfrm_fname.setText(rs.getString("fname"));
                    } else{
                        JOptionPane.showMessageDialog(null,
                                "There is no registration", "Empty result", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        });
        btnFirst.setBounds(485, 248, 39, 25);
        contentPane.add(btnFirst);

        JButton btnPrev = new JButton("");
        btnPrev.setIcon(new ImageIcon(FrmEkpaideytesUpdate.class.getResource("/resources/PreviousRecord.png")));
        btnPrev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (rs.previous()) {
                        udfrm_id.setText(Integer.toString(rs.getInt("id")));
                        udfrm_sname.setText(rs.getString("sname"));
                        udfrm_fname.setText(rs.getString("fname"));
                    } else
                    {
                        rs.first();
                    }
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
            }
        });
        btnPrev.setBounds(520, 248, 39, 25);
        contentPane.add(btnPrev);

        JButton btnNext = new JButton("");
        btnNext.setIcon(new ImageIcon(FrmEkpaideytesUpdate.class.getResource("/resources/NextRecord.png")));

        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (rs.next()){
                        udfrm_id.setText(Integer.toString(rs.getInt("id")));
                        udfrm_sname.setText(rs.getString("sname"));
                        udfrm_fname.setText(rs.getString("fname"));
                    }
                    else
                        rs.last();

                } catch (SQLException e4) {
                    e4.printStackTrace();
                }
            }
        });

        btnNext.setBounds(554, 248, 46, 25);
        contentPane.add(btnNext);

        JButton btnLast = new JButton("");
        btnLast.setIcon(new ImageIcon(FrmEkpaideytesUpdate.class.getResource("/resources/LastRecord.png")));
        btnLast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (rs.last()) {
                        udfrm_id.setText(Integer.toString(rs.getInt("id")));
                        udfrm_sname.setText(rs.getString("sname"));
                        udfrm_fname.setText(rs.getString("fname"));
                    } else{
                        JOptionPane.showMessageDialog(null,
                                "There is no registration", "Empty result",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } catch (SQLException e5) {
                    e5.printStackTrace();
                }
            }
        });

        btnLast.setBounds(596, 248, 39, 25);
        contentPane.add(btnLast);
    }


    void handleSearch(){
        String varSearchName = txtSearchName.getText();

        try{
            String sql = "SELECT id, sname, fname FROM TEACHERS WHERE sname LIKE ?";
            //String sql = "SELECT TEACHER_ID, S_NAME, F_Name FROM TEACHERS WHERE S_NAME LIKE " + varSearchName + '%';
            PreparedStatement pst = MainWindow.conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, varSearchName + '%');
            rs = pst.executeQuery();

            rs.last();
            int rsSize = rs.getRow();

            if (rsSize <= 0) {
                JOptionPane.showMessageDialog(null,	"There is no registration", "Empty result", JOptionPane.WARNING_MESSAGE);
                //return;
            } else /*if (rsSize > 0 )*/{
                for (int i = dataModel.getRowCount() - 1; i >= 0; i--) {
                    dataModel.removeRow(i);
                }

                rs.beforeFirst();
                while (rs.next()){
                    Vector<String> row = new Vector<>(3);

                    for (int i=1; i<=3; i++){
                        row.add(rs.getString(i));
                    }

                    dataModel.addRow(row);
                }

                table.setModel(dataModel);
            }
        }
        catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    void handleTableSelection(){
        try{
            rs.absolute(table.getSelectedRow() + 1);

            udfrm_id.setText(Integer.toString(rs.getInt("id")));
            udfrm_sname.setText(rs.getString("sname"));
            udfrm_fname.setText(rs.getString("fname"));
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

