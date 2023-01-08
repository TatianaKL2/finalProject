package kg.megacom.Final.Project.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.Final.Project.configs.Swagger2Config;
import kg.megacom.Final.Project.models.dto.PriceDto;
import kg.megacom.Final.Project.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/price")
@Api(tags = Swagger2Config.Price)
public class PriceController {
    @Autowired
    PriceService service;

    @PostMapping("/save")
    @ApiOperation("Сохранение/обновление")
    PriceDto save(@RequestBody PriceDto price){
            return service.save(price);
    }

    @GetMapping("/get")
    @ApiOperation("Список цен")
    List<PriceDto> findAll(){
            return service.findAll();
    }

    @GetMapping("/get/{id}")
    @ApiOperation("Поиск по ID")
    PriceDto findById(@PathVariable Long id, int lang){
            return service.findById(id, lang);
    }
}
