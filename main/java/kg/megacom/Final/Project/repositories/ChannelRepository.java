package kg.megacom.Final.Project.repositories;

import kg.megacom.Final.Project.models.entities.Channel;
import kg.megacom.Final.Project.models.response.channel.ChannelResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
    @Query(value = "Select c.id, c.name, c.photo, p.price from tb_channels c join tb_prices p on c.id = p.channel_id order by c.order_num asc limit 3", nativeQuery = true)
    List<ChannelResponse> channelResponse();

//    @Query(value = "select (count(c)>0) from tb_channels c where c.order_num = ?1", nativeQuery = true)
//    boolean existsByOrderNum(int orderNum);

}
