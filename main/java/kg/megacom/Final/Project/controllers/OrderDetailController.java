package kg.megacom.Final.Project.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.Final.Project.configs.Swagger2Config;
import kg.megacom.Final.Project.models.dto.OrderDetailDto;
import kg.megacom.Final.Project.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order/detail")
@Api(tags = Swagger2Config.OrderDetail)
public class OrderDetailController {
    @Autowired
    OrderDetailService service;

    @PostMapping("/save")
    @ApiOperation("Сохранить/обновить")
    OrderDetailDto save(OrderDetailDto orderDetailDto){
        return service.save(orderDetailDto);
    }

    @GetMapping("/get")
    @ApiOperation("Список")
    List<OrderDetailDto> findAll(){
            return service.findAll();
    }

    @GetMapping("/get/{id}")
    @ApiOperation("Поиск по ID")
    OrderDetailDto findById(@PathVariable Long id, int lang){
            return service.findById(id, lang);
    }

}
