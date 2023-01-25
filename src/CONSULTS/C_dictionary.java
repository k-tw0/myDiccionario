/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONSULTS;

import CONEXION.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import UML.Dictionary;
import java.util.Arrays;

/**
 *
 * @author franco
 */
public class C_dictionary implements Operaciones {
    
    Dictionary objDic = new Dictionary();
    
    Conexion db = new Conexion(); 
    List<Dictionary> data = new ArrayList<>();
    String sql = ""; 
    PreparedStatement pst; 
    ResultSet rs; 
    Connection con;
    
    String [] tagConsults = {"insert","delete","update", "select"}; List<String> c = Arrays.asList(tagConsults);
    String className =this.getClass().getSimpleName(); String enc = "["+className+"]"; 
    
    @Override
    public boolean insert(Object obj) {
        System.out.print(c.get(0));
        objDic = (Dictionary) obj;
        this.sql = "insert into tipoDiccionario (nombreDic, versionDic) values(?,?)";
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(this.sql);
            
            this.pst.setString(1, this.objDic.getNombreDic());
            this.pst.setString(2, this.objDic.getVersionDic());
            
            System.out.print( "" + this.objDic.getNombreDic());
            
            int filas = this.pst.executeUpdate();
            this.con.close();
            
            return filas > 0;
            
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Excepcion: "+ enc + " in operation "+ c.get(0) + ". Error: " +e.getMessage());
            return false;
        }   
    }

    @Override
     public boolean delete(Object obj){
        objDic = (Dictionary) obj;
        this.sql =  c.get(1) + " from tipoDiccionario where idDic =?";
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(this.sql);
           
            this.pst.setInt(1, this.objDic.getIdDic());
            
            int filas = this.pst.executeUpdate();
            this.con.close();
            return filas > 0;
            
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Este tipo de diccionario \n tiene contenido"
            + "y no se puede borrar");
            System.out.println("Excepcion: "+ enc + " in operation "+ c.get(1) + ". Error: " +e.getMessage());
            return false;
        }
    }

   @Override
    public boolean update(Object obj){
        objDic = (Dictionary) obj;
        this.sql = c.get(2) +" tipoDiccionario set nombreDic=?, versionDic=? where idDic=?";
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(this.sql);
            


            this.pst.setString(1, this.objDic.getNombreDic());
            this.pst.setString(2, this.objDic.getVersionDic());
            this.pst.setInt(3, this.objDic.getIdDic());
            
            int filas = this.pst.executeUpdate();
            this.con.close();
            return filas > 0;
            
        } catch (SQLException | ClassNotFoundException e) {
           
            System.out.println("Excepcion: "+ enc + " in operation "+ c.get(2) + ". Error: " +e.getMessage());
            return false;
        }   
    }
    @Override
    public List<?> __SelectObject(String obj){
        
        this.sql = "select * from tipoDiccionario";
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(sql);
            this.rs = this.pst.executeQuery();
            
            while (this.rs.next()) {
                data.add(new Dictionary(this.rs.getInt("idDic"),
                    this.rs.getString("nombreDic"),
                   this.rs.getString("versionDic")

                ));
            }
            
            this.con.close();
            this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
        
            System.out.println("Excepcion: "+ enc + " in operation "+ c.get(3) + ". Error: " +e.getMessage());
        }
        return this.data;
    }

    @Override
    public List<?> mostrarTextArea(String idMen, String idCod) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<?> selectMenu(String idMenu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
