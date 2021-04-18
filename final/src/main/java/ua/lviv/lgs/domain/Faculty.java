package ua.lviv.lgs.domain;

import java.util.Set;

public class Faculty {
	
	private Integer id;
	private String title;
	private Set<Subject> examSubjects;
	private Set<Speciality> specialities;
	
	
	public Faculty() {
	}


	public Faculty(Integer id, String title, Set<Subject> examSubjects, Set<Speciality> specialities) {
		this.id = id;
		this.title = title;
		this.examSubjects = examSubjects;
		this.specialities = specialities;
	}


	public Faculty(String title, Set<Subject> examSubjects, Set<Speciality> specialities) {
		super();
		this.title = title;
		this.examSubjects = examSubjects;
		this.specialities = specialities;
	}


	public Faculty(String title, Set<Subject> examSubjects) {
		super();
		this.title = title;
		this.examSubjects = examSubjects;
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


	public Set<Subject> getExamSubjects() {
		return examSubjects;
	}


	public void setExamSubjects(Set<Subject> examSubjects) {
		this.examSubjects = examSubjects;
	}


	public Set<Speciality> getSpecialities() {
		return specialities;
	}


	public void setSpecialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((examSubjects == null) ? 0 : examSubjects.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((specialities == null) ? 0 : specialities.hashCode());
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
		Faculty other = (Faculty) obj;
		if (examSubjects == null) {
			if (other.examSubjects != null)
				return false;
		} else if (!examSubjects.equals(other.examSubjects))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (specialities == null) {
			if (other.specialities != null)
				return false;
		} else if (!specialities.equals(other.specialities))
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
		return "Faculty [id=" + id + ", title=" + title + ", examSubjects=" + examSubjects + ", specialities="
				+ specialities + "]";
	}
	
	
	
	
	

}
