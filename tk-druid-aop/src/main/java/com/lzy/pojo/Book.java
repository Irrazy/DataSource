package com.lzy.pojo;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * book
 * @author lianzhengying
 * @date 2022-01-06 14:41:01
 */
@Data
public class Book implements Serializable {
    /**
     */
    @Id
    private Long bid;

    /**
     */
    private String bname;

    /**
     */
    private Long bcount;

    /**
     */
    private String bauthor;

    private static final long serialVersionUID = 1L;
}