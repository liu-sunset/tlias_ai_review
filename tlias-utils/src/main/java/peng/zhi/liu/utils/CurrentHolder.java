package peng.zhi.liu.utils;

public class CurrentHolder {
    private static final ThreadLocal<Integer> CURRENT_LOCAL = new ThreadLocal<>();

    public static void setCurrentLocal(Integer id){
        CURRENT_LOCAL.set(id);
    }

    public static Integer getCurrentLocal(){
        return CURRENT_LOCAL.get();
    }

    public static void removeCurrentLocal(){
        CURRENT_LOCAL.remove();
    }
}
