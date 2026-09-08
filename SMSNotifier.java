package notification;

import model.Member;

public class SMSNotifier implements Notifier {

    @Override
    public void notifyMember(Member member, String message) {
        System.out.println("SMS sent to " + member.getPhone() + ": " + message);
    }

}