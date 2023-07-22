package com.durgesh.Hotel_Manage.repo;
import com.durgesh.Hotel_Manage.model.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
public interface IRoomRepo extends JpaRepository<HotelRoom,Long> {

}
