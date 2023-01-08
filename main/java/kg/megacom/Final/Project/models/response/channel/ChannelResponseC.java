package kg.megacom.Final.Project.models.response.channel;

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
public class ChannelResponseC {
    Long id;
    String name;
    String photo;
    BigDecimal price;
    @JsonProperty(value = "discount_min_days_responses")
    List<DiscountMinDaysResponse> discountMinDaysResponses;
}
