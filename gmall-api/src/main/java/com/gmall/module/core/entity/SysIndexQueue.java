package com.gmall.module.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 实体类
 * @author by imall core generator
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysIndexQueue implements Serializable {
    public static final String SYS_INDEX_QUEUE_ID = "sysIndexQueueId";
    public static final String SYS_INDEX_OBJECT_TYPE_CODE = "sysIndexObjectTypeCode";
    public static final String SYS_OBJECT_ID = "sysObjectId";
    private Long sysIndexQueueId;
    /** SYS_INDEX_OBJECT_TYPE_CODE - 索引名称 */

    private String sysIndexObjectTypeCode;
    /** SYS_OBJECT_ID - 对象id */
    private Long sysObjectId;


}