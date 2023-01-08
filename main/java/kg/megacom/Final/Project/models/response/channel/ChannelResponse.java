package kg.megacom.Final.Project.models.response.channel;

import java.math.BigDecimal;

public interface ChannelResponse {
    Long getId();
    String getName();
    String getPhoto();
    BigDecimal getPrice();

}
