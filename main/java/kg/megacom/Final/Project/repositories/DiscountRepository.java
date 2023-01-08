package kg.megacom.Final.Project.repositories;

import kg.megacom.Final.Project.models.entities.Discount;
import kg.megacom.Final.Project.models.response.channel.DiscountMinDaysResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    @Query(value = "select d.min_days as minDays, d.percent from tb_discounts d where d.channel_id=?1", nativeQuery = true)
    List<DiscountMinDaysResponse> getDiscountChannel(Long channelId);

}
