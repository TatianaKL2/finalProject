package kg.megacom.Final.Project.models.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "tb_discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    BigDecimal percent;
    @Column(name = "start_date")
    Date startDate;
    @Column(name = "end_date")
    Date endDate;
    @Column(name = "min_days")
    int minDays;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    Channel channelId;

}
