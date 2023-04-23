package com.lsw.management.admin.model.vo.project;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @Author: lsw
 * @desc
 * @date: 2023/4/22  21:37
 */
@Data
public class ProjectVo {
    private Integer id ;

    /**
     * 毕设题目
     */
    private String title;


    /**
     * 毕设状态
     */
    private Integer status ;

    /**
     * 项目开始时间
     */
    @TableField("start_date")
    private Date startDate ;

    /**
     * 项目结束时间
     */
    @TableField("end_date")
    private Date endDate ;

    @TableField("student_id")
   private Integer studentId;

    @TableField("student_username")
   private String studentUsername;

    @TableField("student_name")
   private String studentName;

    @TableField("student_gender")
   private Integer studentGender;

    @TableField("teacher_id")
   private Integer teacherId;

    @TableField("teacher_username")
   private String teacherUsername;

    @TableField("teacher_name")
   private String teacherName;

    @TableField("teacher_gender")
   private String  teacherGender;
}
