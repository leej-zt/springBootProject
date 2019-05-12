package com.example.pj1.web.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.pj1.form.login.LoginForm;
import com.example.pj1.service.login.LoginService;

/** ログインコントローラー. */
@Controller
@RequestMapping("/login")
public class LoginController {

    /** ログインサービス. */
    @Autowired
    private LoginService loginService;

    /** 画面表示用タイトル. */
    @Value("${title.login}")
    private String title;

    /**
     * GETリクエスト(初期表示用).
     *  @param form LoginForm.
     *  @param model Model.
     *  @return String 画面名.
     *  @throws Exception 例外.
     * */
    @RequestMapping(method = RequestMethod.GET)
    public String testController(final LoginForm form,
            final Model model) throws Exception {

        model.addAttribute("title", title);

        return "Login";
    }

    /**
     * POSTリクエスト(ログイン処理用).
     *  @param form LoginForm.
     *  @param model Model.
     *  @return String 画面名.
     *  @throws Exception 例外.
     * */
    @RequestMapping(method = RequestMethod.POST)
    public String login(final LoginForm form,
            final Model model) throws Exception {

        boolean login = loginService.login(form);

        // 認証エラーの場合
        if (!login) {
            model.addAttribute("loginCheck", "fail");
        }

        return "Login";
    }


}
