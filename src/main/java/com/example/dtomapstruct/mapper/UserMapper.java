package com.example.dtomapstruct.mapper;

import com.example.dtomapstruct.dto.UserDto;
import com.example.dtomapstruct.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {


    UserDto toDTO(User user);

    User toEntity(UserDto userDTO);

    List<UserDto> toDTO(List<User> userList);

    List<User> toEntity(List<UserDto> userDTOList);
}
