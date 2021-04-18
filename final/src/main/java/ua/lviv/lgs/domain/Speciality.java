package ua.lviv.lgs.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "speciality")
public class Speciality {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="speciality_id")
	private Integer id;
	@Column
	private String title;
	@Column
	private Integer numberStudOnSpeciality;
	@ManyToOne
	@JoinColumn(name = "speciality_id", nullable = false)
	private Faculty faculty;
	@ManyToMany(mappedBy = "entrantSpeciality")//-----------------------------------------------------<<<
	private Set<Entrant> entrans;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "speciality")
	@Column(nullable = false)
	private Set<Entration> entrations;
	
	
	public Speciality() {
	}


	public Speciality(String title, Integer numberStudOnSpeciality, Faculty faculty, Set<Entrant> entrans,
			Set<Entration> entrations) {
		this.title = title;
		this.numberStudOnSpeciality = numberStudOnSpeciality;
		this.faculty = faculty;
		this.entrans = entrans;
		this.entrations = entrations;
	}


	public Speciality(Integer id, String title, Integer numberStudOnSpeciality, Faculty faculty, Set<Entrant> entrans,
			Set<Entration> entrations) {
		this.id = id;
		this.title = title;
		this.numberStudOnSpeciality = numberStudOnSpeciality;
		this.faculty = faculty;
		this.entrans = entrans;
		this.entrations = entrations;
	}


	public Speciality(String title, Integer numberStudOnSpeciality) {
		this.title = title;
		this.numberStudOnSpeciality = numberStudOnSpeciality;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Integer getNumberStudOnSpeciality() {
		return numberStudOnSpeciality;
	}


	public void setNumberStudOnSpeciality(Integer numberStudOnSpeciality) {
		this.numberStudOnSpeciality = numberStudOnSpeciality;
	}


	public Faculty getFaculty() {
		return faculty;
	}


	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}


	public Set<Entrant> getEntrans() {
		return entrans;
	}


	public void setEntrans(Set<Entrant> entrans) {
		this.entrans = entrans;
	}


	public Set<Entration> getEntrations() {
		return entrations;
	}


	public void setEntrations(Set<Entration> entrations) {
		this.entrations = entrations;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entrans == null) ? 0 : entrans.hashCode());
		result = prime * result + ((entrations == null) ? 0 : entrations.hashCode());
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numberStudOnSpeciality == null) ? 0 : numberStudOnSpeciality.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Speciality other = (Speciality) obj;
		if (entrans == null) {
			if (other.entrans != null)
				return false;
		} else if (!entrans.equals(other.entrans))
			return false;
		if (entrations == null) {
			if (other.entrations != null)
				return false;
		} else if (!entrations.equals(other.entrations))
			return false;
		if (faculty == null) {
			if (other.faculty != null)
				return false;
		} else if (!faculty.equals(other.faculty))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numberStudOnSpeciality == null) {
			if (other.numberStudOnSpeciality != null)
				return false;
		} else if (!numberStudOnSpeciality.equals(other.numberStudOnSpeciality))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Speciality [id=" + id + ", title=" + title + ", numberStudOnSpeciality=" + numberStudOnSpeciality
				+ ", faculty=" + faculty + ", entrans=" + entrans + ", entrations=" + entrations + "]";
	}
	
	
	

}
