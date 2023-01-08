package kg.megacom.Final.Project.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table(name = "tb_days")
public class Days {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date days;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_detail_id")
    OrderDetail orderDetailId;
}
