package bg.tuvarna.si.ticketcenterl.controllers;

import bg.tuvarna.si.ticketcenterl.entities.Notification;
import bg.tuvarna.si.ticketcenterl.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {
    //@Autowired
    private final NotificationService notificationService;

    @PostMapping
    public Notification createNotification(@RequestBody Notification notification){
        return notificationService.createNotification(notification);
    }

    @GetMapping
    public List<Notification> findAllNotifications(){
        return notificationService.findAllNotifications();
    }

    @GetMapping("{id}")
    public Notification findNotificationById(@PathVariable Integer id){
        return notificationService.findNotificationById(id);
    }

    @GetMapping("{seen}")
    public List<Notification> findNotificationByStatus(@PathVariable Boolean seen){
        return  notificationService.findNotificationByStatus(seen);
    }

    @DeleteMapping("{id}")
    public void deleteNotification(@PathVariable Integer id){
        notificationService.deleteNotification(id);
    }


}

