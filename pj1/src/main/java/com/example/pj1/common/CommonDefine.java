package com.example.pj1.common;

/** CommonDefine. */
public final class CommonDefine {

    /** コンストラクター. */
    private CommonDefine() { }

    /** ログイン認証用SQL. */
    public static final String USER_AUTH_QUERY =
            "select password from account where user_id = ?";

    /** ログイン認証用SQL. */
    public static final String USER_ROLE_QUERY =
            "select user_role from account where user_id = ?";
}
