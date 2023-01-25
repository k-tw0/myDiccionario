/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONSULTS;

import CONEXION.Conexion;
import UML.Dictionary;
import UML.MenuDictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author franco
 */
public class C_menuDictionary implements Operaciones {
    
    MenuDictionary umlMenuDic = new MenuDictionary();
    Conexion db = new Conexion();
    
    List<MenuDictionary> data = new ArrayList<>();
    String sql = "";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    
    String [] tagConsults = {"insert","delete","update", "select"}; List<String> c = Arrays.asList(tagConsults);
    String className =this.getClass().getSimpleName(); String enc = "["+className+"]"; 

     @Override
    public boolean insert(Object obj){
        umlMenuDic = (MenuDictionary) obj;
        this.sql = c.get(0) + " into menuItems"
                + "(nombreMenu,idDic)"
                + "values (?,?)";
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, this.umlMenuDic.getNombreMenu());
            this.pst.setInt(2, this.umlMenuDic.getIdDic().getIdDic());
            int filas = this.pst.executeUpdate();
            this.con.close();
            return filas > 0;
            
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "El menu o proyecto seleccionado no existe.");
            System.out.println("Excepcion: "+ enc + " in operation "+ c.get(0) + ". Error: " +e.getMessage());
            return false;
        }   
    }

    @Override
    public boolean delete(Object obj) {
       umlMenuDic = (MenuDictionary) obj;
        this.sql =  c.get(1) + " from menuItems where idMenu =?";
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(this.sql);
           
            this.pst.setInt(1, this.umlMenuDic.getIdMenu());
            
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
    public boolean update(Object obj) {
        umlMenuDic = (MenuDictionary) obj;
        this.sql = c.get(2) + " menuItems set nombreMenu=? where idMenu=?";
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(this.sql);
            

            this.pst.setString(1, this.umlMenuDic.getNombreMenu());
            this.pst.setInt(2, this.umlMenuDic.getIdMenu());
            
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
        //System.out.println("ID Diccionario: " + obj);
        this.sql = c.get(3) + " * FROM db_myDiccionarium.menuItems WHERE idDic = " + obj;
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(this.sql);
            this.rs = this.pst.executeQuery();

            while (this.rs.next()) {
                data.add(new MenuDictionary(this.rs.getInt("idMenu"),
                    this.rs.getString("nombreMenu"),
                    new Dictionary(this.rs.getInt("idDic"))
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
    public List<?> selectMenu(String obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
