package kg.megacom.Final.Project.services.impl;

import kg.megacom.Final.Project.exceptions.EntityNotFoundEx;
import kg.megacom.Final.Project.mapper.DaysMapper;
import kg.megacom.Final.Project.models.dto.DaysDto;
import kg.megacom.Final.Project.repositories.DaysRepository;
import kg.megacom.Final.Project.services.DaysService;
import kg.megacom.Final.Project.utils.ResourceBundle;
import kg.megacom.Final.Project.utils.models.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DaysServiceImpl implements DaysService {
    @Autowired
    private DaysRepository rep;

    DaysMapper mapper = DaysMapper.INSTANCE;

    @Override
    public DaysDto save(DaysDto daysDto) {
        return mapper.toDto(rep.save(mapper.toEntity(daysDto)));
    }

    @Override
    public List<DaysDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public DaysDto findById(Long id, int lang) {
        Language language = Language.getLang(lang);
        return mapper.toDto(rep.findById(id)
                .orElseThrow(() -> new EntityNotFoundEx(ResourceBundle.periodMessages
                        (language, "accountNotFound"))));
    }

}