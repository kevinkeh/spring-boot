package com.kevin.shiro;

import com.kevin.model.db2.Permission;
import com.kevin.model.db2.User;
import com.kevin.user.PermissionService;
import com.kevin.user.UserRoleService;
import com.kevin.user.UserService;
import com.kevin.util.Encodes;
import com.google.common.base.Objects;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;


/**
 * shiro自定义realm
 * Created by zmxie on 2017/7/27.
 */
@Component(value = "authRealm")
public class AuthRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(AuthRealm.class);
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = String.valueOf(principals.getPrimaryPrincipal());
        User user = userService.getUser(username);
        //获取用户的角色
        List<String> roles = userRoleService.findRoles(user.getId());
        //把principals放session中 key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getId()), SecurityUtils.getSubject().getPrincipals());
        //赋予角色
        for (String role : roles) {
            authorizationInfo.addRole(role);
        }
        //赋予权限
        for (Permission permission : permissionService.getPermissions(user.getId())) {
            if (StringUtils.isNotBlank(permission.getPermCode()))
                authorizationInfo.addStringPermission(permission.getPermCode());
        }

        //设置登录次数、时间
        userService.updateUserLogin(user);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        // 调用数据库
        final User authentication = userService.getUser(username);
        byte[] salt = Encodes.decodeHex(authentication.getSalt());
        ShiroUser shiroUser = new ShiroUser(authentication.getId(), authentication.getLoginName(), authentication.getName());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(shiroUser, authentication.getPassword(), ByteSource.Util.bytes(salt), getName());
        return authenticationInfo;

    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
     */
    public static class ShiroUser implements Serializable {
        private static final long serialVersionUID = -1373760761780840081L;
        public Integer id;
        public String loginName;
        public String name;

        public ShiroUser(Integer id, String loginName, String name) {
            this.id = id;
            this.loginName = loginName;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        /**
         * 本函数输出将作为默认的<shiro:principal/>输出.
         */
        @Override
        public String toString() {
            return loginName;
        }

        /**
         * 重载hashCode,只计算loginName;
         */
        @Override
        public int hashCode() {
            return Objects.hashCode(loginName);
        }

        /**
         * 重载equals,只计算loginName;
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            ShiroUser other = (ShiroUser) obj;
            if (loginName == null) {
                if (other.loginName != null) {
                    return false;
                }
            } else if (!loginName.equals(other.loginName)) {
                return false;
            }
            return true;
        }
    }
}
