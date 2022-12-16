/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Conex.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import Datos.Datos;

/**
 *
 * @author franco
 */
public class consultaDatos implements Operaciones {
    
    Datos t = new Datos();
    Conexion db = new Conexion();
    List<Datos> data = new ArrayList<>();
    String sql = "";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    
    @Override
    public boolean insert(Object obj) {
        t = (Datos) obj;
        this.sql = "insert into tipoDiccionario (nombreDic, versionDic) values(?,?)";
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(this.sql);
            
            this.pst.setString(1, this.t.getNombreDic());
            this.pst.setString(2, this.t.getVersionDic());
            
            
            int filas = this.pst.executeUpdate();
            this.con.close();
            
            return filas > 0;
            
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Excepciones controladas en: insertar tabla tipoDiccionario"+e.getMessage());
            return false;
        }   
    }

    @Override
     public boolean eliminar(Object obj){
        t = (Datos) obj;
        this.sql = "delete from tipoDiccionario where idDic =?";
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(this.sql);
           
            this.pst.setInt(1, this.t.getIdDic());
            
            int filas = this.pst.executeUpdate();
            this.con.close();
            return filas > 0;
            
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Este tipo de diccionario \n tiene contenido"
            + "y no se puede borrar");
            System.out.println("Excepciones controladas en: eliminar "+e.getMessage());
            return false;
        }
    }

   @Override
    public boolean modificar(Object obj){
        t = (Datos) obj;
        this.sql = "update tipoDiccionario set nombreDic=?, versionDic=? where idDic=?";
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(this.sql);
            


            this.pst.setString(1, this.t.getNombreDic());
            this.pst.setString(2, this.t.getVersionDic());
            this.pst.setInt(3, this.t.getIdDic());
            
            int filas = this.pst.executeUpdate();
            this.con.close();
            return filas > 0;
            
        } catch (SQLException | ClassNotFoundException e) {
           
            System.out.println("Excepciones controladas en: modificar talleres"+e.getMessage());
            return false;
        }   
    }
    @Override
    public List<?> seleccionar(){
        
        this.sql = "select * from tipoDiccionario";
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(sql);
            this.rs = this.pst.executeQuery();
            
            while (this.rs.next()) {
                data.add(new Datos(this.rs.getInt("idDic"),
                    this.rs.getString("nombreDic"),
                   this.rs.getString("versionDic")

                ));
            }
            
            this.con.close();
            this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
        
            System.out.println("Excepciones controladas en: seleccionar"+e.getMessage());
        }
        return this.data;
    }


}
