package kg.megacom.Final.Project.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.Final.Project.configs.Swagger2Config;
import kg.megacom.Final.Project.models.dto.DaysDto;
import kg.megacom.Final.Project.services.DaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/days")
@Api(tags = Swagger2Config.Days)
public class DaysController {
    @Autowired
    DaysService service;

    @PostMapping("/save")
    @ApiOperation("Сохранение/обновление")
    DaysDto save (@RequestBody DaysDto days){
            return service.save(days);
    }

    @GetMapping("/get")
    @ApiOperation("Список дней")
    List<DaysDto> findAll(){
            return service.findAll();
    }

    @GetMapping("/get/{id}")
    @ApiOperation("Поиск по ID")
    DaysDto findById(@PathVariable Long id, int lang) {
        return service.findById(id, lang);
    }
}
