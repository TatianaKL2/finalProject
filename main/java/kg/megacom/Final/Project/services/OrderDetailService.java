package kg.megacom.Final.Project.services;

import kg.megacom.Final.Project.models.dto.OrderDetailDto;
import kg.megacom.Final.Project.models.request.OrderDetailRequest;
import kg.megacom.Final.Project.models.response.saveOrder.OrderDetailResponse;

import java.util.List;

public interface OrderDetailService extends BaseService<OrderDetailDto>{

    List<OrderDetailResponse> orderDetail(List<OrderDetailRequest> orderDetailRequest, int lang, String text);


}
