package com.example.pj1.form.login;

/** ログインform. */
public class LoginForm {

    /** ユーザID. */
    private String userId;

    /** パスワード. */
    private String password;

    /**
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userIdP String
     */
    public final void setUserId(final String userIdP) {
        userId = userIdP;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param passwordP String
     */
    public void setPassword(final String passwordP) {
        password = passwordP;
    }
}
