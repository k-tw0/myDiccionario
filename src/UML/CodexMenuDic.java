/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UML;

/**
 *
 * @author franco
 */
public class CodexMenuDic {
    
    private int idCodigo;
    private String txtCodex;
    private MenuDictionary idMenu;
    
    public CodexMenuDic(int idCodigo){
        this.idCodigo=idCodigo;
    }
    
    public CodexMenuDic(){
    }
    
    public CodexMenuDic(int idCodigo,
            String txtCodex,
            MenuDictionary idMenu) {
        
            this.idCodigo = idCodigo;
            this.txtCodex = txtCodex;
            this.idMenu = idMenu;
    }
    
    public MenuDictionary getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(MenuDictionary idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }

    public String getCodex() {
        return txtCodex;
    }

    public void setCodex(String txtCodex) {
        this.txtCodex = txtCodex;
    }
    
}
