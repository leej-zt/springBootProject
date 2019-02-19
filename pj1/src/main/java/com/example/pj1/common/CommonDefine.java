package com.example.pj1.common;

public final class CommonDefine {

	public static final String USER_AUTH_QUERY =
			"select password from account where user_id = ?";

	public static final String USER_ROLE_QUERY =
			"select user_role from account where user_id = ?";
}
