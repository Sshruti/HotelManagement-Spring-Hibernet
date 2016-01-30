package com.mikadosolutions.training.springmvc.bean;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Email;

public class User
{
   @NotEmpty
	@Email
	private String username;

    @NotEmpty
	private String password;

	public User()
	{
	}

	public User(  final String username, final String password)
	{
		this.username=username;
		this.password=password;
	}

	public void setUsername(String username)
	{
		this.username=username;
	}

	public String getUsername()
	{
		return username;

	}
public void setPassword(String password)
	{
		this.password=password;
	}

	public String getPassword()
	{
		return password;

	}
};
