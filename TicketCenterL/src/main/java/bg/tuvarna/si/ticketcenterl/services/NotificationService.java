package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.entities.Notification;
import bg.tuvarna.si.ticketcenterl.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@ReadingConverter
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    private Notification findNotificationById(Integer id){
        return notificationRepository.findNotificationById(id);
    }

    private List<Notification> findAllNotifications(){
        return notificationRepository.findAll();
    }

    private List<Notification> findNotificationByStatus(Boolean seen){
        return notificationRepository.findNotificationByStatus(seen);
    }

    private void deleteNotification(Integer id){
        notificationRepository.deleteById(id);
    }

    public void sendNotification(Notification notification) {
        notificationRepository.save(notification);
    }
}
