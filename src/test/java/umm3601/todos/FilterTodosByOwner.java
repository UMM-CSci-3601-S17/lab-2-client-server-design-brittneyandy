package umm3601.todos;

import org.junit.Test;
import umm3601.todos.Todos;
import umm3601.todos.TodosController;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;

public class FilterTodosByOwner {

    @Test
    public void filterTodosByOwner() throws IOException {
        TodosController todosController = new TodosController();
        Todos[] allTodos = todosController.listTodos(new HashMap<>());
        Todos[] BlancheTodos = todosController.filterTodosByOwner(allTodos, "Blanche");
        assertEquals("Incorrect number of todos for Blanche", 43, BlancheTodos.length);
        Todos[] FryTodos = todosController.filterTodosByOwner(allTodos, "Fry");
        assertEquals("Incorrect number of todos for Fry", 61, FryTodos.length);
    }
}
