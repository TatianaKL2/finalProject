package kg.megacom.Final.Project.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.Final.Project.configs.Swagger2Config;
import kg.megacom.Final.Project.models.dto.OrderDto;
import kg.megacom.Final.Project.models.request.OrderRequest;
import kg.megacom.Final.Project.models.response.order.OrderResponses;
import kg.megacom.Final.Project.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@Api(tags = Swagger2Config.Order)
public class OrderController {
    @Autowired
    OrderService service;

    @GetMapping("/get")
    @ApiOperation("Список заявок")
    List<OrderDto> findAll(){
            return service.findAll();
    }

    @GetMapping("/get/{id}")
    @ApiOperation("Поиск по ID")
    OrderDto findById(@PathVariable Long id, int lang) {
            return service.findById(id, lang);
    }


    @PostMapping("/save/request")
    @ApiOperation("Сохранить заявку")
    OrderDto saveRequest(@ModelAttribute OrderRequest orderRequest, int lang){
            return service.saveOrder(orderRequest, lang);

    }
//    @GetMapping("/get")
//    @ApiOperation("Список заявок")
//    OrderResponses getOrderResponse(){
//        return service.orderResponse();
//    }


}
