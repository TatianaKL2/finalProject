package kg.megacom.Final.Project.models.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.sql.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class DaysDto {
    Long id;
    Date days;
    OrderDetailDto orderDetailId;




}
