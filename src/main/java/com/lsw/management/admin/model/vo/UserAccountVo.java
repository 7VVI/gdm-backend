package com.lsw.management.admin.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangyh
 * @Date 2023/4/6 16:37
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountVo {

    private Integer id;

    private String username;

    private Integer state;
}
