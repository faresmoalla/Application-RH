package tn.esprit.spring.entity;

import org.springframework.security.core.GrantedAuthority;
public enum RoleName implements
GrantedAuthority {
Client,
SUPERADMIN;
@Override
public String getAuthority() {
return "ROLE_" + name();
}}