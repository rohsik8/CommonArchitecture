package com.view9.couriercustomer.utils;


public class Constants {




    public static final String BASE_URL = "http://dev.view9.us/vep/api/v1/";

    public static final String LOG_TAG = "PADLOKT_DEBUG";
    public static final String HTTP_DIR_CACHE = "vep";
    public static final int CACHE_SIZE = 10 * 1024 * 1024;
    public static final String PREFERENCE_NAME = "courierCustomer_sh";
    public static final String TOKEN = "token";
    public static final String COOKIE = "cookie";
    public static final String USERID = "userid";

    public static final String FIRSTNAME = "firstname";
    public static final String USERIMAGE = "userimage";

    public static final String LASTNAME = "lastname";

    public static final String EMAIL = "email";

    public static final String MOBILE = "mobile";

    public static final String REFERENCE = "reference";

    public static final String COUNTRY = "country";

    public static final String AVATERIMAGE = "avatarimage";
    public static final String PROFILEIMAGESetting = "profileimage";


    public static final String REGISTER = BASE_URL + "user/register";
    public static final String LOGIN = BASE_URL + "user/login";
    public static final String LOGOUT = BASE_URL + "user/logout";
    public static final String VERIFYCODE = BASE_URL + "verify";

    public static final String SUBJECTS = BASE_URL + "subjects";
    public static final String EXAMMODELSET = BASE_URL + "sets";
    public static final String RECENTLEARNING = BASE_URL + "recentlearning";
    public static final String QUESTIONS = BASE_URL + "questionsonline/{nid}";
    public static final String EXAMCOMPLETED = BASE_URL + "completeset/{nid}";
    public static final String RECENTLEARNINGLIST = BASE_URL + "rllisting";

}
