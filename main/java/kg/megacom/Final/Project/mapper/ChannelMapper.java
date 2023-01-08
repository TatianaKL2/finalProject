package kg.megacom.Final.Project.mapper;

import kg.megacom.Final.Project.models.dto.ChannelDto;
import kg.megacom.Final.Project.models.entities.Channel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChannelMapper extends BaseMapper<Channel, ChannelDto>{
    ChannelMapper INSTANCE = Mappers.getMapper(ChannelMapper.class);
}
