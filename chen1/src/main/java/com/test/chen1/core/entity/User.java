package com.test.chen1.core.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

private static final long serialVersionUID=1L;

    private String name;

    private String pass;

    /**
     * 数字测试 默认1
     */
    private Integer number;


}
