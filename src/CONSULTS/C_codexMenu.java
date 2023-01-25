/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONSULTS;

import CONEXION.Conexion;
import UML.CodexMenuDic;
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
public class C_codexMenu implements Operaciones {
    
    Conexion db = new Conexion();
    
    CodexMenuDic umlCodexMenu= new CodexMenuDic();
    List<CodexMenuDic> data3 = new ArrayList<>();
    
    String sql = "";
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    
    String [] tagConsults = {"insert","delete","update", "select"}; List<String> c = Arrays.asList(tagConsults);
    String className =this.getClass().getSimpleName(); String enc = "["+className+"]"; 

    @Override
    public boolean insert(Object obj) {
        umlCodexMenu = (CodexMenuDic) obj;
        this.sql = c.get(0) + " into regCodigo"
                + "(codex,idMenu)"
                + "values (?,?)";
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(this.sql);
            this.pst.setString(1, this.umlCodexMenu.getCodex());
            this.pst.setInt(2, this.umlCodexMenu.getIdMenu().getIdMenu());
            int filas = this.pst.executeUpdate();
            this.con.close();
            return filas > 0;
            
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "El codigo seleccionado no existe");
            System.out.println("Excepcion: "+ enc + " in operation "+ c.get(0) + ". Error: " +e.getMessage());
            return false;
        }   
    }

    @Override
    public boolean delete(Object obj) {
        
        umlCodexMenu = (CodexMenuDic) obj;
        this.sql =  c.get(1) + " from regCodigo where idCodigo =?";
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(this.sql);
           
            this.pst.setInt(1, this.umlCodexMenu.getIdCodigo());
            
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
        umlCodexMenu = (CodexMenuDic) obj;
        this.sql = c.get(2) + " regCodigo set codex=? where idCodigo=?";
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(this.sql);
            

            this.pst.setString(1, this.umlCodexMenu.getCodex());
            this.pst.setInt(2, this.umlCodexMenu.getIdCodigo());
            
            int filas = this.pst.executeUpdate();
            this.con.close();
            return filas > 0;
            
        } catch (SQLException | ClassNotFoundException e) {
           
            System.out.println("Excepcion: "+ enc + " in operation "+ c.get(2) + ". Error: " +e.getMessage());
            return false;
        }   
    }

    @Override
    public List<?> __SelectObject(String obj) {
           throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List<?> selectMenu(String idMenu) {
        
        String i = idMenu;
        
        this.sql = c.get(3) + " * FROM db_myDiccionarium.regCodigo Where idMenu = " + i;
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(this.sql);
            this.rs = this.pst.executeQuery();

            while (this.rs.next()) {
                data3.add(new CodexMenuDic(this.rs.getInt("idCodigo"),
                    this.rs.getString("codex"),
                    new MenuDictionary(this.rs.getInt("idMenu"))
                ));
            }
            
            this.con.close();
            this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
        
           System.out.println("Excepcion: "+ enc + " in operation "+ c.get(3) + ". Error: " +e.getMessage());
        }
        return this.data3;
    }
    
    @Override
    public List<?> mostrarTextArea(String idMen, String idCod) {
        
        String i = idMen;
        String cod = idCod;
        System.out.println("idmenu: "+ i + " idCod: " + idCod);

        this.sql = c.get(3) + " * FROM db_myDiccionarium.regCodigo WHERE idMenu = " + i + " AND idCodigo = " + cod;
        try {
            Class.forName(db.getDriver());
            this.con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            this.pst = this.con.prepareStatement(this.sql);
            this.rs = this.pst.executeQuery();

            while (this.rs.next()) {
                data3.add(new CodexMenuDic(this.rs.getInt("idCodigo"),
                    this.rs.getString("codex"),
                    new MenuDictionary(this.rs.getInt("idMenu"))
                ));
            }
            
            this.con.close();
            this.rs.close();
            
        } catch (SQLException | ClassNotFoundException e) {
        
            System.out.println("mostrar TextArea"+e.getMessage());
        }
        return this.data3;
    }
    
}
