package com.pabloabal.payments.service;

import com.pabloabal.payments.dto.PaymentDTO;
import com.pabloabal.payments.dto.UserDTO;
import com.pabloabal.payments.entity.Payment;
import com.pabloabal.payments.entity.User;
import com.pabloabal.payments.mapper.PaymentMapper;
import com.pabloabal.payments.mapper.UserMapper;
import com.pabloabal.payments.repository.PaymentRepository;
import com.pabloabal.payments.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private PaymentRepository paymentRepository;
    private UserMapper userMapper;
    private PaymentMapper paymentMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper, PaymentRepository paymentRepository,
                       PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.paymentMapper = paymentMapper;
    }

    public UserDTO findUser(Long id) {
        return null;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = this.userRepository.save(this.userMapper.map(userDTO));
        return this.userMapper.map(user);
    }

    public List<PaymentDTO> getPayments(Long id) {
        var result = new LinkedList<PaymentDTO>();
        var user = this.userRepository.findById(id);
        if (user.isPresent()) {
            List<Payment> payments = this.paymentRepository.findByUserId(id);
            result.addAll(this.paymentMapper.mapAll(payments));
        }
        return result;
    }
}
