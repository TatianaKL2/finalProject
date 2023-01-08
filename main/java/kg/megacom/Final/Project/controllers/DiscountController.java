package kg.megacom.Final.Project.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.Final.Project.configs.Swagger2Config;
import kg.megacom.Final.Project.models.dto.DiscountDto;
import kg.megacom.Final.Project.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/disc")
@Api(tags = Swagger2Config.Discount)
public class DiscountController {
    @Autowired
    DiscountService service;

    @PostMapping("/save")
    @ApiOperation("Сохранение/обновление")
    DiscountDto save (@RequestBody DiscountDto discount){
            return service.save(discount);
    }

    @GetMapping("/get")
    @ApiOperation("Список скидок")
    List<DiscountDto> findAll(){
            return service.findAll();
    }

    @GetMapping("/get/{id}")
    @ApiOperation("Поиск по ID")
    DiscountDto findById(@PathVariable Long id, int lang){
            return service.findById(id, lang);
    }
}
