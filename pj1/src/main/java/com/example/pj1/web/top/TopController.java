package com.example.pj1.web.top;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** トップコントローラー. */
@Controller
@RequestMapping("/top")
public class TopController {

    /** 画面表示用タイトル. */
    @Value("${title.top}")
    private String title;

    /**
     * GETリクエスト(初期表示用).
     *  @param model Model.
     *  @return String 画面名.
     *  @throws Exception 例外.
     * */
    @RequestMapping(method = RequestMethod.GET)
    public String testController(
            final Model model) throws Exception {

        model.addAttribute("title", title);

        return "Top";
    }
}
