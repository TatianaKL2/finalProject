package kg.megacom.Final.Project.models.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter

public class PriceDto {

    Long id;
    Date startDate;
    Date endDate;
    int price;
    ChannelDto channelId;
}
