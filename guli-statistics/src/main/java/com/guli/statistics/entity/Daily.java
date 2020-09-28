package com.guli.statistics.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 网站统计日数据
 * </p>
 *
 * @author testjava
 * @since 2020-06-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("statistics_daily")
@ApiModel(value="Daily对象", description="网站统计日数据")
public class Daily implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      @TableId(value = "id", type = IdType.ID_WORKER)
    private String id;

    @ApiModelProperty(value = "统计日期")
    private String dateCalculated;

    @ApiModelProperty(value = "注册人数")
    private Integer registerNum;

    @ApiModelProperty(value = "登录人数")
    private Integer loginNum;

    @ApiModelProperty(value = "每日播放视频数")
    private Integer videoViewNum;

    @ApiModelProperty(value = "每日新增课程数")
    private Integer courseNum;
    @ApiModelProperty(value = "创建时间",example = "2018-6-1 21:00:08")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间",example = "2018-6-1 21:55:08")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}