package kg.megacom.Final.Project.repositories;

import kg.megacom.Final.Project.models.entities.Order;
import kg.megacom.Final.Project.models.response.channel.ChannelResponse;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
