package umm3601.todos;

import org.junit.Test;
import umm3601.todos.Todos;
import umm3601.todos.TodosController;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;

public class FilterTodosByContains {
    @Test
    public void filterTodosByContains() throws IOException {
        TodosController todosController = new TodosController();
        Todos[] allTodos = todosController.listTodos(new HashMap<>());
        Todos[] BananaTodos = todosController.filterTodosByWord(allTodos, "banana");
        assertEquals("Incorrect number of todos that contains esse in their body", 0, BananaTodos.length);
        Todos[] ReprehenderitTodos = todosController.filterTodosByWord(allTodos, "Reprehenderit");
        assertEquals("Incorrect number of todos that contains Reprehenderit in their body", 14, ReprehenderitTodos.length);
    }

}

