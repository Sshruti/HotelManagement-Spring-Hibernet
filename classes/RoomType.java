package com.mikadosolutions.training.springmvc.bean;

public class RoomType
{
	private int typeId;
	String typeName;

public RoomType()
	{
	}

	public RoomType( int typeId,String typeName)
	{
		this.typeId=typeId;
		this.typeName= typeName;
	}
	 public void setTypeId( int typeId)
	{
		 this.typeId=typeId;
	}
	public int getTypeId()
	{
		return typeId;
	}
	

	public void setTypeName(String typeName)
	{
this.typeName= typeName;
	}
	public String getTypeName()
	{
		return typeName;
	}


	public String toString()
	{
		return "typeId="+typeId+"typeName ="+typeName;
	}
};
