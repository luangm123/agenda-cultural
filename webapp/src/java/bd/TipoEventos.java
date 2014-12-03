/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bd;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author nuno
 */
@Entity
@Table(name = "tipo_eventos")
@NamedQueries({
    @NamedQuery(name = "TipoEventos.findAll", query = "SELECT t FROM TipoEventos t"),
    @NamedQuery(name = "TipoEventos.findById", query = "SELECT t FROM TipoEventos t WHERE t.id = :id"),
    @NamedQuery(name = "TipoEventos.findByNome", query = "SELECT t FROM TipoEventos t WHERE t.nome = :nome")})
public class TipoEventos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEventos")
    private Collection<Eventos> eventosCollection;

    public TipoEventos() {
    }

    public TipoEventos(Integer id) {
        this.id = id;
    }

    public TipoEventos(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Eventos> getEventosCollection() {
        return eventosCollection;
    }

    public void setEventosCollection(Collection<Eventos> eventosCollection) {
        this.eventosCollection = eventosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEventos)) {
            return false;
        }
        TipoEventos other = (TipoEventos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

}
