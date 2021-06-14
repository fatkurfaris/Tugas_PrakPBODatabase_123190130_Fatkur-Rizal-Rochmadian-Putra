package tutorialjdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class InputData extends JFrame{
    public String Email,Username,Password,Nama,TTL,Jenis,Domisili,Deskripsi;
    
    Connector connector = new Connector();    
    

    JFrame window = new JFrame("Formulir Input Data");
    
    JLabel lEmail = new JLabel("Email");
        JTextField tfEmail = new JTextField();
    JLabel lUsername= new JLabel("Username");
        JTextField tfUsername = new JTextField();
    JLabel lPassword = new JLabel("Password");
        JTextField tfPassword = new JTextField();
    JLabel lNama = new JLabel("Nama");
        JTextField tfNama = new JTextField();
    JLabel lTTL = new JLabel("TTL");
        JTextField tfTTL = new JTextField();
    JLabel lJenis = new JLabel("Jenis Kelamin");
        JTextField tfJenis = new JTextField();
    JLabel lDomisili = new JLabel("Domisili");
        JTextField tfDomisili = new JTextField();
    JLabel lDeskripsi = new JLabel("Deskripsi");
        JTextField tfDeskripsi = new JTextField();

    JButton btnTambahPanel = new JButton("Tambah");
    JButton btnLihat = new JButton("Lihat");

    public InputData() {
        window.setLayout(null);
        window.setSize(550,300);
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);


       // setDefaultCloseOperation(EXIT_ON_CLOSE);

//ADD COMPONENT
        window.add(tfEmail);
        window.add(tfUsername);
        window.add(tfPassword);
        window.add(tfNama);
        window.add(tfTTL);
        window.add(tfJenis);
        window.add(tfDomisili);
        window.add(tfDeskripsi);
        
        window.add(lEmail);
        window.add(lUsername);
        window.add(lPassword);
        window.add(lNama);
        window.add(lTTL);
        window.add(lJenis);
        window.add(lDomisili);
        window.add(lDeskripsi);
        window.add(btnTambahPanel);
        window.add(btnLihat);



//LABEL
        lEmail.setBounds(5, 35, 120, 20);
        lUsername.setBounds(5, 60, 120, 20);
        lPassword.setBounds(5,85,120,20);
        lNama.setBounds(5,105,120,20);
        lTTL.setBounds(5, 130, 120, 20);
        lJenis.setBounds(5, 155, 120, 20);
        lDomisili.setBounds(5,180,120,20);
        lDeskripsi.setBounds(5,205,120,20);

//TEXTFIELD
        tfEmail.setBounds(110, 35, 120, 20);
        tfUsername.setBounds(110, 60, 120, 20);
        tfPassword.setBounds(110, 85, 120, 20);
        tfNama.setBounds(110, 105, 120, 20);
        tfTTL.setBounds(110, 130, 120, 20);
        tfJenis.setBounds(110, 155, 120, 20);
        tfDomisili.setBounds(110, 180, 120, 20);
        tfDeskripsi.setBounds(110, 205, 120, 20);


//BUTTON PANEL
        btnTambahPanel.setBounds(250, 35, 90, 20);
        btnLihat.setBounds(250,60,90,20);

        
        btnTambahPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                   try {
                String query = "INSERT INTO `input`(`Email`, `Username`,"
                        + "`Password`,`Nama`,`TTL`.`Jenis`,`Domisili,`Deskripsi`) "
                            + "VALUES ('"+getEmail()+"','"+getUsername()+"','"+getPassword()
                        +"','"+getNama()+"','"+getTTL()+"','"+getJenis()+"','"
                        +getDomisili()+"','"+getDeskripsi()+"')";
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);

            System.out.println("Insert Berhasil");
            JOptionPane.showMessageDialog(null,"Insert Berhasil !!");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
            }
        });
        
        btnLihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                LihatData lihat = new LihatData();
            }
        });
    }
    
    

    public String getEmail(){
        return tfEmail.getText();
    }

    public String getUsername() {
        return tfUsername.getText();
    }

    public String getPassword() {
        return tfPassword.getText();
    }

    public String getNama() {
        return tfNama.getText();
    }
    
        public String getTTL(){
        return tfTTL.getText();
    }

    public String getJenis() {
        return tfJenis.getText();
    }

    public String getDomisili() {
        return tfDomisili.getText();
    }

    public String getDeskripsi() {
        return tfDeskripsi.getText();
    }
    
    public void inputDB(){
        
    }
}

