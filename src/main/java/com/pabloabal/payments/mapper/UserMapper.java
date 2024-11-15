package com.pabloabal.payments.mapper;

import com.pabloabal.payments.dto.UserDTO;
import com.pabloabal.payments.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User map(UserDTO dto);

    UserDTO map(User user);
}
