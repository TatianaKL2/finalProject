package kg.megacom.Final.Project.mapper;

import kg.megacom.Final.Project.models.dto.DaysDto;
import kg.megacom.Final.Project.models.entities.Days;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DaysMapper extends BaseMapper<Days, DaysDto>{
    DaysMapper INSTANCE = Mappers.getMapper(DaysMapper.class);
}
