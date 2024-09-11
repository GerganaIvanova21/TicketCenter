package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.entities.Notification;
import bg.tuvarna.si.ticketcenterl.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@ReadingConverter
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public Notification findNotificationById(Integer id){
        return notificationRepository.findNotificationById(id);
    }

    public List<Notification> findAllNotifications(){
        return notificationRepository.findAll();
    }

    public List<Notification> findNotificationByStatus(Boolean seen){
        return notificationRepository.findNotificationBySeen(seen);
    }

    public void deleteNotification(Integer id){
        notificationRepository.deleteById(id);
    }

    public Notification createNotification(Notification notification){
        return notificationRepository.save(notification);
    }
}
