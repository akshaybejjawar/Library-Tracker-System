package notification;

import model.Member;

public interface Notifier {

    void notifyMember(Member member, String message);

}