package kg.megacom.Final.Project.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import kg.megacom.Final.Project.models.enums.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    Long id;
    String text;
    String name;
    String phone;
    String email;
    BigDecimal totalPrice;
    BigDecimal priceWithDiscount;
    Date updateDate;
    Date addDate;
    OrderStatus status;
}
