/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UML;


/**
 *
 * @author franco
 */
public class MenuDictionary {
    
    private int idMenu;
    private String nombreMenu;
    private Dictionary idDic;
    
    public MenuDictionary(int idMenu){
        this.idMenu=idMenu;
    }
    
    public MenuDictionary(){
    }
    
    public MenuDictionary(int idMenu,
            String nombreMenu,
            Dictionary idDic) {
        
            this.idMenu = idMenu;
            this.nombreMenu = nombreMenu;
            this.idDic = idDic;
    }
    
    public Dictionary getIdDic() {
        return idDic;
    }

    public void setIdDic(Dictionary idDic) {
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
