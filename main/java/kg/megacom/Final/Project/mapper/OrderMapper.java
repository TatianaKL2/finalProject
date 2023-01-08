package kg.megacom.Final.Project.mapper;

import kg.megacom.Final.Project.models.dto.OrderDto;
import kg.megacom.Final.Project.models.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper extends BaseMapper<Order, OrderDto>{
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
}
