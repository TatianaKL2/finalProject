package kg.megacom.Final.Project.services.impl;

import kg.megacom.Final.Project.exceptions.EntityNotFoundEx;
import kg.megacom.Final.Project.exceptions.SaveTroubleException;
import kg.megacom.Final.Project.mapper.ChannelMapper;
import kg.megacom.Final.Project.microservices.FileServiceFeign;
import kg.megacom.Final.Project.models.dto.ChannelDto;
import kg.megacom.Final.Project.models.response.channel.ChannelResponse;
import kg.megacom.Final.Project.models.response.channel.ChannelResponseC;
import kg.megacom.Final.Project.repositories.ChannelRepository;
import kg.megacom.Final.Project.services.ChannelService;
import kg.megacom.Final.Project.services.DiscountService;
import kg.megacom.Final.Project.utils.ResourceBundle;
import kg.megacom.Final.Project.utils.models.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelRepository rep;
    @Autowired
    private DiscountService discountService;
    @Autowired
    private FileServiceFeign serviceFeign;
    ChannelMapper mapper = ChannelMapper.INSTANCE;

    @Override
    public ChannelDto save(ChannelDto channelDto) {

        return mapper.toDto(rep.save(mapper.toEntity(channelDto)));
    }

    @Override
    public List<ChannelDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public ChannelDto findById(Long id, int lang) {
        Language language = Language.getLang(lang);
        return mapper.toDto(rep.findById(id)
                .orElseThrow(() -> new EntityNotFoundEx(ResourceBundle.periodMessages
                        (language, "accountNotFound"))));
    }


    @Override
    public List<ChannelResponse> channelResponse() {
        return rep.channelResponse();
    }

    @Override
    public List<ChannelResponseC> channelsResponse() {
        List<ChannelResponse> channelResponse = channelResponse();
        List<ChannelResponseC> channelResponseCList = new ArrayList<>();
        for (ChannelResponse item : channelResponse) {
            ChannelResponseC channelResponse1 = new ChannelResponseC();
            channelResponse1.setPhoto(item.getPhoto());
            channelResponse1.setId(item.getId());
            channelResponse1.setName(item.getName());
            channelResponse1.setPrice(item.getPrice());
            channelResponse1.setDiscountMinDaysResponses(discountService.getDiscountChannel(item.getId()));
            channelResponseCList.add(channelResponse1);
        }
        return channelResponseCList;
    }

    @Override
    public ChannelDto saveChannel(String name, int orderNum, MultipartFile photo)  {
        ChannelDto dto = new ChannelDto();
        dto.setName(name);
//        if (dto.getPhoto().isEmpty() || dto.getName().isEmpty())
//            throw new SaveTroubleException("Поля не могут быть пустыми");
//        if (rep.existsByOrderNum(dto.getOrderNum()))
//            throw new SaveTroubleException("Номер заявки существует");
        dto.setOrderNum(orderNum);
        dto.setPhoto(serviceFeign.storeFile(photo).getDownloadUri());
        return save(dto);
    }

}
