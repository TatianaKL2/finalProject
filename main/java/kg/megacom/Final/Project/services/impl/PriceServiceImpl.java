package kg.megacom.Final.Project.services.impl;

import kg.megacom.Final.Project.exceptions.EntityNotFoundEx;
import kg.megacom.Final.Project.mapper.PriceMapper;
import kg.megacom.Final.Project.models.dto.OrderDetailDto;
import kg.megacom.Final.Project.models.dto.PriceDto;
import kg.megacom.Final.Project.models.request.OrderDetailRequest;
import kg.megacom.Final.Project.repositories.PriceRepository;
import kg.megacom.Final.Project.services.ChannelService;
import kg.megacom.Final.Project.services.PriceService;
import kg.megacom.Final.Project.utils.ResourceBundle;
import kg.megacom.Final.Project.utils.models.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRepository rep;
    @Autowired
    private ChannelService channelService;

    PriceMapper mapper = PriceMapper.INSTANCE;
    @Override
    public PriceDto save(PriceDto priceDto) {
        return mapper.toDto(rep.save(mapper.toEntity(priceDto)));
    }

    @Override
    public List<PriceDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public PriceDto findById(Long id, int lang) {
        Language language = Language.getLang(lang);
        return mapper.toDto(rep.findById(id)
                .orElseThrow(() -> new EntityNotFoundEx(ResourceBundle.periodMessages
                        (language, "accountNotFound"))));
    }

    @Override
    public int channelPrice(Long channelId) {
        return rep.channelPrice(channelId);
    }


}
