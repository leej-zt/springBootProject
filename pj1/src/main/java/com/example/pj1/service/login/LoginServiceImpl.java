package com.example.pj1.service.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.example.pj1.form.login.LoginForm;

/** ログインサービス. */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public final boolean login(final LoginForm form)
            throws Exception {

        try {
            String userId = form.getUserId();
            String password = form.getPassword();

            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token =
                    new UsernamePasswordToken(userId, password);
            currentUser.login(token);
        } catch (AuthenticationException ae) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return true;

    }

}
