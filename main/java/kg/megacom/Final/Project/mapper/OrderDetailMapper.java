package kg.megacom.Final.Project.mapper;

import kg.megacom.Final.Project.models.dto.OrderDetailDto;
import kg.megacom.Final.Project.models.entities.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail, OrderDetailDto>{
    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);
}
