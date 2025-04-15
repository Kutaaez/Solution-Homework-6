package behavioral.chain;

public class SeniorSupportHandler extends SupportHandler {
    @Override
    protected boolean canHandle(String issue) {
        return issue.equals("account_ban") || issue.equals("data_loss");
    }
}
