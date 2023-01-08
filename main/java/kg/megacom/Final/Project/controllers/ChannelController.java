package kg.megacom.Final.Project.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.Final.Project.configs.Swagger2Config;
import kg.megacom.Final.Project.models.dto.ChannelDto;
import kg.megacom.Final.Project.models.response.channel.ChannelResponseC;
import kg.megacom.Final.Project.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ch")
@Api(tags = Swagger2Config.Channel)
public class ChannelController{
    @Autowired
    ChannelService service;

    @GetMapping("/get/{id}")
    @ApiOperation("Поиск по ID")
    ChannelDto findById(@PathVariable Long id, int lang){
            return service.findById(id, lang);
    }

    @GetMapping("/get/all/response")
    @ApiOperation("Вывод каналов")
    List<ChannelResponseC> channelsResponse(){
            return service.channelsResponse();
    }

    @PostMapping("/save/channel")
    @ApiOperation("Сохранение/обновление канала")
    ChannelDto saveChannel(@RequestParam String name,
                                  @RequestParam int orderNum,
                                  @RequestParam MultipartFile photo){
            return service.saveChannel(name, orderNum,photo);
    }

}
