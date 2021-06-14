package tutorialjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class LihatData {
    public String Email,Username,Password,nama,TTL,Jenis,Domisili,Deskripsi;
    int jmlData;
    String data[][] = new String[500][4];
    
    Connector connector = new Connector();    
    
  
    JFrame window = new JFrame("JDBC");
    JTable tabel;
    DefaultTableModel tableModel; 
    JScrollPane scrollPane;
    Object namaKolom[] = {"Email","Username","Password","Nama","TTL","Jenis","Domisili","Deskripsi"}; 

    public LihatData(){
        window.setLayout(null);
        window.setSize(550,600);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        try{
            int jmlData = 0; 
            String query = "Select * from `input`"; 
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query); 
            while(resultSet.next()){ 
                data[jmlData][0] = resultSet.getString("Email"); 
                data[jmlData][1] = resultSet.getString("Username"); 
                data[jmlData][2] = resultSet.getString("Password");
                data[jmlData][3] = resultSet.getString("Nama");
                data[jmlData][4] = resultSet.getString("TTL"); 
                data[jmlData][5] = resultSet.getString("Jenis"); 
                data[jmlData][6] = resultSet.getString("Domisili");
                data[jmlData][7] = resultSet.getString("Deskripsi");
                jmlData++; 
            }
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
        
        tabel = new JTable(data,namaKolom); 
        scrollPane = new JScrollPane(tabel);
        window.add(scrollPane);
        
        scrollPane.setBounds(20, 35, 500, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        
    }
    
    public int getBanyakData(){ 
        int jmlData = 0; 
        try{
            connector.statement = connector.koneksi.createStatement();
            String query = "Select * from `input`";
            ResultSet resultSet = connector.statement.executeQuery(query); 
            while(resultSet.next()){ 
                jmlData++;
            }
            return jmlData; 
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
        
    }
    
    public String[][] readTiket(){
        try{
            int jmlData = 0; 
            String data[][] = new String[getBanyakData()][4];
            String query = "Select * from `input`"; 
            ResultSet resultSet = connector.statement.executeQuery(query); 
            while(resultSet.next()){
                data[jmlData][0] = resultSet.getString("Email"); 
                data[jmlData][1] = resultSet.getString("Username"); 
                data[jmlData][2] = resultSet.getString("Password");
                data[jmlData][3] = resultSet.getString("Nama");
                data[jmlData][3] = resultSet.getString("TTL");
                data[jmlData][3] = resultSet.getString("Jenis");
                data[jmlData][3] = resultSet.getString("Domisili");
                data[jmlData][3] = resultSet.getString("Deskripsi");
                jmlData++; 
                
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
}