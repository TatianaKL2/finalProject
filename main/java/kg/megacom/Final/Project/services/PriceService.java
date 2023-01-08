package kg.megacom.Final.Project.services;

import kg.megacom.Final.Project.models.dto.PriceDto;
import kg.megacom.Final.Project.models.entities.Price;
import kg.megacom.Final.Project.models.request.OrderDetailRequest;

import java.math.BigDecimal;

public interface PriceService extends BaseService<PriceDto>{
    int channelPrice(Long channelId);
}
