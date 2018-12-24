package com.vic.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author vic
 * @since 2018-10-27
 */
@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Test implements Serializable {

//    private static final long serialVersionUID = 1L;

    private Long id;

    private Long count;

    @TableField("modifyTime")
    private LocalDateTime modifyTime;


}
