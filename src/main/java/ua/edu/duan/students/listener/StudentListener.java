package ua.edu.duan.students.listener;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class StudentListener {

    @RabbitListener(queues = "student")
    public void readStudentQueue(String message){
        System.out.println(message);
    }
}
