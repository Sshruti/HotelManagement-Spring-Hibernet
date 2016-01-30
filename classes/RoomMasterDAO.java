package com.mikadosolutions.training.springmvc.bean;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.util.Collection;
 import java.util.List;

 import org.springframework.jdbc.core.RowMapper;
 import org.springframework.stereotype.Repository;
 import org.hibernate.SessionFactory;
 import org.hibernate.Session;
 import org.hibernate.Transaction;
 import org.hibernate.cfg.Configuration;
 import org.hibernate.HibernateException;
import com.mikadosolutions.training.springmvc.bean.Room;
 @Repository
public class RoomMasterDAO extends BaseDAO
 {

 public Collection<Room> getAvailableRooms()
	 {
	 Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Room> rooms = null;
		try
		{
       tx=session.beginTransaction();
	rooms = session.createQuery("FROM Room R where R.roomStatus ='A' ").list();
	rooms.toString();
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx != null)
				tx.rollback();
			System.out.println(e);
		}

			finally
		{
			session.close();
		}
		return rooms;
	 }

 public Collection<Room> getOccupiedRooms()
	 {
Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Room> rooms = null;
		try
		{
       tx=session.beginTransaction();
	rooms = session.createQuery("FROM Room R where R.roomStatus ='O' ").list();
	rooms.toString();
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx != null)
				tx.rollback();
			System.out.println(e);
		}

			finally
		{
			session.close();
		}
		return rooms;
	 }


	 public void allocateRoom(Room room)
	 {
		  Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
       tx=session.beginTransaction();
	Room actualRoom = (Room)session.get(Room.class,room.getRoomNumber());
     actualRoom.setRoomStatus("O");
     session.update(actualRoom);
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx != null)
				tx.rollback();
			System.out.println(e);
		}

			finally
		{
			session.close();
		}
		
	 }

 public void deallocateRoom(Room room)
	 {
		   Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
       tx=session.beginTransaction();
	Room actualRoom = (Room)session.get(Room.class,room.getRoomNumber());
     actualRoom.setRoomStatus("A");
     session.update(actualRoom);
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx != null)
				tx.rollback();
			System.out.println(e);
		}

			finally
		{
			session.close();
		}
	 }

 }
 