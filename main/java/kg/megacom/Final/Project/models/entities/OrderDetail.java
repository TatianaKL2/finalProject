package kg.megacom.Final.Project.models.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table(name = "tb_order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "total_price")
    BigDecimal totalPrice;
    @Column(name = "price_with_discount")
    BigDecimal priceWithDiscount;
    double percent;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    Channel channelId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    Order orderId;


}
