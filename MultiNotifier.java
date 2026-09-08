package notification;

import model.Member;

public class MultiNotifier implements Notifier {

    private Notifier emailNotifier;
    private Notifier smsNotifier;

    public MultiNotifier() {
        emailNotifier = new EmailNotifier();
        smsNotifier = new SMSNotifier();
    }

    @Override
    public void notifyMember(Member member, String message) {
        emailNotifier.notifyMember(member, message);
        smsNotifier.notifyMember(member, message);
    }

}