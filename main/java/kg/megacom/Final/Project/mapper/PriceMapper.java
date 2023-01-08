package kg.megacom.Final.Project.mapper;

import kg.megacom.Final.Project.models.dto.PriceDto;
import kg.megacom.Final.Project.models.entities.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper extends BaseMapper<Price, PriceDto>{
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);
}
