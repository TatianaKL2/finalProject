package kg.megacom.Final.Project.models.response.saveOrder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {

    @JsonProperty(value = "total_price")
    BigDecimal totalPrice;
    @JsonProperty(value = "price_with_discount")
    BigDecimal priceWithDiscount;
    @JsonProperty(value = "order_detail_response")
    List<OrderDetailResponse> orderDetailResponse;


}
