/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CONSULTS;

import java.util.List;

/**
 *
 * @author franco
 */
public interface Operaciones {
    public boolean insert(Object obj);
    public boolean delete(Object obj);
    public boolean update(Object obj);
    
    public List<?> __SelectObject(String obj);
    public List<?> selectMenu(String idMenu);
    public List<?> mostrarTextArea(String idMen, String idCod);
}

/**
Ofuscar modo letras.
public interface c {
    public boolean a(Object obj);
    public boolean b(Object obj);
    public boolean c(Object obj);
    
    public List<?> d(String obj);
    public List<?> e(String idMenu);
    public List<?> f(String idMen, String idCod);
}
 */