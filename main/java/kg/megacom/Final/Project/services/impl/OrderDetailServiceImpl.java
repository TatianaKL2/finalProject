package kg.megacom.Final.Project.services.impl;

import kg.megacom.Final.Project.exceptions.EntityNotFoundEx;
import kg.megacom.Final.Project.mapper.OrderDetailMapper;
import kg.megacom.Final.Project.models.dto.*;
import kg.megacom.Final.Project.models.request.OrderDetailRequest;
import kg.megacom.Final.Project.models.response.saveOrder.OrderDetailResponse;
import kg.megacom.Final.Project.repositories.OrderDetailRepository;
import kg.megacom.Final.Project.services.*;
import kg.megacom.Final.Project.utils.ResourceBundle;
import kg.megacom.Final.Project.utils.models.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository rep;
    @Autowired
    private PriceService priceService;
    @Autowired
    private DiscountService discountService;
    @Autowired
    private ChannelService channelService;


    OrderDetailMapper mapper = OrderDetailMapper.INSTANCE;


    @Override
    public OrderDetailDto save(OrderDetailDto orderDetailDto) {
        return mapper.toDto(rep.save(mapper.toEntity(orderDetailDto)));
    }

    @Override
    public List<OrderDetailDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public OrderDetailDto findById(Long id, int lang) {
        Language language = Language.getLang(lang);
        return mapper.toDto(rep.findById(id)
                .orElseThrow(() -> new EntityNotFoundEx(ResourceBundle.periodMessages
                        (language, "accountNotFound"))));
    }

    @Override
    public List<OrderDetailResponse> orderDetail(List<OrderDetailRequest> orderDetailRequest, int lang, String text) {

        List<OrderDetailResponse> orderDetailResponseList = new ArrayList<>();

        for (OrderDetailRequest item : orderDetailRequest) {
            OrderDetailResponse response = new OrderDetailResponse();
            response.setChannelId(channelService.findById(item.getChannelId(), lang).getId());
            response.setDays(item.getDays().size());

            text = text.replaceAll("\\s", "");
            int result = 0;
            for (int i = 0; i < text.length(); i++) {
                result++;
            }

            PriceDto dto = new PriceDto();
            dto.setPrice(priceService.channelPrice(response.getChannelId()));

            BigDecimal result1 = BigDecimal.valueOf(result);
            BigDecimal days = BigDecimal.valueOf(response.getDays());
            BigDecimal price = result1.multiply(BigDecimal.valueOf(dto.getPrice()).multiply(days));
            response.setTotalPrice(price);

            BigDecimal hundred = new BigDecimal(100);
            BigDecimal five = new BigDecimal(5);
            BigDecimal ten = new BigDecimal(10);
            BigDecimal fifteen = new BigDecimal(15);
            if (!discountService.getDiscountChannel(response.getChannelId()).isEmpty()) {
                if (response.getDays() >= 3 && response.getDays() <= 5) {
                    response.setPriceWithDiscount(response.getTotalPrice().subtract(response.getTotalPrice().multiply(five).divide(hundred)));
                    response.setPercent(5);
                    if (response.getDays() > 5 && response.getDays() < 9) {
                        response.setPriceWithDiscount(response.getTotalPrice().subtract(response.getTotalPrice().multiply(ten).divide(hundred)));
                        response.setPercent(10);
                        if (response.getDays() > 10) {
                            response.setPriceWithDiscount(response.getTotalPrice().subtract(response.getTotalPrice().multiply(fifteen).divide(hundred)));
                            response.setPercent(10);
                        }
                    }
                } else {
                    response.setPriceWithDiscount(price);
                    response.setPercent(0);
                }
            } else {
                response.setPriceWithDiscount(price);
                response.setPercent(0);
            }
            orderDetailResponseList.add(response);
            }

        return orderDetailResponseList;
    }

}


