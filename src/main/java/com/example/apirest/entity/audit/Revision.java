package com.example.apirest.entity.audit;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import com.example.apirest.entity.config.CustomRevisionListener;

import lombok.Data;

@Entity
@Table(name="REVISION_INFO")

// anotacion ENVERS
@RevisionEntity(CustomRevisionListener.class)

// anotacion LOMBOK
@Data                 // combina las anotaciones @Getter, @Setter y @ToString

public class Revision implements Serializable {
	
	// atributo constante (final)
	private static final Long serialVersionUID = 1L;
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revision_seq")
	@SequenceGenerator(
			name = "revision_seq",
			sequenceName = "rbac.seq_revision_id"
	)
	@RevisionNumber
	private int Id;
	
	@Column(name = "REVISION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@RevisionTimestamp
	private Date date;
	
}
