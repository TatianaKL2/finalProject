package kg.megacom.Final.Project.models.response.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import kg.megacom.Final.Project.models.request.OrderDetailRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponses {
    String text;
    String name;
    String phone;
    String email;
    @JsonProperty(value = "total_price")
    BigDecimal totalPrice;
    @JsonProperty(value = "price_with_discount")
    BigDecimal priceWithDiscount;
    @JsonProperty(value = "order_detail_requests")
    List<OrderDetailRequest> orderDetailRequests;
}
