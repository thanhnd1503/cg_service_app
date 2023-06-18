package com.airline.service.impl;

import com.airline.converter.PassengerConverter;
import com.airline.dto.passengerDto.request.PassengerDtoDetail;
import com.airline.dto.passengerDto.request.PassengerDtoRequest;
import com.airline.dto.userDto.request.UserDtoRequestDetail;
import com.airline.entity.OrderTicket;
import com.airline.entity.Passenger;
import com.airline.entity.User;
import com.airline.repository.PassengerRepository;
import com.airline.repository.UserRepository;
import com.airline.service.PassengerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PassengerConverter passengerConverter;
    @Override
    public Boolean save(PassengerDtoRequest passengerDtoRequest) {
        List<PassengerDtoDetail> passengerDtoDetails = passengerDtoRequest.getPassengerDtoDetails();
        UserDtoRequestDetail userDtoRequestDetail = passengerDtoRequest.getUserDtoRequestDetail();
        String email = userDtoRequestDetail.getEmail();
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            for (PassengerDtoDetail passengerDtoDetail : passengerDtoDetails) {
                Passenger passenger = passengerConverter.dtoToEntity(passengerDtoDetail);
                passenger.setUser(user);
                passengerRepository.save(passenger);
            }
            return true;
        }return false;

    }

    @Override
    public List<Passenger> findAllByOrders(OrderTicket orderTicket) {
        return passengerRepository.findAllByOrders(orderTicket);
    }
}
