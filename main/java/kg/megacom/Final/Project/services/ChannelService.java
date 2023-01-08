package kg.megacom.Final.Project.services;

import kg.megacom.Final.Project.models.dto.ChannelDto;

import kg.megacom.Final.Project.models.response.channel.ChannelResponse;
import kg.megacom.Final.Project.models.response.channel.ChannelResponseC;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ChannelService extends BaseService<ChannelDto>{
    List<ChannelResponse> channelResponse();
    List<ChannelResponseC> channelsResponse();
    ChannelDto saveChannel(String name, int orderNum, MultipartFile photo);

}

