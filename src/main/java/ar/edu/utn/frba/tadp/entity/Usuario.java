package ar.edu.utn.frba.tadp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/* La anotacion @Entity se usa para marcar la clase como un entity bean que puede ser persistido por hibernate,
 * dado que hibernate proporciona implementacion a JPA.
 * La anotacion @Table se usa para definir el mapeo de la tabla y las constrains para las columnas
 *  */
@Entity
@Table(name="USUARIO")
public class Usuario {
	/*@Id = Esta anotacion se usa para definir la primary key de la tabla.
	 * @GeneratedValue = se usa para definir que el campo generado automaticaente, usando la estrategia
	 * GenerationType.IDENTITY para que el valor "ID" generado se asigne al bean y luego se pueda recuperar.
	 * @Column = se usa para mapear el campo con la columna, y se puede especificar longitud, si es nullable y unicidad.
	 * */
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer ID;
    
/*	@NotEmpty
    @Size(min=8, max=8)*/
	@Column(name = "USERNAME", unique= true, nullable = false)
	private String username;
	
/*    @NotNull
    @Size(min=3, max=8)*/
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
/*	@NotEmpty*/
	@Column(name = "EMAIL")
	private String email;
	
/*	@NotEmpty*/
	@Column(name = "FIRST_NAME")
	private String firstname;

/*	@NotEmpty*/
	@Column(name = "LAST_NAME")
	private String lastname;
	
/*	@NotNull
	@Digits(integer=1, fraction=0)*/
	@Column(name = "LAB", nullable = false)
	private Integer lab;

/*	@NotNull
	@Digits(integer=1, fraction=0)*/
	@Column(name = "DIVISION", nullable = false)
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
