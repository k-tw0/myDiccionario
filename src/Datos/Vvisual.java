/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author franco
 */
public class Vvisual {
    private int idCodigo;
    private String codex;
    private ItemsMenusDatos idMenu;
    
    public Vvisual(){
    }
    
    public Vvisual(int idCodigo,
            String codex,
            ItemsMenusDatos idMenu) {
        
            this.idCodigo = idCodigo;
            this.codex = codex;
            this.idMenu = idMenu;
    }
    
    public ItemsMenusDatos getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(ItemsMenusDatos idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }

    public String getCodex() {
        return codex;
    }

    public void setCodex(String codex) {
        this.codex = codex;
    }
    
}
