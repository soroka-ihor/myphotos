/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spoonjam.myphotos.model.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Swap
 */
@Entity
@Table(catalog = "myphotos", schema = "")
public class Photo extends AbstractDomain {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;
    
    @NotNull
    @Size(max = 255)
    @Basic(optional = false)
    @Column(name = "small_url", nullable = false, length = 255, updatable = false)
    private String smallUrl;
    
    @NotNull
    @Size(max = 255)
    @Basic(optional = false)
    @Column(name = "large_url", nullable = false, length = 255, updatable = false)
    private String largeUrl;
    
    @NotNull
    @Size(max = 255)
    @Basic(optional = false)
    @Column(name = "original_url", nullable = false, length = 255, updatable = false)
    private String originalUrl;
    
    @Min(0)
    @Basic(optional = false)
    @Column(nullable = false)
    private long views;
    
    @Min(0)
    @Basic(optional = false)
    @Column(nullable = false)
    private long downloads;
    
    @NotNull
    @JoinColumn(name = "profile_id", referencedColumnName = "id", nullable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Profile profileId;

    public Photo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public long getDownloads() {
        return downloads;
    }

    public void setDownloads(long downloads) {
        this.downloads = downloads;
    }


    public Profile getProfileId() {
        return profileId;
    }

    public void setProfileId(Profile profileId) {
        this.profileId = profileId;
    }
   
}