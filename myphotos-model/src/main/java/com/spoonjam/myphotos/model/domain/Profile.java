/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.model.domain;

import com.spoonjam.myphotos.model.validation.Email;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Swap
 */
@Entity
@Table(catalog = "myphotos", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email"})
    , @UniqueConstraint(columnNames = {"uid"})})
public class Profile extends AbstractDomain {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;
    
    @NotNull
    @Size(max = 255)
    @Basic(optional = false)
    @Column(unique = true, nullable = false, length = 255, updatable = false)
    private String uid;
    
    @NotNull
    @Size(max = 100)
    @Email
    @Basic(optional = false)
    @Column(nullable = false, length = 100, unique = true, updatable = false)
    private String email;
    
    @NotNull(message = "{Profile.firstName.NotNull}")
    @Size (min = 1, max = 60, message = "{Profile.firstName.Size}")
    //@EnglishLanguage(withNumbers = false, withPunctuation = false, withSpecialSymbols = false)
    @Basic(optional = false)
    @Column(name = "first_name", nullable = false, length = 60)
    private String firstName;
    
    @NotNull(message = "{Profile.firstName.NotNull}")
    @Size (min = 1, max = 60, message = "{Profile.firstName.Size}")
    //@EnglishLanguage(withNumbers = false, withPunctuation = false, withSpecialSymbols = false)
    @Basic(optional = false)
    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;
    
    @NotNull
    @Size (max = 255)
    @Basic(optional = false)
    @Column(name = "avatar_url", nullable = false, length = 255)
    private String avatarUrl;
    
    @NotNull(message = "{Profile.firstName.NotNull}")
    @Size (min = 1, max = 100, message = "{Profile.firstName.Size}")
    //@EnglishLanguage(withNumbers = false, withPunctuation = false, withSpecialSymbols = false)
    @Basic(optional = false)
    @Column(name = "job_title", nullable = false, length = 100)
    private String jobTitle;
    
    @NotNull(message = "{Profile.firstName.NotNull}")
    @Size (min = 1, max = 100, message = "{Profile.firstName.Size}")
    //@EnglishLanguage(withNumbers = false, withPunctuation = false, withSpecialSymbols = false)
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String location;
    
    @NotNull
    @Min(0)
    @Basic(optional = false)
    @Column(name = "photo_count", nullable = false)
    private int photoCount;
    
    @NotNull
    @Min(0)
    @Basic(optional = false)
    @Column(nullable = false)
    private int rating;
   

    public Profile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(int photoCount) {
        this.photoCount = photoCount;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
}
