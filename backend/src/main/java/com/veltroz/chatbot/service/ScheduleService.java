
package com.veltroz.chatbot.service;

import com.veltroz.chatbot.dto.ScheduleCallRequest;
import com.veltroz.chatbot.model.ScheduleCall;
import com.veltroz.chatbot.repository.ScheduleCallRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ScheduleService {

    private final ScheduleCallRepository scheduleCallRepository;
    private final EmailService emailService;

    public ScheduleService(
            ScheduleCallRepository scheduleCallRepository,
            EmailService emailService
    ) {
        this.scheduleCallRepository = scheduleCallRepository;
        this.emailService = emailService;
    }

    public ScheduleCall saveRequest(
            ScheduleCallRequest request,
            String userEmail
    ) {

        ScheduleCall scheduleCall = new ScheduleCall();

        scheduleCall.setFullName(
                request.getFullName()
        );

        scheduleCall.setContactEmail(
                request.getEmail()
        );

        scheduleCall.setPhone(
                request.getPhone()
        );

        scheduleCall.setMessage(
                request.getMessage()
        );

        scheduleCall.setUserEmail(
                userEmail
        );

        scheduleCall.setCreatedAt(
                Instant.now()
        );
        scheduleCall.setScheduledTime(
    request.getScheduledTime()
);

        ScheduleCall savedCall =
                scheduleCallRepository.save(
                        scheduleCall
                );

        try {

            String subject =
                    "New Schedule Call Request - Veltroz";

            String body =
                    "A new schedule request has been submitted.\n\n" +

                    "Name: " +
                    request.getFullName() +
                    "\n\n" +

                    "Email: " +
                    request.getEmail() +
                    "\n\n" +

                    "Phone: " +
                    request.getPhone() +
                    "\n\n" +

                    "Message: " +
                    request.getMessage() +
                    "\n\n" +
"\n\nPreferred Meeting Time: " +
request.getScheduledTime()+

                    "Submitted At: " +
                    Instant.now();

            emailService.sendAdminNotification(
                    subject,
                    body
            );

        } catch (Exception ex) {

            ex.printStackTrace();

            // Do not fail scheduling if email fails
        }

        return savedCall;
    }
}

