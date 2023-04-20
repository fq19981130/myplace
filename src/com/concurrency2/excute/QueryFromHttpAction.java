package src.com.concurrency2.excute;

public class QueryFromHttpAction {

    public void excute(){
        Context context = ActionContext.getActionContext().getContext();
        String name = context.getName();
        String cardId = getCardId(name);
        context.setcarId(cardId);
    }
    private String getCardId(String name){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "小欢是个蠢材" + Thread.currentThread().getId();
    }
}
