/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Conex.Conexion;
import Datos.ItemsMenusDatos;
import Datos.Vvisual;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author franco
 */
public class consultasVvisual implements Operaciones {
    
    Vvisual consulta = new Vvisual();
    Conexion db = new Conexion();
    
    List<Vvisual> data = new ArrayList<>();
    String sql = "";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;

    @Override
    public boolean insert(Object obj) {
        consulta = (Vvisual) obj;
        this.sql = "insert into regCodigo"
                + "(codex,idMenu)"
                + "values (?,?)";
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, this.consulta.getCodex());
            this.pst.setInt(2, this.consulta.getIdMenu().getIdMenu());
            int filas = this.pst.executeUpdate();
            this.con.close();
            return filas > 0;
            
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "El taller seleccionado no existe");
            System.out.println("Excepciones controladas en:  "+e.getMessage());
            return false;
        }   
    }

    @Override
    public boolean eliminar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<?> seleccionar() {
         this.sql = "select * from regCodigo";
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(this.sql);
            this.rs = this.pst.executeQuery();

            while (this.rs.next()) {
                data.add(new Vvisual(this.rs.getInt("idMenu"),
                    this.rs.getString("nombreMenu"),
                    new ItemsMenusDatos(this.rs.getInt("idDic"))
                ));
            }
            
            this.con.close();
            this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
        
            System.out.println("Excepciones controladas en: Seleccionar(Suscripcion) "+e.getMessage());
        }
        return this.data;
    }


    
}
