package com.jluzh.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.jluzh.constant.MessageConstant;
import com.jluzh.domain.SecurityUser;
import com.jluzh.domain.UserDto;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户管理业务类
 * 用于加载用户信息
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    private List<UserDto> userList;
    @Resource
    private PasswordEncoder passwordEncoder;

    /**
     * 假装是在数据库获取加载到DTO对象
     */
    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        userList = new ArrayList<>();
        userList.add(new UserDto(1L,"macro", password,1, "client-app", CollUtil.toList("ADMIN")));
        userList.add(new UserDto(2L,"andy", password,1, "client-app", CollUtil.toList("TEST")));
    }

    /**
     *
     * @param username 来自外部输入的用户名
     * @return 封装后的用户信息
     * @throws UsernameNotFoundException 用户名未找到异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO 从数据库的用户信息和外部输入的用户信息比对
        List<UserDto> findUserList = userList.stream().filter(item -> item.getUsername().equals(username)).collect(Collectors.toList());
        // 未找到用户信息抛出异常
        if (!CollUtil.isEmpty(findUserList)) {
            throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        //
        SecurityUser securityUser = new SecurityUser(userList.get(0));
        if (!securityUser.isEnabled()) {
            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
        }
        return securityUser;
    }

}
