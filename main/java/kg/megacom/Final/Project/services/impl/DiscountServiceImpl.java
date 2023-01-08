package kg.megacom.Final.Project.services.impl;

import kg.megacom.Final.Project.exceptions.EntityNotFoundEx;
import kg.megacom.Final.Project.mapper.DiscountMapper;
import kg.megacom.Final.Project.models.dto.DiscountDto;
import kg.megacom.Final.Project.models.response.channel.DiscountMinDaysResponse;
import kg.megacom.Final.Project.repositories.DiscountRepository;
import kg.megacom.Final.Project.services.DiscountService;
import kg.megacom.Final.Project.utils.ResourceBundle;
import kg.megacom.Final.Project.utils.models.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    private DiscountRepository rep;

    DiscountMapper mapper = DiscountMapper.INSTANCE;
    @Override
    public DiscountDto save(DiscountDto discountDto) {
        return mapper.toDto(rep.save(mapper.toEntity(discountDto)));
    }

    @Override
    public List<DiscountDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public DiscountDto findById(Long id, int lang) {
        Language language = Language.getLang(lang);
        return mapper.toDto(rep.findById(id)
                .orElseThrow(()-> new EntityNotFoundEx(ResourceBundle.periodMessages
                        (language, "accountNotFound"))));
    }

    @Override
    public List<DiscountMinDaysResponse> getDiscountChannel(Long channelId) {
        return rep.getDiscountChannel(channelId);
    }


}
