package br.com.lucasdantas.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.coyote.Response;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {
   @Autowired
    private ITaskRepository taskRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
       taskModel.setIdUser((UUID) request.getAttribute("idUser"));
       
       var currentDate = LocalDateTime.now();
       
       if(currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt())){
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de início / término deve ser maior que a data atual");
       }

      if(taskModel.getStartAt().isAfter(taskModel.getEndAt())){
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de início deve ser menor que a data de término");
       }

       var task = this.taskRepository.save(taskModel);
       return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @GetMapping("/")
    public List<TaskModel> list(HttpServletRequest request){
      var tasks = this.taskRepository.findByIdUser((UUID) request.getAttribute("idUser"));
      return tasks;
   }
}
