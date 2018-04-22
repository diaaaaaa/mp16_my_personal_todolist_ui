package at.refugeescode.mylisttodo.endPoint;

import at.refugeescode.mylisttodo.model.Todo;
import at.refugeescode.mylisttodo.persistence.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/todos")
@RestController
public class TodoEndpoint {

    private Repository repository ;

    public TodoEndpoint(Repository repository) {
        this.repository = repository;
    }

    @PostMapping("/addtasks")
    String addTodo(@RequestBody String todo){
        repository.save(new Todo(todo,false));
        return todo;
    }

    @GetMapping
    List<Todo> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Todo findById(@PathVariable String id){
        return repository.findById(id).get();
    }

    @PutMapping("/{id}/done")
    Todo makeDone(@PathVariable String id){
        Todo todo = repository.findById(id).get();
        todo.setDone(true);
        repository.save(todo);
        return todo;
    }

    @PutMapping("/{id}/undone")
    Todo makeunDone(@PathVariable String id){
        Todo todo = repository.findById(id).get();
        todo.setDone(false);
        repository.save(todo);
        return todo;
    }

    @DeleteMapping("/{id}/delete")
    void deleteTodo(@PathVariable String id) {
        if (repository.existsById(id)) {
            Todo todo = repository.findById(id).get();
            repository.delete(todo);
        }
    }



}
