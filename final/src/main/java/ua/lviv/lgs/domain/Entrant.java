package ua.lviv.lgs.domain;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "entrant")
public class Entrant extends User{
	
	@Column
	private LocalDate birthDate;
	@Column
	private String adress;
	@Column
	private String school;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="speciality_entrant", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
	private Set<Speciality> entrantSpeciality;
	 @MapsId
	    private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "entrant")
	@Column(nullable = false)
	private Set<Entration> entrations;

	public Entrant(LocalDate birthDate, String adress, String school) {

		this.birthDate = birthDate;
		this.adress = adress;
		this.school = school;
	}

	public Entrant(LocalDate birthDate, String adress, String school, Set<Speciality> entrantSpeciality,
			Set<Entration> entrations) {

		this.birthDate = birthDate;
		this.adress = adress;
		this.school = school;
		this.entrantSpeciality = entrantSpeciality;
		this.entrations = entrations;
	}

	public Entrant() {

	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Set<Speciality> getEntrantSpeciality() {
		return entrantSpeciality;
	}

	public void setEntrantSpeciality(Set<Speciality> entrantSpeciality) {
		this.entrantSpeciality = entrantSpeciality;
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
		int result = super.hashCode();
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((entrantSpeciality == null) ? 0 : entrantSpeciality.hashCode());
		result = prime * result + ((entrations == null) ? 0 : entrations.hashCode());
		result = prime * result + ((school == null) ? 0 : school.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrant other = (Entrant) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (entrantSpeciality == null) {
			if (other.entrantSpeciality != null)
				return false;
		} else if (!entrantSpeciality.equals(other.entrantSpeciality))
			return false;
		if (entrations == null) {
			if (other.entrations != null)
				return false;
		} else if (!entrations.equals(other.entrations))
			return false;
		if (school == null) {
			if (other.school != null)
				return false;
		} else if (!school.equals(other.school))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Entrant [birthDate=" + birthDate + ", adress=" + adress + ", school=" + school + ", entrantSpeciality="
				+ entrantSpeciality + ", entrations=" + entrations + "]";
	}

	
	
	
	

}

	