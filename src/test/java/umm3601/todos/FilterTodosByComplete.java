package umm3601.todos;

import org.junit.Test;
import umm3601.todos.Todos;
import umm3601.todos.TodosController;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;

public class FilterTodosByComplete {
    @Test
    public void filterTodosByComplete() throws IOException {
        TodosController todosController = new TodosController();
        Todos[] allTodos = todosController.listTodos(new HashMap<>());
        Todos[] CompleteTodos = todosController.filterTodosByComplete(allTodos, true);
        assertEquals("Incorrect number of todos for true", 143, CompleteTodos.length);
        Todos[] IncompleteTodos = todosController.filterTodosByInComplete(allTodos, false);
        assertEquals("Incorrect number of todos for false", 157, IncompleteTodos.length);
    }

}