package com.lzy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lzy
 * @since 2021-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
//@TableName(autoResultMap = true, value = "book",schema = "public")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "bid", type = IdType.AUTO)
    private Long bid;

    private String bname;

    private Long bcount;

    private String bauthor;


}
