package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class FileDB implements Serializable {


	private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  
  private Long id;
  
  @NonNull
  private String name;
  
  @NonNull
  private String type;
  
  @Lob
  @NonNull
  private byte[] data;
  
  
  
  @ManyToMany
  @JsonIgnore
  private List<User> user;
  
  @ManyToMany
  @JsonIgnore
  private List<Candidature> candidature;

  @ManyToMany
  @JsonIgnore
  private List<Offre> offre;
  
  
 
}