package kg.megacom.Final.Project.models.response.saveOrder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailResponse {
    @JsonProperty(value = "channel_id")
    Long channelId;
    @JsonProperty(value = "total_price")
    BigDecimal totalPrice;
    @JsonProperty(value = "price_with_discount")
    BigDecimal priceWithDiscount;
    double percent;
    int days;
}
