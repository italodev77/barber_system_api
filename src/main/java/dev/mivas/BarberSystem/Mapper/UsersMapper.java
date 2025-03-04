package dev.mivas.BarberSystem.Mapper;

import dev.mivas.BarberSystem.User.entity.UsersModel;
import dev.mivas.BarberSystem.User.request.UsersRequest;
import dev.mivas.BarberSystem.User.response.UsersResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsersMapper {
    public static UsersModel toUsers(UsersRequest request){
        return UsersModel
                .builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UsersResponse toUsersResponse(UsersModel user){
        return UsersResponse
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
