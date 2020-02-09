package cn.ChaosWong.flash.service.system;

import cn.ChaosWong.flash.cache.TokenCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {
    @Autowired
    private TokenCache tokenCache;
    @Autowired
    private UserService userService;



    public void logout(String token) {
        tokenCache.remove(token);
    }

}
