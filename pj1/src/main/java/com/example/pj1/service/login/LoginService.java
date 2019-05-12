package com.example.pj1.service.login;

import com.example.pj1.form.login.LoginForm;

/** ログインサービス. */
public interface LoginService {


    /**
     * ログイン処理.
     * @param form LoginForm.
     * @return boolean 処理結果.
     * @throws Exception 例外.
     * */
    boolean login(LoginForm form) throws Exception;
}
