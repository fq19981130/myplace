package src.com.concurrency2.Obdesign;

import sun.plugin.viewer.LifeCycleManager;

public abstract class ObserverRunnable implements Runnable {

    final protected LifeCycleListener listener;

    public ObserverRunnable(final LifeCycleListener listener) {
        this.listener = listener;
    }

    protected void notifyChange(final RunnableEvent event) {
        listener.onEvent(event);
    }

    public enum RunnableState {
        RUNNING, ERROR, DONE;
    }

    public static class RunnableEvent {
        private final RunnableState state;//定义状态

        private final Thread thread;//定义线程

        private final Throwable cause;//定义错误

        public RunnableEvent(RunnableState state, Thread thread, Throwable cause) {
            this.state = state;
            this.thread = thread;
            this.cause = cause;
        }

        public RunnableState getState() {
            return state;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return cause;
        }
    }
}
