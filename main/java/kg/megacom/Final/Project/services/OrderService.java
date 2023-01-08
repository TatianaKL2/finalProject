package kg.megacom.Final.Project.services;

import kg.megacom.Final.Project.models.dto.OrderDto;
import kg.megacom.Final.Project.models.request.OrderDetailRequest;
import kg.megacom.Final.Project.models.request.OrderRequest;
import kg.megacom.Final.Project.models.response.order.OrderResponses;
import kg.megacom.Final.Project.models.response.saveOrder.OrderResponse;

import java.util.List;

public interface OrderService extends BaseService<OrderDto> {
    OrderDto saveOrder(OrderRequest orderRequest, int lang);
    void saveOrderDetailRequest(List<OrderDetailRequest> orderDetailRequests,Long orderId, int lang, String text);

    OrderResponse orderResponse(OrderRequest orderRequest, int lang);
}