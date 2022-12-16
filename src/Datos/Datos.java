/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author franco
 */
public class Datos {
    
    
    private int idDic;
    private String nombreDic;
    private String versionDic;
    
    public Datos(int idDiccionario) {
        this.idDic=idDiccionario;
    }
    
    public Datos(){
    }
    
    public Datos(int idDic, String nombreDic, String versionDic) {
        this.idDic = idDic;
        this.nombreDic = nombreDic;
        this.versionDic = versionDic;
    }

    public int getIdDic() {
        return idDic;
    }

    public String getNombreDic() {
        return nombreDic;
    }

    public String getVersionDic() {
        return versionDic;
    }

    public void setIdDic(int idDic) {
        this.idDic = idDic;
    }

    public void setNombreDic(String nombreDic) {
        this.nombreDic = nombreDic;
    }

    public void setVersionDic(String versionDic) {
        this.versionDic = versionDic;
    }
    
}

