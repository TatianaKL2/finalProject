package kg.megacom.Final.Project.models.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import kg.megacom.Final.Project.models.enums.OrderStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table(name = "tb_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String text;
    String name;
    String phone;
    String email;
    @Column(name = "total_price")
    BigDecimal totalPrice;
    @Column(name = "price_with_discount")
    BigDecimal priceWithDiscount;
    @Column(name = "update_date")
    Date updateDate;
    @Column(name = "add_date")
    Date addDate;
    OrderStatus status;

    @PrePersist
    protected void onCreate() {
        addDate = new Date();
        updateDate = new Date();
        status = OrderStatus.SUSPEND;
    }

    @PreUpdate
    protected void onUpdate(){
        updateDate = new Date();
    }

}
