package com.crm.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "reporting")
public class Reporting {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
    private Long id;
	
	@Column(name = "content", nullable = false, columnDefinition = "TEXT")
	private String content;
	
	@ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id")
	@JsonManagedReference
    private Utilisateur user;
	
	 	@Column(name = "createdat", nullable = true)
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date createdAt;

	    @Column(name = "updatedat", nullable = true)
	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    private Date updatedAt;

	    @Column(name = "deletedat", nullable = true)
	    private Date deletedAt;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Utilisateur getUser() {
			return user;
		}

		public void setUser(Utilisateur user) {
			this.user = user;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public Date getDeletedAt() {
			return deletedAt;
		}

		public void setDeletedAt(Date deletedAt) {
			this.deletedAt = deletedAt;
		}

	    
}
