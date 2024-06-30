package com.exercise.Unit.Test.mapper;

import com.exercise.Unit.Test.dtos.UserDTO;
import com.exercise.Unit.Test.entities.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-01T01:50:10+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity asEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userDTO.getId() );
        userEntity.setFirstName( userDTO.getFirstName() );
        userEntity.setLastname( userDTO.getLastname() );

        return userEntity;
    }

    @Override
    public UserDTO asDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( userEntity.getId() );
        userDTO.setFirstName( userEntity.getFirstName() );
        userDTO.setLastname( userEntity.getLastname() );

        return userDTO;
    }
}
