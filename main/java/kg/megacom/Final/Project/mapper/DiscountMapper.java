package kg.megacom.Final.Project.mapper;

import kg.megacom.Final.Project.models.dto.DiscountDto;
import kg.megacom.Final.Project.models.entities.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiscountMapper extends BaseMapper<Discount, DiscountDto>{
    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);
}
