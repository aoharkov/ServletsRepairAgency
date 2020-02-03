package aoharkov.education.repairagency.command.manager;

import aoharkov.education.repairagency.command.Command;
import aoharkov.education.repairagency.entity.Role;
import aoharkov.education.repairagency.entity.User;
import aoharkov.education.repairagency.service.ManagerService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class ListAllRequestsCommand implements Command {
    private final ManagerService userService;

    public ListAllRequestsCommand(ManagerService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        final User user = (User) request.getSession().getAttribute("user");
        final Role role = user.getRole();
        if (role != Role.MANAGER) {
            return ERROR_PAGE;
        }
        //todo
        return "view/manager/requests.jsp";
    }
}
