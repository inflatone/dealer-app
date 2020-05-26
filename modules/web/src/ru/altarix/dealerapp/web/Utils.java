package ru.altarix.dealerapp.web;

import com.haulmont.cuba.core.entity.BaseUuidEntity;
import com.haulmont.cuba.core.sys.AppContext;
import com.haulmont.cuba.core.sys.SecurityContext;
import com.haulmont.cuba.security.global.UserSession;
import org.springframework.stereotype.Component;
import ru.altarix.dealerapp.entity.user.Manager;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class Utils {
    public Manager getAuthUser() {
        SecurityContext securityContext = AppContext.getSecurityContext();
        UserSession userSession = securityContext == null ? null : securityContext.getSession();
        return userSession == null ? null : (Manager) userSession.getUser();
    }

    public List<UUID> retrieveUuids(Collection<? extends BaseUuidEntity> makers) {
        return makers.stream()
                .map(BaseUuidEntity::getUuid)
                .collect(Collectors.toList());
    }
}
