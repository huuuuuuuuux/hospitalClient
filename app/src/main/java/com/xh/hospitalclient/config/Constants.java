package com.xh.hospitalclient.config;

//一些常量
public class Constants {
    public static final String BASE_URL = "http://192.168.31.68:8080/hospitalServer/";
    public static class UrlOrigin {
        public static final String login = "user/Login";
        public static final String register = "user/Register";
        public static final String getReportList = "report/getUserReport";
        public static final String getDepartmentList = "department/getAllDept";
        public static final String getDoctorList = "doctor/getDrByDept";
        public static final String getScheduleList = "schedule/getSchByDept";
        public static final String registration = "registration/newRegister";

    }
}


