package at.refugeescode.mylisttodoUi.view;

import at.refugeescode.mylisttodoUi.model.Todo;
import at.refugeescode.mylisttodoUi.service.TodoMaker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class Endpoint {


    private TodoMaker todoMaker;

    private String id;

    public Endpoint(TodoMaker todoMaker) {
        this.todoMaker = todoMaker;
    }

    @GetMapping
    String get(){
        return "home";
    }

    @PostMapping("/{id}/done")
    public String markDone(@PathVariable String id) {
        todoMaker.updateToDone(id);
        return "redirect:/";
    }

    @PostMapping("/{id}/undone")
    public String markunDone(@PathVariable String id) {
        todoMaker.updateToUnDone(id);
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id){
        todoMaker.delete(id);
        return "redirect:/";
    }

    @PostMapping("/addtasks")
    public String addtasks(Todo todo){
        todoMaker.addSentences(todo);
        return "redirect:/";
    }

    @ModelAttribute("todos")
    List<Todo> getToDo() {
        return todoMaker.getToDoList();
    }

    @ModelAttribute("todo")
    Todo getSomething(){
        return new Todo();
    }
}
