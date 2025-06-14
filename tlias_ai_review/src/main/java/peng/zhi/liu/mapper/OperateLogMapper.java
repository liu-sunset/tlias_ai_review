package peng.zhi.liu.mapper;

import org.apache.ibatis.annotations.Mapper;
import peng.zhi.liu.pojo.OperateLog;

@Mapper
public interface OperateLogMapper {
    //添加操作日志
    public void addOperateLogMapper(OperateLog operateLog);
}
