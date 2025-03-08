package dev.mivas.BarberSystem.Mapper;

import dev.mivas.BarberSystem.HaircutStyles.entity.HaircutModel;
import dev.mivas.BarberSystem.HaircutStyles.request.HaircutRequest;
import dev.mivas.BarberSystem.HaircutStyles.response.HaircutResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HaircutMapper {

    public static HaircutModel toHaircut(HaircutRequest request){
        return HaircutModel
                .builder()
                .name( request.name())
                .price(request.price())
                .status(request.status())
                .build();
    }

    public static HaircutResponse toHaircutResponse(HaircutModel haircut){
        return HaircutResponse
                .builder()
                .id(haircut.getId())
                .name(haircut.getName())
                .price(haircut.getPrice())
                .status(haircut.getStatus())
                .build();
    }
}
