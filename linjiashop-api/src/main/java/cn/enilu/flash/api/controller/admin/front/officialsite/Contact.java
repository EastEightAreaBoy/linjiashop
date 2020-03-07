package cn.enilu.flash.api.controller.admin.front.officialsite;

import lombok.Data;

import java.util.Date;

@Data
public class Contact {
    public String username;
    private String email;
    private String mobile;
    private String description;
    private Date createAt;
}
