package cn.thefronts.oauth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;

/**
 * @author thefronts
 * @date 2023/2/22
 */
public interface ZltUserDetailsService extends UserDetailsService {
    /**
     * 判断实现类是否属于该类型
     * @param accountType 账号类型
     */
    boolean supports(String accountType);

    /**
     * 根据电话号码查询用户
     *
     * @param mobile
     * @return
     */
    UserDetails loadUserByMobile(String mobile);

    /**
     * 根据用户id/openId查询用户
     * @param userId 用户id/openId
     */
    SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException;
}
