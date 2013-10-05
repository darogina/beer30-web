package com.github.darogina.beer30.entity;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class EntityRevisionListener implements RevisionListener {

    private static final String SYSTEM_USER = "system";

    @Override
    public void newRevision(Object revisionEntity) {
        RevisionEntity cicadaRevisionEntity = (RevisionEntity) revisionEntity;
        cicadaRevisionEntity.setUsername(getUserFromSecurityContext());
    }

    private String getUserFromSecurityContext() {

        //TODO: Implement security context lookup
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object user = authentication.getPrincipal();
            if(user instanceof UserEntity) {
                return ((UserEntity) user).getUsername();
            } else if(user instanceof String) {
                return (String) user;
            }
        }

        return SYSTEM_USER;
    }
}
