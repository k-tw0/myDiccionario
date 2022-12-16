/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conex;

/**
 *
 * @author franco
 */
public class Conexion {
    private String db = "db_myDiccionarium";
    private String driver;
    private String url;
    private String usuario;
    private String clave;
  
    public Conexion(){
        this.driver="com.mysql.cj.jdbc.Driver";
        this.url="jdbc:mysql://localhost:3306/"+db;
        this.usuario="root";
        this.clave="password";
    }
    
    public Conexion(String driver, String url, String usuario, String clave) {
        this.driver = driver;
        this.url = url;
        this.usuario = usuario;
        this.clave = clave;
    }
    
    public String getDriver(){
        return driver;
    }
    
    public void setDriver(String driver) {
        this.driver = driver;
    }
     public String getUrl(){
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
     public String getUsuario(){
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
     public String getClave(){
        return clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
}
