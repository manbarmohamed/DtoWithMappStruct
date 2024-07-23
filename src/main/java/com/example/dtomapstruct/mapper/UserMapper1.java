//package com.example.dtomapstruct.mapper;
//
//import com.example.dtomapstruct.dto.UserDto;
//import com.example.dtomapstruct.model.User;
//import org.mapstruct.*;
//
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
//public interface UserMapper1 {
//    User toEntity(UserDto userDto);
//
//    UserDto toDTO(User user);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    User partialUpdate(UserDto userDto, @MappingTarget User user);
//}