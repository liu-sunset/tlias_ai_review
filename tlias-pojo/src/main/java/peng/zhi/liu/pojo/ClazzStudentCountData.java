package peng.zhi.liu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzStudentCountData {
    private List<Object> clazzList;
    private List<Object> dataList;
}
