package peng.zhi.liu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
        private  Integer id;
        private String username;
        private String password;
        private String name;
        private Integer gender;
        private String phone;
        private Integer job;
        private Integer salary;
        private String image;
        private LocalDate entryDate;
        private Integer deptId;
        private LocalDateTime createTime;
        private LocalDateTime updateTime;

        //部门名称
        private String deptName;

        //员工的工作经历信息
        private List<EmpExpr> exprList;
}
