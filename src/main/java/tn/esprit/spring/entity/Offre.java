package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Offre implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long offreId;
	
	private String titre ;
	
	@Enumerated(EnumType.STRING)
	private TypeOffre typeOffre;
	
	private String adresse ;
	
	private String description ;
	
	private int salaire;
	
	
	@Temporal(TemporalType.DATE)
	private Date datePublication;
	
	@ManyToMany(mappedBy="offre")

	private List<FileDB> files;
	
}
