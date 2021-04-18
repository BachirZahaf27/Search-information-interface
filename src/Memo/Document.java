/*
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
@Table(name = "document", catalog = "", schema = "")
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
    , @NamedQuery(name = "Document.findById", query = "SELECT d FROM Document d WHERE d.id = :id")
    , @NamedQuery(name = "Document.findByAuthor", query = "SELECT d FROM Document d WHERE d.author = :author")
    , @NamedQuery(name = "Document.findByNamedocument", query = "SELECT d FROM Document d WHERE d.namedocument = :namedocument")
    , @NamedQuery(name = "Document.findByPathdocument", query = "SELECT d FROM Document d WHERE d.pathdocument = :pathdocument")})
public class Document implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Author")
    private String author;
    @Basic(optional = false)
    @Column(name = "Name_document")
    private String namedocument;
    @Basic(optional = false)
    @Column(name = "Path_document")
    private String pathdocument;

    public Document() {
    }

    public Document(Integer id) {
        this.id = id;
    }

    public Document(Integer id, String author, String namedocument, String pathdocument) {
        this.id = id;
        this.author = author;
        this.namedocument = namedocument;
        this.pathdocument = pathdocument;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        String oldAuthor = this.author;
        this.author = author;
        changeSupport.firePropertyChange("author", oldAuthor, author);
    }

    public String getNamedocument() {
        return namedocument;
    }

    public void setNamedocument(String namedocument) {
        String oldNamedocument = this.namedocument;
        this.namedocument = namedocument;
        changeSupport.firePropertyChange("namedocument", oldNamedocument, namedocument);
    }

    public String getPathdocument() {
        return pathdocument;
    }

    public void setPathdocument(String pathdocument) {
        String oldPathdocument = this.pathdocument;
        this.pathdocument = pathdocument;
        changeSupport.firePropertyChange("pathdocument", oldPathdocument, pathdocument);
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
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Memo.Document[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
