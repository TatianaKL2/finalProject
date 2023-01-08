package kg.megacom.Final.Project.models.response.order;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetails {
    Long channelId;
    String channelName;
    BigDecimal totalPrice;
    BigDecimal priceWithDiscount;
    double percent;
    List<Date> days;

}
