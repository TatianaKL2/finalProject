package kg.megacom.Final.Project.services.impl;

import kg.megacom.Final.Project.exceptions.EntityNotFoundEx;
import kg.megacom.Final.Project.mapper.OrderMapper;
import kg.megacom.Final.Project.models.dto.DaysDto;
import kg.megacom.Final.Project.models.dto.OrderDetailDto;
import kg.megacom.Final.Project.models.dto.OrderDto;
import kg.megacom.Final.Project.models.request.OrderDetailRequest;
import kg.megacom.Final.Project.models.request.OrderRequest;
import kg.megacom.Final.Project.models.response.order.OrderResponses;
import kg.megacom.Final.Project.models.response.saveOrder.OrderDetailResponse;
import kg.megacom.Final.Project.models.response.saveOrder.OrderResponse;
import kg.megacom.Final.Project.repositories.OrderRepository;
import kg.megacom.Final.Project.services.ChannelService;
import kg.megacom.Final.Project.services.DaysService;
import kg.megacom.Final.Project.services.OrderDetailService;
import kg.megacom.Final.Project.services.OrderService;
import kg.megacom.Final.Project.utils.ResourceBundle;
import kg.megacom.Final.Project.utils.models.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository rep;
    @Autowired
    private OrderDetailService detailService;
    @Autowired
    private ChannelService channelService;
    @Autowired
    private DaysService daysService;

    OrderMapper mapper = OrderMapper.INSTANCE;

    @Override
    public OrderDto save(OrderDto orderDto) {
        return mapper.toDto(rep.save(mapper.toEntity(orderDto)));
    }

    @Override
    public List<OrderDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }

    @Override
    public OrderDto findById(Long id, int lang) {
        Language language = Language.getLang(lang);
        return mapper.toDto(rep.findById(id)
                .orElseThrow(() -> new EntityNotFoundEx(ResourceBundle.periodMessages
                        (language, "accountNotFound"))));
    }


    @Override
    public OrderDto saveOrder(OrderRequest orderRequest, int lang) {
        OrderDto dto = new OrderDto();
        OrderResponse orderResponse = orderResponse(orderRequest, lang);
        dto.setText(orderRequest.getText());
        dto.setName(orderRequest.getName());
        dto.setPhone(orderRequest.getPhone());
        dto.setEmail(orderRequest.getEmail());
        dto.setTotalPrice(orderResponse.getTotalPrice());
        dto.setPriceWithDiscount(orderResponse.getPriceWithDiscount());
        OrderDto saveDto = save(dto);
        saveOrderDetailRequest(orderRequest.getOrderDetailRequests(), saveDto.getId(), lang, saveDto.getText());

        return saveDto;
    }

    @Override
    public void saveOrderDetailRequest(List<OrderDetailRequest> orderDetailRequests, Long orderId, int lang, String text) {
        List<OrderDetailResponse> detailResponseList = detailService.orderDetail(orderDetailRequests, lang, text);
        Map<Long, BigDecimal> priceMap = new HashMap<>();
        Map<Long, BigDecimal> discountMap = new HashMap<>();
        Map<Long, Double> percent = new HashMap<>();

        for (var i : detailResponseList) {
            priceMap.put(i.getChannelId(), i.getTotalPrice());
            discountMap.put(i.getChannelId(), i.getPriceWithDiscount());
            percent.put(i.getChannelId(), i.getPercent());
        }

        for (OrderDetailRequest item : orderDetailRequests) {
            OrderDetailDto dto = new OrderDetailDto();
            dto.setTotalPrice(priceMap.get(item.getChannelId()));
            dto.setTotalPrice(priceMap.get(item.getChannelId()));
            dto.setPriceWithDiscount(discountMap.get(item.getChannelId()));
            dto.setPercent(percent.get(item.getChannelId()));
            dto.setChannelId(channelService.findById(item.getChannelId(), lang));
            dto.setOrderId(OrderDto.builder()
                    .id(orderId)
                    .build()
            );

            for (Date days : item.getDays()) {
                DaysDto daysDto = new DaysDto();
                daysDto.setDays(days);
                daysDto.setOrderDetailId(dto);
                daysService.save(daysDto);
            }
            detailService.save(dto);
        }

    }

    @Override
    public OrderResponse orderResponse(OrderRequest orderRequest, int lang) {

        var list = detailService.orderDetail(orderRequest.getOrderDetailRequests(), lang, orderRequest.getText());
        kg.megacom.Final.Project.models.response.saveOrder.OrderResponse orderResponse = new kg.megacom.Final.Project.models.response.saveOrder.OrderResponse();
        List<BigDecimal> totalPrice = new ArrayList<>();
        for (OrderDetailResponse item : list) {
            totalPrice.add(item.getTotalPrice());
        }
        BigDecimal tPrice = totalPrice.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        orderResponse.setTotalPrice(tPrice);

        List<BigDecimal> discount = new ArrayList<>();
        for (OrderDetailResponse item : list) {
            discount.add(item.getPriceWithDiscount());
        }
        BigDecimal dPrice = discount.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        orderResponse.setPriceWithDiscount(dPrice);

        return orderResponse;
    }

}
