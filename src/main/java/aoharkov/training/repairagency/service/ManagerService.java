package aoharkov.training.repairagency.service;

import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.Request;

public interface ManagerService {

    Page<Request> findAllRequests(int page, int itemsPerPage);

    Page<Order> findAllOrders(int page, int itemsPerPage);

    Page<Refusal> findAllRefusals(int page, int itemsPerPage);

    boolean acceptRequest(Order order);

    boolean declineRequest(Refusal refusal);

    Page<Feedback> findAllFeedback(int page, int itemsPerPage);
}
