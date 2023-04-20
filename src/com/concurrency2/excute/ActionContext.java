package src.com.concurrency2.excute;

public final class ActionContext {

    private static final ThreadLocal<Context> threadlocal = new ThreadLocal<Context>() {

        @Override
        protected Context initialValue(){
            return new Context();
        }
    };

    private static class ContextHolder{
        private final static ActionContext actionContext = new ActionContext();
    }
    public static ActionContext getActionContext(){
        return ContextHolder.actionContext;
    }

    public Context getContext(){
        return threadlocal.get();
    }
}
