package com.demoMuty.helloRS.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author booleanjava
 * @since 2019-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

private static final long serialVersionUID=1L;

    private String name;

    private String pass;

    /**
     * 数字测试 默认1
     */
    private Integer number;


}
