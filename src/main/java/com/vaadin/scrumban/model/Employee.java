package com.vaadin.scrumban.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "employee" )
public class Employee implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "EmpID" )
	@GeneratedValue
	private Integer id;

	@Column( name = "firstname" )
	private String firstname;

	@Column( name = "lastname" )
	private String lastname;

	@Column( name = "address" )
	private String age;

	public Integer getId()
	{
		return id;
	}

	public void setId( final Integer id )
	{
		this.id = id;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname( final String firstname )
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname( final String lastname )
	{
		this.lastname = lastname;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge( final String age )
	{
		this.age = age;
	}

}
