        package com.gmall.module.system.entity;

import com.gmall.base.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

        /**
         * SYS_USER【用户】实体类
         * @author by imall core generator
         * @version 1.0.0
         */
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public class User implements Serializable {
            public static final String SYS_USER_ID = "sysUserId";
            public static final String EMPLOYEE_CODE = "employeeCode";
            public static final String LOGIN_ID = "loginId";
            public static final String REAL_NAME = "realName";
            public static final String EMAIL = "email";
            public static final String MOBILE = "mobile";
            public static final String PASSWORD = "password";
            public static final String SEX = "sex";
            public static final String SALT = "salt";
            public static final String IF_ALLOW_LOGIN = "ifAllowLogin";
            public static final String IS_DELETED = "isDeleted";
            public static final String MARK = "mark";
            public static final String CREATE_DATE = "createDate";
            public static final String CREATE_BY = "createBy";
            public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
            public static final String LAST_MODIFIED_BY = "lastModifiedBy";
            public static final String CHAIN_ID = "chainId";
            public static final String IS_DEFAULT_USER = "isDefaultUser";
            public static final String SHOP_ID = "shopId";
            public static final String ICON_FILE_ID = "iconFileId";
            public static final String PLATFORM_TYPE = "platformType";
            public static final String OPEN_ID = "openId";

            /** SYS_USER_ID - 用户ID */

            @TableId
            private Long sysUserId;
            /** EMPLOYEE_CODE - 员工编号 */


            private String employeeCode;
            /** LOGIN_ID - 登录 ID */


            private String loginId;
            /** REAL_NAME - 真实姓名 */


            private String realName;
            /** EMAIL - 邮箱 */


            private String email;
            /** MOBILE - 手机号 */


            private String mobile;
            /** PASSWORD - 密码 */


            private String password;
            /** SEX - 性别 */


            private String sex;
            /** SALT - 加密密码时使用的种子 */


            private String salt;
            /** IF_ALLOW_LOGIN - 是否允许登陆 */


            private String ifAllowLogin;
            /** IS_DELETED - 是否删除 */


            private String isDeleted;
            /** MARK - 备注 */


            private String mark;
            /** CREATE_DATE - 创建日期 */


            private java.util.Date createDate;
            /** CREATE_BY - 创建人 */


            private Long createBy;
            /** LAST_MODIFIED_DATE - 更新时间 */


            private java.util.Date lastModifiedDate;
            /** LAST_MODIFIED_BY - 更新用户 */


            private Long lastModifiedBy;
            /** CHAIN_ID - 连锁ID */


            private Long chainId;
            /** IS_DEFAULT_USER - 是否默认账号 */


            private String isDefaultUser;
            /** SHOP_ID - 店铺ID */


            private Long shopId;
            /** ICON_FILE_ID - 头像 文件 ID */


            private String iconFileId;
            /** PLATFORM_TYPE - 平台类型 */


            private String platformType;
            /** OPEN_ID - 微信OPEN_ID */


            private String openId;


        }