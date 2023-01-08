package kg.megacom.Final.Project.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter

public class OrderDetailDto {

    Long id;
    ChannelDto channelId;
    BigDecimal totalPrice;
    BigDecimal priceWithDiscount;
    double percent;
    OrderDto orderId;


}
