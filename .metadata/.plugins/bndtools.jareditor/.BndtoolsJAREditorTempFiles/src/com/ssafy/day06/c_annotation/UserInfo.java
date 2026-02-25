package com.ssafy.day06.c_annotation;
// TODO: 03. email, password, salary에 @ValidationCheck를 적용해보세요.
public class UserInfo {
    private String name;
    private String email;
    private String password;
    private int salary;

    public UserInfo(String name, String email, String password, int salary) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "UserInfo [name=" + name + ", email=" + email + ", password=" + password + ", salary=" + salary + "]";
    }

}
