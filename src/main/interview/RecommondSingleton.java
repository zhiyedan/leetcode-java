package interview;

// 双检查锁机制
public class RecommondSingleton {
    //TODO 必须家volatile字段
    volatile private static RecommondSingleton singleton;
    private RecommondSingleton(){}

    public static RecommondSingleton getInstance(){
        if(singleton == null){
            synchronized(RecommondSingleton.class){
                if(singleton == null){
                    singleton = new RecommondSingleton();
                }
            }
        }
        return singleton;
    }
}
