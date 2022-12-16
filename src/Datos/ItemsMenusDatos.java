/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;


/**
 *
 * @author franco
 */
public class ItemsMenusDatos {
    
    private int idMenu;
    private String nombreMenu;
    private Datos idDic;
    
    public ItemsMenusDatos(int idMenu){
        this.idMenu=idMenu;
    }
    
    public ItemsMenusDatos(){
    }
    
    public ItemsMenusDatos(int idMenu,
            String nombreMenu,
            Datos idDic) {
        
            this.idMenu = idMenu;
            this.nombreMenu = nombreMenu;
            this.idDic = idDic;
    }
    
    public Datos getIdDic() {
        return idDic;
    }

    public void setIdDic(Datos idDic) {
        this.idDic = idDic;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    
    
   
   
    
}
