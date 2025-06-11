package peng.zhi.liu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpJobData {
    private List<Object> jobList;
    private List<Object> dataList;
}
