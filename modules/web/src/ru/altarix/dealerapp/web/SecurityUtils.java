package ru.altarix.dealerapp.web;

import com.haulmont.cuba.core.sys.AppContext;
import com.haulmont.cuba.core.sys.SecurityContext;
import com.haulmont.cuba.security.global.UserSession;
import org.springframework.stereotype.Component;
import ru.altarix.dealerapp.entity.user.Manager;

@Component
public class SecurityUtils {
    public Manager getAuthUser() {
        SecurityContext securityContext = AppContext.getSecurityContext();
        UserSession userSession = securityContext == null ? null : securityContext.getSession();
        return userSession == null ? null : (Manager) userSession.getUser();
    }
}
