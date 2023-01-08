package kg.megacom.Final.Project.models.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class OrderRequest {
   String text;
   String name;
   String phone;
   String email;
   @OneToMany(cascade = CascadeType.ALL)
   @JsonProperty(value = "order_detail_requests")
   List<OrderDetailRequest> orderDetailRequests;

}
