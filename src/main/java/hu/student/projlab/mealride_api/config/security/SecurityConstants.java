package hu.student.projlab.mealride_api.config.security;

public class SecurityConstants {

    public static final String SECRET = "SecretMealRideKeyGenerator";
    public static final int EXPIRATION_TIME = 36_000_000; // 1 hour
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/sign-up";

}
