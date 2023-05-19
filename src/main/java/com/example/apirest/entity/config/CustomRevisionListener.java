package com.example.apirest.entity.config;

import org.hibernate.envers.RevisionListener;

import com.example.apirest.entity.audit.Revision;

public class CustomRevisionListener implements RevisionListener {

	public void newRevision(Object revisionEntity) {
		final Revision revision = (Revision) revisionEntity; 
	}
	
}
