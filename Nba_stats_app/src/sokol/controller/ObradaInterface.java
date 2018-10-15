/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokol.controller;

import sokol.pomocno.NbaException;
import java.util.List;

/**
 *
 * @author Sokol
 */
public interface ObradaInterface <T>{
    public List<T> getEntiteti();
    public T dodaj(T e) throws NbaException;
    public T promjena(T e) throws NbaException;
    
}
