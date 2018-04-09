package ar.edu.utn.frba.tadp.util;


public class Usuario {

	private Integer ID;
    
	private String username;
	
	private String password;
	
	private String email;

	private String firstname;

	private String lastname;
	
	private Integer lab;

	private Integer division;


	public Integer getID() {
		return ID;
	}


	public void setID(Integer iD) {
		ID = iD;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastName) {
		this.lastname = lastName;
	}


	public Integer getLab() {
		return lab;
	}


	public void setLab(Integer lab) {
		this.lab = lab;
	}


	public Integer getDivision() {
		return division;
	}


	public void setDivision(Integer division) {
		this.division = division;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result
				+ ((division == null) ? 0 : division.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lab == null) ? 0 : lab.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		Usuario other = (Usuario) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (division == null) {
			if (other.division != null)
				return false;
		} else if (!division.equals(other.division))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lab == null) {
			if (other.lab != null)
				return false;
		} else if (!lab.equals(other.lab))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Usuario [ID=" + ID + ", username=" + username + ", password="
				+ password + ", email=" + email + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", lab=" + lab + ", division="
				+ division + "]";
	}



	
}
