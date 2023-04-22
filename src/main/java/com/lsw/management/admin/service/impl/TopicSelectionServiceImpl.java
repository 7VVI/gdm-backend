package com.lsw.management.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsw.management.admin.mapper.TopicSelectionMapper;
import com.lsw.management.admin.mapper.UserInfoMapper;
import com.lsw.management.admin.model.dto.topicselection.TopicSelectionAddDto;
import com.lsw.management.admin.model.dto.topicselection.TopicSelectionQueryDto;
import com.lsw.management.admin.model.dto.topicselection.TopicSelectionUpdateDto;
import com.lsw.management.admin.model.po.TopicSelection;
import com.lsw.management.admin.model.po.UserAccount;
import com.lsw.management.admin.model.po.UserInfo;
import com.lsw.management.admin.model.vo.topicselection.TopicSelectionVo;
import com.lsw.management.admin.service.TopicSelectionService;
import com.lsw.management.admin.service.UserAccountService;
import com.lsw.management.common.constants.ErrorCode;
import com.lsw.management.common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author lsw
 * @Date 2023/4/7 12:17
 * @desc
 */
@Service
public class TopicSelectionServiceImpl extends ServiceImpl<TopicSelectionMapper, TopicSelection>
        implements TopicSelectionService {

    @Resource
    private TopicSelectionMapper topicSelectionMapper;

    @Resource
    private UserAccountService userAccountService;

    @Resource
    UserInfoMapper userInfoMapper;

    @Override
    public Integer topicSelectionAdd(TopicSelectionAddDto addDto, HttpServletRequest request) {
        TopicSelection topicSelection = new TopicSelection();
        BeanUtils.copyProperties(addDto, topicSelection);
        topicSelection.setCreateTime(new Date());
        //查询教师职称
        UserAccount currentUser = userAccountService.getCurrentUser(request);
        topicSelection.setTeacher(currentUser.getUsername());
        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
        userInfoQueryWrapper.eq(UserInfo.ACCOUNT_ID,currentUser.getId());
        final UserInfo userInfo = userInfoMapper.selectOne(userInfoQueryWrapper);
        topicSelection.setProfessional(userInfo.getProfessional());
        return topicSelectionMapper.insert(topicSelection);
    }

    @Override
    public Integer topicSelectionDelete(String ids) {
        if(StringUtils.isBlank(ids)){
            throw new BusinessException(ErrorCode.INVALID_PARAMS);
        }
        String[] idArray = ids.split(",");
       return topicSelectionMapper.deleteBatchIds(Arrays.asList(idArray));
    }

    @Override
    public Integer topicSelectionUpdate(TopicSelectionUpdateDto updateDto) {
        TopicSelection topicSelection = new TopicSelection();
        BeanUtils.copyProperties(updateDto,topicSelection);
        topicSelection.setUpdateTime(new Date());
        return topicSelectionMapper.updateById(topicSelection);
    }

    @Override
    public List<TopicSelectionVo> topicSelectionPageList(Page<TopicSelectionVo> page, TopicSelectionQueryDto queryDto) {

        QueryWrapper<TopicSelection> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("topic_selection.id,topic_selection.title" +
                        ",topic_selection.teacher,topic_selection.professional," +
                        "topic_selection.major,topic_selection.student_type,topic_selection.student_num")
                .eq("topic_selection.deleted", 0)
                .eq(queryDto.getMajor()!=null,"topic_selection.major",queryDto.getMajor())
                .eq(queryDto.getStudentType()!=null,"topic_selection.student_type",queryDto.getStudentType())
                .eq(queryDto.getTeacher()!=null,"topic_selection.teacher",queryDto.getTeacher())
                .like(StringUtils.isNotBlank(queryDto.getTitle()),"topic_selection.title",queryDto.getTitle())
                .orderByDesc("topic_selection.create_time");
        return topicSelectionMapper.selectopicSelectionPage(page, queryWrapper);
    }
}




