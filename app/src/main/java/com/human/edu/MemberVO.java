package com.human.edu;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kimilguk on 2021-04-13.
 */
public class MemberVO {
    @SerializedName("user_id")//Json 데이터의 Key와 같은 명칭
    public String user_id;
    //@SerializedName("user_pw")//Json 데이터의 Key와 같은 명칭
    //public String user_pw;
    @SerializedName("user_name")//Json 데이터의 Key와 같은 명칭
    public String user_name;
    @SerializedName("email")//Json 데이터의 Key와 같은 명칭
    public String email;
    //@SerializedName("point")//Json 데이터의 Key와 같은 명칭
    //public int point;
    //@SerializedName("enabled")//Json 데이터의 Key와 같은 명칭
    //public boolean enabled;
    @SerializedName("level")//Json 데이터의 Key와 같은 명칭
    public String level;

    public MemberVO(String p_id, String p_name, String p_email) {
        this.user_id = p_id;
        this.user_name = p_name;
        this.email = p_email;
    }
    //@SerializedName("reg_date")//Json 데이터의 Key와 같은 명칭
    //public Date reg_date;
    //@SerializedName("update_date")//Json 데이터의 Key와 같은 명칭
    //public Date update_date;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
