package cn.itweet.common.config;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.user.service.permission.PermissionService;
import cn.itweet.modules.admin.user.service.permission.PermissionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by whoami on 11/05/2017.
 */
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartup.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        PermissionService permissionService = event.getApplicationContext().getBean(PermissionService.class);
        try {
            permissionService.refreshPermission();
        } catch (SystemException e) {
            e.printStackTrace();
            LOGGER.error("初始化权限出错!");
        }
    }

}
