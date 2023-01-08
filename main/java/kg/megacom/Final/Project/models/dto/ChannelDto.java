package kg.megacom.Final.Project.models.dto;

import kg.megacom.Final.Project.microservices.FileServiceFeign;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;
import java.nio.file.LinkOption;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter

public class ChannelDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String photo;
    Boolean active;
    int orderNum;
}
