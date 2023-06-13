package com.airline.repository;

import com.airline.entity.OrderTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookTicketRepository extends JpaRepository<OrderTicket,Long> {
    @Query(" select o from OrderTicket o "+
           " join User u on o.user.id = u.id"+
           " where o.user.id = :userID"
    )
    List<OrderTicket> searchAllByUserID(String userID);
    OrderTicket findById(String id);
}
