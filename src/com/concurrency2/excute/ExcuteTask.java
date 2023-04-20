package src.com.concurrency2.excute;

import javax.management.Query;

public class ExcuteTask implements Runnable{

    private QueryFromDBAction queryAction = new QueryFromDBAction();

    private QueryFromHttpAction httpAction = new QueryFromHttpAction();
    @Override
    public void run() {

        Context context = ActionContext.getActionContext().getContext();
        //final Context context = new Context();
        queryAction.excute();
        System.out.println("The name query successful");
        httpAction.excute();
        System.out.println("The card id query successful");
        System.out.println("The name is " + context.getName() + " and cardId" + context.getCardId());
    }
}
