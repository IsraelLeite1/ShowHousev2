package com.qintess.spring.validation;

public class ClientValidation {

	private Long id;

	private String username;

	private String password;

	private String name;

	private String cpf;

	private String birthDate;

	private String email;

	private String type;

	public ClientValidation() {
		super();
	}

	public ClientValidation(String username, String password, String name, String cpf, String birthDate, String email) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", cpf=" + cpf + ", birthDate=" + birthDate + ", email=" + email
				+ "]";
	}

}
