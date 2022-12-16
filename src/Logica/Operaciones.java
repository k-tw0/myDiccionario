/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Logica;

import java.util.List;

/**
 *
 * @author franco
 */
public interface Operaciones {
    public boolean insert(Object obj);
    public boolean eliminar(Object obj);
    public boolean modificar(Object obj);
    public List<?> seleccionar();
}
