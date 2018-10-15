/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokol.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Profesor
 */
@MappedSuperclass
public abstract class Entitet {
    public abstract String getCSV();
    @Id
    @GeneratedValue
    private Integer idNba;

    public Integer getIdNba() {
        return idNba;
    }

    public void setIdNba(Integer sifra) {
        this.idNba=idNba;
    }
    
}
