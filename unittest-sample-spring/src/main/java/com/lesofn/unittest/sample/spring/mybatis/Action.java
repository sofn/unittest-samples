package com.lesofn.unittest.sample.spring.mybatis;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Action implements Serializable {
    private Integer id;

    private String userId;

    private Integer actionType;

    private String title;

    private String description;

    private Date createTime;

    private Date updateTime;

}