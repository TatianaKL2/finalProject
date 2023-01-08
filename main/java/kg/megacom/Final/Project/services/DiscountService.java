package kg.megacom.Final.Project.services;

import kg.megacom.Final.Project.models.dto.DiscountDto;
import kg.megacom.Final.Project.models.response.channel.DiscountMinDaysResponse;

import java.util.List;

public interface DiscountService extends BaseService<DiscountDto> {
    List<DiscountMinDaysResponse> getDiscountChannel(Long channelId);


}
