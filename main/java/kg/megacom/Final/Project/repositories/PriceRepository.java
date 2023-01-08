package kg.megacom.Final.Project.repositories;

import kg.megacom.Final.Project.models.entities.Price;
import kg.megacom.Final.Project.models.request.OrderDetailRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query(value = "select price from tb_prices where channel_id=?1", nativeQuery = true)
    int channelPrice(Long channelId);
}
