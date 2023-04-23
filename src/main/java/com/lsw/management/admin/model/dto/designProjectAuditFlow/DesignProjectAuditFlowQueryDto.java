package com.lsw.management.admin.model.dto.designProjectAuditFlow;

import com.lsw.management.admin.model.dto.PageRequest;
import lombok.Data;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/23  20:24
 */
@Data
public class DesignProjectAuditFlowQueryDto extends PageRequest {
    private Integer state ;
    private String departmentAuditUserName;
    private String schoolAuditUserName;
}
