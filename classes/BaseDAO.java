package com.mikadosolutions.training.springmvc.bean;
import org.hibernate.SessionFactory;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDAO
{
	protected SessionFactory  sessionFactory;
		@Resource(name="hibernate4SessionFactory")
		public void setSessionFactory(SessionFactory  sessionFactory)
	{
		this.sessionFactory= sessionFactory;
	}

};
