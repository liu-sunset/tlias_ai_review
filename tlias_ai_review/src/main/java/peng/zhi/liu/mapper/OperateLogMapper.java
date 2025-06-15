package peng.zhi.liu.mapper;

import org.apache.ibatis.annotations.Mapper;
import peng.zhi.liu.pojo.OperateLog;

import java.util.List;

@Mapper
public interface OperateLogMapper {
    //添加操作日志
    public void addOperateLogMapper(OperateLog operateLog);
    //分页查询日志列表
    public List<OperateLog> selectLogPageMapper();
}
