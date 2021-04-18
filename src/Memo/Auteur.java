/*THIS CLASS IS FOR THE CONNECTION BETWEEN THE JTABLE AND THE DATABASE
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "auteur", catalog = "", schema = "")
@NamedQueries({
    @NamedQuery(name = "Auteur.findAll", query = "SELECT a FROM Auteur a")
    , @NamedQuery(name = "Auteur.findById", query = "SELECT a FROM Auteur a WHERE a.id = :id")
    , @NamedQuery(name = "Auteur.findByFamilynameauthor", query = "SELECT a FROM Auteur a WHERE a.familynameauthor = :familynameauthor")
    , @NamedQuery(name = "Auteur.findByNameauthor", query = "SELECT a FROM Auteur a WHERE a.nameauthor = :nameauthor")
    , @NamedQuery(name = "Auteur.findByBioauthor", query = "SELECT a FROM Auteur a WHERE a.bioauthor = :bioauthor")
    , @NamedQuery(name = "Auteur.findByImage", query = "SELECT a FROM Auteur a WHERE a.image = :image")})
public class Auteur implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Family_name_author")
    private String familynameauthor;
    @Basic(optional = false)
    @Column(name = "Name_author")
    private String nameauthor;
    @Basic(optional = false)
    @Column(name = "Bio_author")
    private String bioauthor;
    @Basic(optional = false)
    @Column(name = "Image")
    private String image;

    public Auteur() {
    }

    public Auteur(Integer id) {
        this.id = id;
    }

    public Auteur(Integer id, String familynameauthor, String nameauthor, String bioauthor, String image) {
        this.id = id;
        this.familynameauthor = familynameauthor;
        this.nameauthor = nameauthor;
        this.bioauthor = bioauthor;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getFamilynameauthor() {
        return familynameauthor;
    }

    public void setFamilynameauthor(String familynameauthor) {
        String oldFamilynameauthor = this.familynameauthor;
        this.familynameauthor = familynameauthor;
        changeSupport.firePropertyChange("familynameauthor", oldFamilynameauthor, familynameauthor);
    }

    public String getNameauthor() {
        return nameauthor;
    }

    public void setNameauthor(String nameauthor) {
        String oldNameauthor = this.nameauthor;
        this.nameauthor = nameauthor;
        changeSupport.firePropertyChange("nameauthor", oldNameauthor, nameauthor);
    }

    public String getBioauthor() {
        return bioauthor;
    }

    public void setBioauthor(String bioauthor) {
        String oldBioauthor = this.bioauthor;
        this.bioauthor = bioauthor;
        changeSupport.firePropertyChange("bioauthor", oldBioauthor, bioauthor);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        String oldImage = this.image;
        this.image = image;
        changeSupport.firePropertyChange("image", oldImage, image);
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
        if (!(object instanceof Auteur)) {
            return false;
        }
        Auteur other = (Auteur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Memo.Auteur[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
